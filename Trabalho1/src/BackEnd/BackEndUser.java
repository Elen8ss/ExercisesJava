
package BackEnd;
import java.util.ArrayList;

import Entity.Exercises.*;
import Entity.User.*;

public class BackEndUser {
    private ArrayList<Exercise> exercises;
    private User user;
   

    // Contrutor que recebe os parametros da classe Exercise para inicaliza-lá
    public BackEndUser() {
        exercises = new ArrayList<>(); //arraylist de exercicios
    
        exercises.add(new Abs());
        exercises.add(new Squats());
        exercises.add(new PushUps());
        exercises.add(new Bridge());
        exercises.add(new Burpees());
    }

    // Retorna o nome de todos os exercícos contidos no array
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

    // Procura um exercício cadastrado 
    public Exercise getExercise(String name) {
        for (Exercise s : exercises) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    
}