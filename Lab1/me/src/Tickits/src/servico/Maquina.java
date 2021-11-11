package servico;

import entidade.Ticket;
import java.util.ArrayList;

public class Maquina {
    private ArrayList<Ticket> unidades;
    private float valorDoTicket;

    public Maquina(float valor) {
        this.valorDoTicket = valor;
        unidades = new ArrayList<>();
    }

   /**
    * Emissão ticket -> Instacia a classe ticket, ou seja, cria os Tickets
    * @return
    */
    public Ticket criarTicket() {
        Ticket t = new Ticket(this.valorDoTicket);
        unidades.add(t);
        return t;
    }

    /**
     * Paga o ticket
     * @param numero
     * @return
     */
    public boolean pagar (int numero) {
        for (Ticket t: emissoes)
            if (t.getNumero() == numero) {
                t.mudarStatus();
                return true;
            }
        return false;
    }
}
