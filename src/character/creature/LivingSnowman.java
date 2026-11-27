package character.creature;

import enumeration.Gender;
import interfaces.SupernaturalBeing;

public final class LivingSnowman extends Creature implements SupernaturalBeing {
    private boolean inside;

    public LivingSnowman(String nom, Gender gender, int age) {
        super(nom, gender, age);
        this.inside = true;
    }

    @Override
    public void move() {

    }

    @Override
    public void behaveAsSupernaturalBeing() {
        updateMagic(10);
    }

    public boolean isInside() {
        return inside;
    }

    public void insideOrNot() {
        this.inside = !inside;
    }
}
