package character.creature;

import enumeration.Gender;
import interfaces.SupernaturalBeing;

public final class NorthSpirit extends Creature implements SupernaturalBeing {
    public NorthSpirit(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }

    @Override
    public void behaveAsSupernaturalBeing() {
        updateMagic(10);
    }
}
