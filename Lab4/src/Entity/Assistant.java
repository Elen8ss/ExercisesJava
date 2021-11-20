package Entity;

public class Assistant extends Employee{
    public Assistant(String name, String matriculation, double salaryBase) {
        super(name, matriculation, salaryBase);
    }

    @Override
    public double calculateSalary() {
        return super.salaryBase;
    }

    @Override
    public String toString() {
        return "\nFuncionário: " + name +
               "\nCargo: Assistente" +
               "\nmatrícula: " + matriculation +
               "\nSalário: R$ " + String.format("%.2f", calculateSalary());
    }
}
