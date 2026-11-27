package character.creature;

import enumeration.Gender;
import interfaces.SupernaturalBeing;

public final class Lycanthrope extends Creature implements SupernaturalBeing {
    public Lycanthrope(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }

    @Override
    public void behaveAsSupernaturalBeing() {
        updateMagic(10);
    }
}
