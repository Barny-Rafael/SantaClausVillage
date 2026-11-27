package building;

import character.Character;
import character.humanoid.Humanoid;

/** Chalet dortoir : non mixte, réservé aux humanoïdes qui s'y reposent. */
public class DormitoryChalet extends Building {

    public DormitoryChalet(String name, double area, int capacity) {
        super(name, area, capacity);
    }

    /** Seuls les humanoïdes sont acceptés. */
    @Override
    protected boolean acceptsType(Character character) {
        return character instanceof Humanoid;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return true;
    }

    /** Non mixte : le nouvel arrivant doit avoir le même genre que les occupants. */
    @Override
    protected boolean compatibleWithOccupants(Character character) {
        if (getPresentCharacters().isEmpty()) {
            return true;
        }
        return getPresentCharacters().get(0).getGender() == character.getGender();
    }

    /** C'est un lieu de repos. */
    @Override
    protected boolean isRestPlace() {
        return true;
    }

    /** Le personnage se repose automatiquement. */
    @Override
    protected void activity(Character character) {
        character.rest();
    }
}