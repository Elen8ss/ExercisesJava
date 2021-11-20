import java.util.ArrayList;

import Entity.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Seller("Edson", "f201", 2000, 10));
        employees.add(new Assistant("Carlos", "d02f", 850.50));
        employees.add(new Manager("Costa", "0234", 2000));

        double salaryTotal = 0;
        for (Employee e : employees) {
            System.out.println(e);
            salaryTotal += e.calculateSalary();
        }
        System.out.println("\nSalário Total: R$" + String.format("%.2f", salaryTotal));
    }
}
