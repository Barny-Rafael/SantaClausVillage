package building;

import character.Character;
import character.humanoid.PostalElf;

/** Bureau de poste : lieu de travail des elfes postiers. */
public class PostOffice extends Building {

    public PostOffice(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    /** Seuls les elfes postiers entrent (créatures exclues). */
    @Override
    protected boolean acceptsType(Character character) {
        return character instanceof PostalElf;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    @Override
    protected void activity(Character character) {
        character.work();
    }
}