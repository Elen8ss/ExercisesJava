package Entity;

public abstract class Employee {
    protected String name;
    protected String matriculation;
    protected double salaryBase;
    
    public Employee(String name, String matriculation, double salaryBase) {
        this.name = name;
        this.matriculation = matriculation;
        this.salaryBase = salaryBase;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(double salaryBase) {
        this.salaryBase = salaryBase;
    }

    public String getMatriculation() {
        return matriculation;
    }
    
    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

}