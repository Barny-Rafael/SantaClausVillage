package character;

import building.Building;
import enumeration.Gender;
import interfaces.Noise;
import food.Food;

public abstract class Character implements Noise {
    protected final String nom;
    protected final Gender gender;
    protected int age;
    protected int hunger;
    protected boolean resting;
    protected int christmasMagic;
    protected Building currentBuilding;

    public Character(String nom, Gender gender, int age) {
        this.nom = nom;
        this.gender = gender;
        this.age = age;
        this.hunger = 0;
        this.resting = true;
        this.christmasMagic = 0;
    }

    public void move(Building building) {
        try {
            currentBuilding.withdraw(this);
            this.currentBuilding = null;
            building.add(this);
            this.currentBuilding = building;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void makeNoise(String noise) {
        System.out.println(noise);
    }

    public void eat(Food food) {
        this.hunger = Math.max(0, this.hunger - food.getNutritionalValue());
    }

    public void restOrActivate() {
        this.resting = !resting;
    }

    public void updateMagic(int amount) {
        this.christmasMagic += amount;
    }

    public String getNom() {
        return nom;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public boolean isResting() {
        return resting;
    }

    public int getChristmasMagic() {
        return christmasMagic;
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }
}
