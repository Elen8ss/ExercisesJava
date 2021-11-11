package entidade;

public class Ticket {
    private int numero;
    private float valor;
    private boolean status;

    //sequencial
    private static int seqNumero = 1;

    /**
     * Construtor recebendo valor de máquina
     * @param valor
     */
    public Ticket(float valor) {
        this.valor = valor;
        status = false;
        this.numero = seqNumero ++;
    }

    /**
     * Permite pagar ticket
     */
    public void mudarStatus() {
        this.status = true;
    }

    /**
     * Retorna o valor quando ticket pago
     * @return
     */
    public float obtemSaldo(){
        if (status)
            return valor;
        return 0;
    }

    public int getNumero() {
        return numero;
    }

    public float getValor() {
        return valor;
    }

    public boolean getStatus() {
        return status;
    }
}
