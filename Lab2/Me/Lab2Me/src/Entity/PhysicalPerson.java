package Entity;

public class PhysicalPerson extends HostageState {
    private String cpf;

    public PhysicalPerson(String cpf) {
        super();
        this.cpf = cpf;
    }
    
    public PhysicalPerson(String cpf, float income, float deductions) {
        super(income, deductions);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa Física: " + cpf +
        "\nRenda: R$ " + super.income + 
        "\nDedução: R$ " + super.deductions;
    }
}
