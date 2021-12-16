
package Entity.User;

import java.util.ArrayList;

public class ListUser {
    private ArrayList<User> listUser;
   
    public ListUser() {
        this.listUser = new ArrayList<>();
    }

    //insere novo usuario
    public void insertUser(User newUser){
        if (newUser != null){
            listUser.add(newUser);
        }
    }

    //lista de usuarios
    public void listUsers(){
        for (User user: listUser){
            user.listar();
        }
    }
    
    //busca data na lista de usuarios
    public void consultaData(String dataProcurada) {
        boolean achou = true;
        if (!listUser.isEmpty()) {
            for (int i = 0; i < listUser.size(); i++) {
                if(listUser.get(i).searchDate(dataProcurada)){
                    listUser.get(i).listar();
                    achou = true;
                }else{
                    achou = false;
                }
            }
            if (!achou) {
                System.out.println("Data não encontra-se nos registros!");
            }
        }else{
            System.out.println("Relatorio vazio");
        }
    }

    
}