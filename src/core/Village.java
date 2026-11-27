package core;

import java.util.List;

/** Le village : contient le Père Noël et les bâtiments. */
public class Village {
    private double maxSurface;
    private int maxCapacity;
    private List<Building> buildings;
    private SantaClaus santa = SantaClaus.getInstance();   // relation « has »

    public Village(double maxSurface, int maxCapacity, List<Building> buildings) {
        this.maxSurface = maxSurface;
        this.maxCapacity = maxCapacity;
        this.buildings = buildings;
    }

    /** Affiche l'état du village et de chacun de ses bâtiments. */
    public void displayVillageStatus() {
        System.out.println("Village - surface max : " + maxSurface + " - capacité max : " + maxCapacity);
        for (Building b : buildings) {
            b.displayCharacteristics();
        }
    }

    /** Lance la simulation : le Père Noël examine et entretient chaque bâtiment. */
    public void runSimulation() {
        displayVillageStatus();
        for (Building b : buildings) {
            santa.examineBuilding(b);
            santa.requestMaintenance(b);
        }
    }
}

