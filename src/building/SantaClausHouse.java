package building;

import character.Character;

/** Maison du Père Noël : bâtiment unique qui n'accueille aucun personnage. */
public class SantaClausHouse extends Building {

    public SantaClausHouse(String name, double area) {
        // Capacité 0 : aucun personnage ne peut y entrer
        super(name, area, 0);
    }

    /** Aucun type de personnage n'est accepté. */
    @Override
    protected boolean acceptsType(Character character) {
        return false;
    }

    /** Personne ne peut être accueilli. */
    @Override
    protected boolean canWelcome(Character character) {
        return false;
    }

    /** La maison du Père Noël est unique dans le village. */
    @Override
    public boolean isUnique() {
        return true;
    }
}