package character.humanoid;

import enumeration.Gender;
import interfaces.Fun;
import interfaces.SupernaturalBeing;
import interfaces.Work;

public final class Elf extends Humanoid implements SupernaturalBeing, Work, Fun {
    private boolean prankster;

    public Elf(String nom, Gender gender, int age) {
        super(nom, gender, age);
        this.prankster = false;
    }

    @Override
    public void move() {

    }

    @Override
    public void behaveAsSupernaturalBeing() {
        updateMagic(10);
    }

    @Override
    public void work() {
        updateMagic(10);
    }

    @Override
    public void haveFun() {
        updateMagic(10);
    }

    public boolean isPrankster() {
        return prankster;
    }

    public void pranksterOrNot() {
        this.prankster = !prankster;
    }
}
