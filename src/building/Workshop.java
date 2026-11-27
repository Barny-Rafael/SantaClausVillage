package building;

import character.Character;
import character.humanoid.ChristmasFairy;
import character.humanoid.Elf;

/** Atelier de fabrication : lieu de travail des lutins et des fées de Noël. */
public class Workshop extends Building {

    public Workshop(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    /** Seuls les lutins et les fées entrent (les créatures sont donc exclues). */
    @Override
    protected boolean acceptsType(Character character) {
        return character instanceof Elf || character instanceof ChristmasFairy;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Le personnage travaille automatiquement. */
    @Override
    protected void activity(Character character) {
        character.work();
    }
}