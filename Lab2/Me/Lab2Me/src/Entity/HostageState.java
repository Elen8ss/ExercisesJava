package Entity;

public class HostageState {
    protected float income;
    protected float deductions;

    public HostageState() {
        this.income = this.deductions = 0;
    }

    public HostageState(float income, float deductions) {
        this.income = income;
        this.deductions = deductions;
    }

    public float getIncome() {
        return this.income;
    }

    public float getDeductions() {
        return this.deductions;
    }
    
    public void setIncome(float income) {
        this.income = income;
    }

    public void setDeductions(float deductions) {
        this.deductions = deductions;
    }

    public float calcTax() {
        float calcImposto = 0;
        float valor  = income - deductions;
        float tempCalc = 0;

        valor -= 22847.76;
        
        if (valor > 0) {
            // 33.919,80 - 22.847,77 = 11072,03;
            tempCalc = valor;
            if (valor > 11072.03) {
                tempCalc = 11072.03f;
            }
            calcImposto += tempCalc*0.075;
            valor -= 11072.03;
        }
          
        if (valor > 0) {
            // 45012,60 - 33919,81 = 11.092,79
            tempCalc = valor;
            if (valor > 11092.79) {
                tempCalc = 11092.79f;
            }
            calcImposto += tempCalc*0.15;
            valor -= 11092.79;
        }
                
        if (valor > 0) {
            // 55.976,16 - 45.012,61 = 10.963,55
            tempCalc = valor;
            if (valor > 10963.55) {
                tempCalc = valor;
            }
            calcImposto += tempCalc*0.225;
            valor -= 10963.55;
        }           

        if (valor > 0) {
            // > 55.976,16
            calcImposto += valor*0.275;
        }
    
        return calcImposto;
    }

    @Override
    public String toString() {
        return "Contribuinte " + "\nRenda: R$ " + income + "\nDedução: R$ " + deductions;
    }

}