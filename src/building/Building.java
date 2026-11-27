package building;
import character.Character;
import enumeration.CleanlinessLevel;
import exception.CapacityExceededException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public abstract class Building {
    private final double area;
    private final int capacity;
    private final String name;
    private CleanlinessLevel cleanlinessLevel;
    private List<Character> presentCharacters;

    public Building(String name, double area, int capacity) {
        if (area < 0) {
            throw new IllegalArgumentException("La superficie ne peut pas etre negative.");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("La capacite ne peut pas etre negative.");
        }
        this.presentCharacters = new ArrayList<>();
        this.cleanlinessLevel = CleanlinessLevel.GOOD;
        this.name = name;
        this.area = area;
        this.capacity = capacity;
    }

    protected abstract boolean acceptsType(Character character);
    protected abstract boolean canWelcome(Character character);

    protected boolean compatibleWithOccupants(Character character) {
        return true;
    }

    public boolean isOpen() {
        return false;
    }

    public boolean isUnique() {
        return false;
    }

    protected boolean isRestPlace() {
        return false;
    }

    public void welcomed(Character character) throws CapacityExceededException {
        if (character == null) {
            throw new IllegalArgumentException("Le personnage ne peut pas etre nul.");
        }
        if (!canWelcome(character) || !acceptsType(character)) {
            throw new IllegalArgumentException(
                    "Ce personnage ne peut pas entrer dans " + getClass().getSimpleName() + "."
            );
        }
        if (!compatibleWithOccupants(character)) {
            throw new IllegalArgumentException("Ce personnage n'est pas compatible avec les occupants.");
        }
        if (presentCharacters.size() >= capacity) {
            throw new CapacityExceededException("Le bâtiment est complet.");
        }
        presentCharacters.add(character);
        System.out.println(character.getName() + " est entré dans le bâtiment.");
    }

    protected void activity(Character character) {
    }

    public void performActivity(Character character) {
        if (presentCharacters.contains(character)) {
            activity(character);
        }
    }

    public void withdraw(Character character){
        presentCharacters.remove(character);
    }

    public void add(Character character){
        presentCharacters.add(character);
    }

    public void maintain() {
        if (cleanlinessLevel == CleanlinessLevel.BAD && presentCharacters.isEmpty()) {
            cleanlinessLevel = CleanlinessLevel.GOOD;
            System.out.println("Le bâtiment a été nettoyé.");
        } else {
            System.out.println("Le bâtiment ne peut pas être entretenu : il doit être sale et vide.");
        }
    }

    public void viewSpec() {
        System.out.println("Superficie : " + area + " m² | Capacité : " + capacity + " | Propreté : " + cleanlinessLevel + " | Occupants : " + presentCharacters.size());
        for (Character character : presentCharacters) {
            System.out.println(" - " + character.getName() + " (" + character.getClass().getSimpleName() + ")");
        }
    }

    public double getArea() {
        return area;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        if (name != null) {
            return name;
        }
        return getClass().getSimpleName();
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public List<Character> getPresentCharacters() {
        return Collections.unmodifiableList(presentCharacters);
    }

    public int getPresentCharactersNumber() {
        return presentCharacters.size();
    }
}