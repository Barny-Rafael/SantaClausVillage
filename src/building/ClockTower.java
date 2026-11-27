package building;

import character.Character;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/** Tour de l'horloge : unique, n'accueille personne, compte la magie de Noël et donne l'heure. */
public class ClockTower extends Building {

    public ClockTower(String name, double area) {
        super(name, area, 0);
    }

    @Override
    protected boolean acceptsType(Character character) {
        return false;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return false;
    }

    @Override
    public boolean isUnique() {
        return true;
    }

    /**
     * Calcule le niveau total de magie de Noël du village.
     * @param villageCharacters tous les personnages du village
     * @return la somme des niveaux de magie
     */
    public int computeTotalChristmasMagic(List<Character> villageCharacters) {
        int total = 0;
        for (Character character : villageCharacters) {
            total += character.getChristmasMagic();
        }
        return total;
    }

    /** Donne l'heure actuelle au format HH:mm. */
    public String giveTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}