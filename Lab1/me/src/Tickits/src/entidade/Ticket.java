package entidade;

public class Ticket {
    private int idTicket;
    private float valor;
    private boolean ticketPagamento;

    //Numeração do Ticket
    public static int cont = 1;

    /**
     * Construtor recebendo valor de máquina
     * @param valor
     */
    public Ticket(float valor) {
        this.valor = valor;
        this.ticketPagamento = False;
        this.idTicket = cont ++;
    }

    /**
     * recebe um estado do
     * @param ticketPagamento
     */
    public bollean Pagar(int ticketPagamento) {
        return true;
    }

    /**
     * Retorna o valor quando ticket pago
     * @return
     */
    public float obtemSaldo() {
        if (ticketPagamento) {
            return valor;
        }
        return 0;
    }

    public float getNumero() {
        return this.numero;
    }

    public float getValor() {
        return this.valor;
    }

    public boolean getTicketPagamento() {
        return this.ticketPagamento;
    }
}