import BackEnd.*;
public class App {
    public static void main(String[] args) throws Exception {
        BackEndUser back = new BackEndUser(2, 4, 4);
        String[] list;
        list = back.listExercises();
        System.out.println("");
        for (int i = 0; i < list.length; i++) {
            System.out.println((i+1) + "- "+list[i]);
        }
        
        back.generateReport(list[0], "12/2/2020", 5f);
        System.out.println(back.getValueReportDay("12/2/2020"));
        back.generateReport(list[0], "12/2/2020", 10f);
        back.generateReport(list[1], "12/2/2020", 30f);
        System.out.println(back.getValueReportDay("12/2/2020"));

    }
}
