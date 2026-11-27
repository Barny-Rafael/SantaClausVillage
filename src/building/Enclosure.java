package building;

import character.Character;
import character.Creature;

/** Enclos : n'accueille qu'un seul type de créature à la fois, permet le repos. */
public class Enclosure extends Building {
    private final boolean open;

    public Enclosure(String name, double area, int capacity, boolean open) {
        super(name, area, capacity);
        this.open = open;
    }

    /** Seules les créatures sont acceptées. */
    @Override
    protected boolean acceptsType(Character character) {
        return character instanceof Creature;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Un seul type de créature à la fois : comparaison avec la classe du premier occupant. */
    @Override
    protected boolean compatibleWithOccupants(Character character) {
        if (getPresentCharacters().isEmpty()) {
            return true;
        }
        return getPresentCharacters().get(0).getClass() == character.getClass();
    }

    /** Certains enclos sont ouverts, d'autres fermés. */
    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    protected boolean isRestPlace() {
        return true;
    }

    /** La créature se repose automatiquement. */
    @Override
    protected void activity(Character character) {
        character.rest();
    }
}