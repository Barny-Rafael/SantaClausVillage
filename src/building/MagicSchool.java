package building;

import character.Character;

/** École de magie : permet de se comporter librement en créature fantastique. */
public class MagicSchool extends Building {

    public MagicSchool(String name, double area, int capacity) {
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

    /** Le personnage adopte librement un comportement de créature fantastique. */
    @Override
    protected void activity(Character character) {
        character.actAsCreature();
    }
}