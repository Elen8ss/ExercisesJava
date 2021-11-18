package Entity;

public class LegalPerson extends HostageState {
    private String cnpj;

    public LegalPerson(String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    public LegalPerson(String cnpj, float income, float deductions) {
        super(income, deductions);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica : " + cnpj +
        "\nRenda: R$ " + super.income + 
        "\nDedução: R$ " + super.deductions;
    }
}
