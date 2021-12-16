package Entity.Reports;

import java.util.ArrayList;

public class ReportDay { //relatorio diario
    private String date;
    private ArrayList<ReportExercise> exercises;
    
    public ReportDay(String date, String name, float time, float calories) {
        this.date = date;
        exercises = new ArrayList<>();
        exercises.add(new ReportExercise(name, time, calories));
    }
   

    public void setName(String date) {
        this.date = date;
    }

    public ReportDay() {
    }

    public void addTimeAndCalories(String name, float time, float calories) {
        for (ReportExercise r : exercises) {
            if (r.getName().equals(name)) {
                r.setCalories(calories+r.getCalories());
                r.setTime(time+r.getTime());
            }
        }
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //adiciona no ArrayList de exercicio
    public void addExercises(String name, float time, float calories) {
        exercises.add(new ReportExercise(name, time, calories));
    }

    public ArrayList<ReportExercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<ReportExercise> exercises) {
        this.exercises = exercises;
    }
    
    public float getTimeTotal() {
        float totalTime = 0;
        for (ReportExercise r : exercises) {
            totalTime += r.getTime();
        }
        return totalTime;
    }

    public float getCaloriesTotal() {
        float totalCalories = 0;
        for (ReportExercise r : exercises) {
            totalCalories += r.getCalories();
        }
        return totalCalories;
    }

    
    @Override
    public String toString() {
        String report;
        report =  "\nData: " + this.date + "\n";
        for (ReportExercise r : exercises) {
            report += r.toString() +"\n";
           // report += "\n";
        }
        report += "\nTotal de calorias gastas: " + getCaloriesTotal() + " Kcal";
        report += "\nTempo de exercício diário: " + getTimeTotal() + " min\n";
        return report;
    }

    

}