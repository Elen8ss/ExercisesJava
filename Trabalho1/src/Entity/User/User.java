package Entity.User;

public class User {
    private float height;
    private float weight;
    private float fatPercentage;
    
    public User(float height, float weight, float fatPercentage) {
        this.height = height;
        this.weight = weight;
        this.fatPercentage = fatPercentage;
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
}
