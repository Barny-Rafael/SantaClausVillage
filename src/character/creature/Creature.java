package character.creature;

import character.Character;
import enumeration.Gender;

public abstract class Creature extends Character {
    public Creature(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }
}
