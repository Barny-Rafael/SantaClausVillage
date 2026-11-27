package building;

import character.Character;
import java.util.HashMap;
import java.util.Map;

/** Réserve : n'accueille personne, stocke de la nourriture en quantités limitées. */
public class Reserve extends Building {
    private final int maxQuantityPerFood;
    private final Map<String, Integer> stock = new HashMap<>();

    public Reserve(String name, double area, int maxQuantityPerFood) {
        super(name, area, 0);
        if (maxQuantityPerFood < 0) {
            throw new IllegalArgumentException("La quantité maximale ne peut pas être négative.");
        }
        this.maxQuantityPerFood = maxQuantityPerFood;
    }

    @Override
    protected boolean acceptsType(Character character) {
        return false;
    }

    @Override
    protected boolean canWelcome(Character character) {
        return false;
    }

    /**
     * Ajoute de la nourriture au stock, dans la limite autorisée.
     * @return la quantité réellement stockée
     */
    public int store(String food, int quantity) {
        int current = stock.getOrDefault(food, 0);
        int accepted = Math.min(quantity, maxQuantityPerFood - current);
        stock.put(food, current + accepted);
        return accepted;
    }

    /**
     * Retire de la nourriture du stock.
     * @return la quantité réellement retirée
     */
    public int take(String food, int quantity) {
        int current = stock.getOrDefault(food, 0);
        int taken = Math.min(quantity, current);
        stock.put(food, current - taken);
        return taken;
    }

    /** Une réserve ne nécessite pas d'entretien. */
    @Override
    public void maintain() {
        System.out.println("Une réserve ne nécessite pas d'entretien.");
    }
}