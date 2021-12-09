package BackEnd;
import java.util.ArrayList;

import Entity.Exercises.*;
import Entity.Reports.ReportDay;
import Entity.User.*;

public class BackEndUser {
    private ArrayList<Exercise> exercises;
    private User user;
    private ArrayList<ReportDay> reports;

    // Contrutor que recebe os parametros da classe User para inicaliza-lá
    public BackEndUser(float height, float weight, float fatPercentage) {
        user = new User(height, weight, fatPercentage);
        exercises = new ArrayList<>();
        reports = new ArrayList<>();

        exercises.add(new Abs());
        exercises.add(new Squats());
        exercises.add(new PushUps());
        exercises.add(new Bridge());
        exercises.add(new Burpees());
    }

    // Retorna o nome de todos os exercícos em array
    public String[] listExercises() {
        String[] nameExercises = new String[exercises.size()];
        for (int i = 0; i < exercises.size(); i++) {
            nameExercises[i] = exercises.get(i).getName();
        }
        return nameExercises;
    }

    // Recebe o tempo em minutos e cacula a quantidade de calorias
    public float calcCalories(Exercise exercise, float time) {
        return exercise.calcCalories(user.getWeight(), time);
    }
    // Procura um relatório de um dia e retorna se existir
    public ReportDay getReportyDay(String date) {
        for (ReportDay r : reports) {
            if (r.getDate().equals(date)) {
                return r;
            }
        }
        return null;
    }
    // Procura um exercício cadastrado
    public Exercise getExercise(String name) {
        for (Exercise s : exercises) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }
    // Recebe os valores referentes ao dados e os salvas no ArrayList reports
    public void generateReport(String name, String date, float time) {
        ReportDay reportDay = getReportyDay(date);
        Exercise exercise = getExercise(name);
        float calories = calcCalories(exercise, time);

        // Se essa data já estiver cadastrada o if é verdadeiro
        if (reportDay != null) {
            // Se o exercício já estiver sido cadastrado o if é verdadeiro
            if (reportDay.isExerciseRegistered(name)) {
                reportDay.addTimeAndCalories(name, time, calories);
            } else {
                reportDay.addExercises(name, time, calories);
            }
        } else {
            reports.add(new ReportDay(date, name, time, calories));
        }
    }
    // Recebe uma data e retorna todos os valores referentes ao exercicios praticados
    public String getValueReportDay(String date) {
        ReportDay reportDay = getReportyDay(date);
        if (reportDay != null) {
            return reportDay.toString();
        } else {
            return "Nenhum exercício cadastrado para esse dia";
        }
    }
}
