package org.lection_1;

public class Aircraft extends MilitaryVehicle implements Stealth {
    private int maximumLoad;
    private BombClass bombClass;
    private boolean inAir = false;

    private static int totalAircraftInAir = 0;

    public Aircraft(String manufacturer, String model, int weight, int ammunition, int maximumLoad, BombClass bombClass) {
        super(manufacturer, model, weight, ammunition);
        this.maximumLoad = maximumLoad;
        this.bombClass = bombClass;
    }

    public int getMaximumLoad() {
        return maximumLoad;
    }

    public void setMaximumLoad(int maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    public BombClass getBombClass() {
        return bombClass;
    }

    public void setBombClass(BombClass bombClass) {
        this.bombClass = bombClass;
    }

    public static int getTotalAircraftInAir() {
        System.out.println("\n" + "Общее количество самолетов в небе = ");
        return totalAircraftInAir;
    }

    private static void incrementAircraftInAir() {
        totalAircraftInAir++;
    }

    private static void decrementAircraftInAir() {
        totalAircraftInAir--;
    }

    @Override
    public void retreat() {
        System.out.println("Боезапас пуст, нужно вернуться!");
    }

    @Override
    public void fire(MilitaryVehicle modelEnemy) {
        if (!inAir) {
            System.out.println("Самолет не взлетел, сначала поднимите самолет в воздух");
        } else {
            if (getAmmunition() > 0) {
                hit(modelEnemy);
            } else {
                retreat();
            }
        }
    }

    @Override
    public void hit(MilitaryVehicle enemyModel) {
        int damage = 0;
        switch (bombClass) {
            case FRAGMENTATION:
                damage = 10;
                break;
            case HIGH_EXPLOSIVE:
                damage = 20;
                break;
            case CONCRETE_PIERCING:
                damage = 30;
                break;
            case INCENDIARY:
                damage = 40;
                break;
            case INCENDIARY_SMOKE:
                damage = 50;
                break;
            case POISON_SMOKE:
                damage = 60;
                break;
        }
        System.out.println("Урон по области = " + damage);
        setAmmunition(getAmmunition() - 1);
    }

    public boolean takeOff() {
        if (!inAir) {
            System.out.println(getModel() + " взлетела");
            inAir = true;
            incrementAircraftInAir();
            return true;
        } else {
            System.out.println(getModel() + " уже в воздухе");
            return false;
        }
    }

    public boolean landing() {
        if (inAir) {
            System.out.println(getModel() + " садится");
            inAir = false;
            decrementAircraftInAir();
            return true;
        } else {
            System.out.println(getModel() + " уже на земле");
            return false;
        }
    }

    public void replenishment(int amm) {
        if (landing()) {
            if (getAmmunition() + amm > maximumLoad) {
                System.out.println("Превышена допустимая загрузка");
            }
            setAmmunition(getAmmunition() + amm);
            System.out.println("Пополнение произошло успешно и составляет = " + getAmmunition());
        } else
            System.out.println("Самолет в воздухе, сначала посадите его!");
    }

    public String toString() {
        return super.toString() + "\n" +
                "Maximum load: " + maximumLoad + "\n" +
                "Bomb Class: " + bombClass;
    }

    @Override
    public boolean activateStealthMode(Object object) {
        System.out.println("Активирован режим невидимости");
        return true;
    }

    @Override
    public boolean deactivateStealthMode(Object object) {
        System.out.println("Режим невидимости деактивирован");
        return false;
    }
}
