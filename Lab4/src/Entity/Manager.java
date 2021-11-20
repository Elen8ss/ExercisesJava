package Entity;

public class Manager extends Employee{
    
    public Manager(String name, String matriculation, double salaryBase) {
        super(name, matriculation, salaryBase);
    }

    @Override
    public double calculateSalary() {
        return 2*super.salaryBase;
    }

    @Override
    public String toString() {
        return "\nFuncionário: " + name +
               "\nCargo: Gerente" +
               "\nmatrícula: " + matriculation +
               "\nSalário: R$ " + String.format("%.2f", calculateSalary());
    }
}
