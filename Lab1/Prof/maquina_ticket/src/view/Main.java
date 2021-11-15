package view;

import java.util.Scanner;
import servico.Maquina;

public class Main {
    public static void main(String []args) {
        int op;
        Maquina maquina = new Maquina(2);
        Scanner ler = new Scanner(System.in);
        String[] opction = {"--------------------","Emissor de tickets\n", "Selecione a operação\n","1-Emitir um ticket","2-Verificar se o ticket está pago ou não","3-Receber o pagamento do ticket","4-Consutar o saldo das operações","5-Total de tickets emitidos"};

        do {
            for (String t : opction) {
                System.out.println(t);
            }
            
            op = ler.nextInt();

            switch (op) {
                case 1:
                    maquina.emitir();
                    System.out.println("Ticket criado com sucesso");
                    // System.out.println();
                    break;
                
                case 2:
                    System.out.println("Digite o numero do ticket");
                    if (maquina.estaPago(ler.nextInt())) {
                        System.out.println("O ticket está pago");
                    } else {
                        System.out.println("O ticket não está pago ou não existe");
                    }
                    break;
                case 3:
                    System.out.println("Digite o numero do ticket");
                    if (maquina.pagar(ler.nextInt())) {
                        System.out.println("O ticket está pago");
                    } else {
                        System.out.println("O ticket ainda não foi cadastrado");
                    }
                    break;
                case 4:
                    System.out.println("Saldo= "+ maquina.saldo());
                    break;
                case 5:
                    System.out.println("Número de tickter emitidos até o momento é = "+maquina.getNumTickets());
                default:
                    if (op > 0)
                        System.out.println("Digite o valor correto.");
                    break;
            }
        } while(op > 0);

        
        //menu
        //opções

    }
}
