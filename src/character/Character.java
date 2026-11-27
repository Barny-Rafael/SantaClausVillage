package character;

import enumeration.Gender;
import interfaces.Noise;
import food.Food;

public abstract class Character implements Noise {
    protected String nom;
    protected Gender gender;
    protected int age;
    protected int hunger;
    protected boolean resting;
    protected int christmasMagic;

    public Character(String nom, Gender gender, int age) {
        this.nom = nom;
        this.gender = gender;
        this.age = age;
        this.hunger = 0;
        this.resting = true;
        this.christmasMagic = 0;
    }

    public abstract void move();

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isResting() {
        return resting;
    }

    public int getChristmasMagic() {
        return christmasMagic;
    }

    public void setChristmasMagic(int christmasMagic) {
        this.christmasMagic = christmasMagic;
    }
}
