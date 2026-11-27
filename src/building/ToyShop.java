package building;

import character.Character;
import character.creature.Creature;

/** Boutique de jouets : lieu de divertissement interdit aux créatures. */
public class ToyShop extends Building {

    public ToyShop(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    /** Tout le monde sauf les créatures. */
    @Override
    protected boolean acceptsType(Character character) {
        return !(character instanceof Creature);
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Le personnage se divertit automatiquement. */
    @Override
    protected void activity(Character character) {
        character.play();
    }
}