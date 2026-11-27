package building;

import character.Character;
import enumeration.CleanlinessLevel;

/** Aire de jeux : ouverte, divertissement, comportement libre en créature, salit vite. */
public class Playground extends Building {

    public Playground(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    @Override
    protected boolean acceptsType(Character character) {
        return true;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Lieu ouvert. */
    @Override
    public boolean isOpen() {
        return true;
    }

    /** Le personnage joue et se comporte librement en créature, ce qui salit l'aire. */
    @Override
    protected void activity(Character character) {
        character.play();
        character.actAsCreature();
        degradeCleanliness();
    }

    /** Fait baisser la propreté d'un cran à chaque activité (entretien fréquent nécessaire). */
    private void degradeCleanliness() {
        if (getCleanlinessLevel() == CleanlinessLevel.GOOD) {
            setCleanlinessLevel(CleanlinessLevel.AVERAGE);
        } else if (getCleanlinessLevel() == CleanlinessLevel.AVERAGE) {
            setCleanlinessLevel(CleanlinessLevel.BAD);
        }
    }
}