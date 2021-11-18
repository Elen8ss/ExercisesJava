import Entity.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        boolean isValid = true;
        Float imposto = 0f;
        System.out.println("Calculadora de imposto");
        System.out.println("Digite o cpf ou cnpj(somente so números)");
        
        // Entrada de dados
        String cpfOrCnpj = read.next();
        System.out.println("Adicione o a renda anual");
        Float income = read.nextFloat();
        System.out.println("Adicione o valor da dedução do imposto");
        Float deductions = read.nextFloat();
        read.close();

        // Escolha de pessoa física ou pessoa jurídica
        if (cpfOrCnpj.length() == 14 && income > 0 && deductions >= 0) {
            HostageState legalPerson = new LegalPerson(cpfOrCnpj, income, deductions);
            imposto = legalPerson.calcTax();
        } else if(cpfOrCnpj.length() == 11 && income > 0 && deductions >= 0) {
            HostageState physicalPerson  = new PhysicalPerson(cpfOrCnpj, income, deductions);
            imposto = physicalPerson.calcTax();
        } else {
            System.out.println("O valor do cpf ou cnpf não é válido");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Imposto: " + imposto);
        }

    }
}
