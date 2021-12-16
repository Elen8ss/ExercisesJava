

package Entity.User;

import java.util.ArrayList;
import Entity.Reports.ReportDay;

public class User {
    private String name;
    private float height;
    private float weight;
    private float fatPercentage;
    private ArrayList<ReportDay> listReport = new ArrayList<>(); //arrayList de relatorio diarios
  
    
    public User(String name, float height, float weight, float fatPercentage) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.fatPercentage = fatPercentage;
    }

    public User() {
    }

    //insere novo relatorio
    public void insertReport(ReportDay report){
        if (report != null){
            listReport.add(report);
        }
    }

    public ArrayList<ReportDay> getListReport() {
        return listReport;
    }

    public void setListReport(ArrayList<ReportDay> listReport) {
        this.listReport = listReport;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getFatPercentage() {
        return fatPercentage;
    }
    public void setFatPercentage(float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    //imprime os usuarios
    public void listar(){
        System.out.println("\n--------------------------------------------------");
        System.out.printf("Nome........: %s \n", name);
        System.out.printf("Altura......: %.2f \n", height);
        System.out.printf("Peso........: %.2f \n", weight);
        System.out.printf("Gordura.....: %.2f \n", fatPercentage) ; 
        for (ReportDay u: listReport ){
            System.out.println(u.toString() );
        }
        System.out.println("--------------------------------------------------\n\n");
    }


    //procura data no relatorio
    public boolean searchDate(String date) {
        for (ReportDay r : listReport) {
            if (r.getDate().equals(date)) {
                return true;
            }if (r.getDate().equalsIgnoreCase(null)){
                return false;
            }
        }
        return false;
    }
    
}