package building;

import character.Character;

/** Confiserie : tous les personnages peuvent s'y restaurer. */
public class Confectionery extends Building {

    public Confectionery(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    /** Tous les types de personnages sont acceptés. */
    @Override
    protected boolean acceptsType(Character character) {
        return true;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Le personnage mange automatiquement. */
    @Override
    protected void activity(Character character) {
        character.eat();
    }
}