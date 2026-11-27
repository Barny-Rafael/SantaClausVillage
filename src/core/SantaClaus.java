/**
 * Le Père Noël : il n'en existe qu'un seul (singleton).
 */
public final class SantaClaus {
    private static SantaClaus instance;

    private SantaClaus() {
    }

    public static SantaClaus getInstance() {
        if (instance == null) {
            instance = new SantaClaus();
        }
        return instance;
    }

    /**
     * Examine un bâtiment : affiche ses caractéristiques et celles de ses personnages.
     */
    public void examineBuilding(Building b) {
        b.displayCharacteristics();
    }

    /**
     * Demande l'entretien d'un bâtiment (seulement s'il est sale et vide).
     */
    public void requestMaintenance(Building b) {
        if (b.cleanliness == CleanlinessLevel.MAUVAIS && b.characters.isEmpty()) {
            b.maintain();
        }
    }

    /**
     * Transfère un personnage d'un bâtiment à un autre, si la destination l'accepte.
     */
    public void transferCharacter(Character c, Building destination) {
        c.move(destination);
    }
}
