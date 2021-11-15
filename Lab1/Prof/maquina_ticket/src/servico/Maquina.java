package servico;

import entidade.Ticket;

import java.util.ArrayList;

public class Maquina {
    private ArrayList<Ticket> emissoes;
    private float valorFixo;

    public Maquina(float valor) {
        this.valorFixo = valor;
        emissoes = new ArrayList<>();
    }

    /**
     * Emissão de ticket
     * @return
     */
    public Ticket emitir(){
        Ticket t = new Ticket(this.valorFixo);
        emissoes.add(t);
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

    /**
     * Verifica se o ticket está pago
     * @param numero
     * @return
     */
    public boolean estaPago(int numero) {
        for (Ticket t: emissoes)
            if (t.getNumero() == numero) {
                return t.getStatus();
            }
        return false;
    }

    /**
     * Retorna o saldo de recebimento acumulado
     * @return
     */
    public float saldo () {
        float temp = 0;
        for (Ticket t: emissoes)
            temp += t.obtemSaldo();
        return temp;
    }

    public int getNumTickets() {
        int cont = 0;
        for (Ticket t : emissoes) {
            cont++;
        }
        return cont;
    }
}
