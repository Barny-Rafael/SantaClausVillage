package character.humanoid;

import enumeration.Gender;
import interfaces.Work;

public final class PostalElf extends Humanoid implements Work {
    public PostalElf(String nom, Gender gender, int age) {
        super(nom, gender, age);
    }

    @Override
    public void work() {
        updateMagic(10);
    }
}
