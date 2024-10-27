package org.lection_1;

public class Tank extends MilitaryVehicle implements Armored{
    private int armor;
    private String cannonType;
    private int crew;
    private int strength;
    private final int initialArmor;

    private static int countAllTank = 0;

    public Tank(String manufacturer, String model, int weight, int ammunition, int armor, String cannonType, int crew, int strength) {
        super(manufacturer, model, weight, ammunition);
        this.armor = armor;
        this.cannonType = cannonType;
        this.crew = crew;
        this.strength = strength;
        this.initialArmor = armor + strength;
        countAllTank++;
    }

    public static int getCountAllTank(){
        return countAllTank;
    }

    @Override
    public void fire(MilitaryVehicle modelEnemy) {
        Tank a = (Tank)modelEnemy;
        if (getAmmunition() > 0) {
            System.out.println(getModel() + " открывает огонь из " + cannonType + " по " + a.getModel());
            setAmmunition(getAmmunition() - 1);
            a.hit(a);
            System.out.println("Боезапас после атаки равен = " + getAmmunition() + "\n" +
                    "После атаки прочность противника равна = " + a.getStrength() + "\n");
        } else {
            System.out.println("Боезапас пуст, отступаем");
            retreat();
        }
    }

    @Override
    public void hit(MilitaryVehicle modelEnemy){
        Tank enemy = (Tank)modelEnemy;
        if(enemy.getStrength() >= 10){
            enemy.setStrength(enemy.getStrength() - 10);
            if(enemy.getStrength() == 0){
                System.out.println("Машина подбита!");
                crewDisembarkation();
            }
        }
        else{
            System.out.println("Машина подбита!");
            crewDisembarkation();
        }
    }

    public boolean deployArmor(){
        System.out.println(getModel() + " развертывает защиту");
        setStrength(strength + armor);
        System.out.println("Текущий показатель прочности равен = " + getStrength());
        return true;
    }

    public void crewDisembarkation(){
        System.out.println(getModel() + " высаживает экипаж!");
        for (int i = 0; i < crew; i++){
            System.out.println("...");
        }
        System.out.println("Экипаж высажен!");
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getCannonType() {
        return cannonType;
    }

    public void setCannonType(String cannonType) {
        this.cannonType = cannonType;
    }

    public int getCrew(){
        return crew;
    }

    public void setCrew(int crew){
        this.crew = crew;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int upgradeArmor() {
        if (armor < 100){
            armor = 100;
        }
        armor += 100;
        return armor;
    }

    @Override
    public int repairArmor(int rem) {
        if (strength + rem > initialArmor) {
            System.out.println("Превышен лимит починки. Броня восстанавливается до максимального значения прочности.");
            strength = initialArmor;
        } else
            strength += rem;
        System.out.println("Текущая броня: " + strength + "\n");
        return strength;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "armor = " + armor + "\n" +
                " cannonType = " + cannonType;
    }
}
