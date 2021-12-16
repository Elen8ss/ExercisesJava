/**
 * Trabalho 1: Dieta de exercicios
 * @authors:
 *  Edson Carlos
 *  Elen Serra
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import BackEnd.*;
import Entity.Reports.ReportDay;
import Entity.User.ListUser;
import Entity.User.User;


public class App {

    public static boolean dateIsValid(String date) {
        if (date == null) {
            return false;
        }
        //retorna um date nesse formato "dd/MM/yyyy", passando uma string como data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (date.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false); //a análise de data nao deve ser tolerante. Interpreta as entradas que não correspondem precisamente ao formato do objeto date
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException ex) {
            //se algum passo dentro do "try" der errado quer dizer que sua data é falsa, então,
            //retorna falso
            return false;
        }
        return true;
    }

    public static void menu(){
        System.out.println("\n\n======== GOOGLE FIT ========");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Resumo diario");
        System.out.println("0 - Sair");              
        System.out.println("============================");
        System.out.print("Escolha uma opcao: "); 
    }

    public static void main(String[] args) throws Exception {
        
        //criando o objeto e instanciando a classe User
        User newUser = new User();

        //criando o objeto e instanciando a classe ListUser
        ListUser listUsers = new ListUser();

        //criando o objeto e instanciando a classe ReportDay
        ReportDay reportDay = new ReportDay();

        //criando o objeto e instanciando a classe BackEndUser
        BackEndUser back = new BackEndUser();

        String nameUser, nameExercise, date, wantedDate; 
        float height, weight, fatPercentage, time, calories;
        int opcao = 1;
        
        Scanner input = new Scanner(System.in);

 
        do{

            try{
                menu();
                opcao = input.nextInt();
                input.nextLine();
                
                switch (opcao){
                    //cadastro usuario
                    case 1:
                        
                        boolean continua = true;
                        do{
                        
                            try{

                                System.out.print("\n====== CADASTRO ======");
                                System.out.println("\nDigite seu nome: ");
                                nameUser = input.nextLine();
                                System.out.println("Digite sua altura: ");
                                height = Float.parseFloat(input.nextLine());
                                System.out.println("Digite seu peso: ");
                                weight = Float.parseFloat(input.nextLine());
                                System.out.println("Fator de gordura: ");
                                fatPercentage = Float.parseFloat(input.nextLine());
                            
                                //criando o objeto, construindo ->user e passando o que foi digitado pelo teclado
                                newUser = new User(nameUser, height, weight, fatPercentage);
                    
                                //validando a data
                                do{ 
                                System.out.println("Data do exercicio (Formato: dd/mm/aaaa): ");
                                date = input.nextLine();
                                
                                }while(dateIsValid(date)==false);
                                
                                //lista os exercicios
                                String[] list;
                                list = back.listExercises();
                                System.out.println("\n----------------");
                                for (int i = 0; i < list.length; i++) {
                                    System.out.println((i+1) + "- "+list[i]);
                                }
                                System.out.println("----------------");
                                
                                do{
                                    System.out.println("\nDigite o nome do exercicio realizado: ");
                                    nameExercise = input.nextLine();
                                    nameExercise = nameExercise.toUpperCase();
                                }while(back.getExercise(nameExercise)==null);
                                

                                System.out.println("Quantos minutos? ");
                                time = Float.parseFloat(input.nextLine());
                                System.out.println("Quantas calorias foram gastas? ");
                                calories = Float.parseFloat(input.nextLine());

                                System.out.println("======================");
                                
                                //cria e instancia novo relatorio de exercicio
                                reportDay = new ReportDay(date, nameExercise, time, calories);
                                
                                newUser.insertReport(reportDay);//insere novo relatorio 

                                listUsers.insertUser(newUser); //insere na lista o novo usuario
                                
                                continua = false;
                            
                            }catch(NumberFormatException e){
                                System.out.println("\n\n>>Error. Entrada invalida<<");    
                                input.nextLine();
                            }

                        }while(continua);        
                        break;

                        //resumo diario
                        case 2:
                           
                            do{
                                System.out.print("\nDigite a data procurada: ");
                                wantedDate = input.nextLine();
                            }while(dateIsValid(wantedDate)==false);

                            System.out.println("\n\n============= RELATORIO DO DIA (" + wantedDate +") =============");
                            listUsers.consultaData(wantedDate); //busca data na lista de usuarios
                            System.out.println("=========================================================\n");

                            break;

                        //sair
                        case 0:
                            break;
                    }

                }catch(InputMismatchException e){
                    System.out.println("\n\n>>Entrada invalida. Digite um inteiro<<");
                    input.nextLine();
                }

            }while(opcao!=0);
 
    }
   
}
