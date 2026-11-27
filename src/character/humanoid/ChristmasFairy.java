package character.humanoid;

import enumeration.Gender;
import interfaces.SupernaturalBeing;
import interfaces.Work;

public final class ChristmasFairy extends Humanoid implements SupernaturalBeing, Work {
    public ChristmasFairy(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }

    @Override
    public void behaveAsSupernaturalBeing() {
        updateMagic(10);
    }

    @Override
    public void work() {
        updateMagic(10);
    }
}
