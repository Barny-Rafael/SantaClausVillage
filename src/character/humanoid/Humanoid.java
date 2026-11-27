package character.humanoid;

import character.Character;
import enumeration.Gender;

public abstract class Humanoid extends Character {
    public Humanoid(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }
}
