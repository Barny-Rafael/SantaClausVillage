package character.humanoid;

import enumeration.Gender;
import interfaces.Fun;

public final class VisitorChild extends Humanoid implements Fun {
    public VisitorChild(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }

    @Override
    public void move() {

    }

    @Override
    public void haveFun() {
        updateMagic(10);
    }

    @Override
    public void updateMagic(int amount) {
        this.christmasMagic += amount * 2;
    }
}
