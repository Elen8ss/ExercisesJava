package Entity;

public class Seller extends Employee {
    private double commission;

    public Seller(String name, String matriculation, double salaryBase, double commission) {
        super(name, matriculation, salaryBase);
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return super.salaryBase * (1+(commission/100));
    }

    @Override
    public String toString() {
        return "\nFuncionário: " + name +
               "\nCargo: Vendedor" +
               "\nmatrícula: " + matriculation +
               "\nComissão: " + String.format("%.2f", commission) + "%" +
               "\nSalário: R$ " + String.format("%.2f", calculateSalary());
    }
}
