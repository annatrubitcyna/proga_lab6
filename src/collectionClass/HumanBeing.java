package collectionClass;

import java.util.LinkedList;

public class HumanBeing {
    public int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public String name; //Поле не может быть null, Строка не может быть пустой
    public Coordinates coordinates; //Поле не может быть null
    public java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    public boolean realHero;
    public boolean hasToothpick;
    public static float impactSpeed;
    public static String soundtrackName; //Поле не может быть null
    public WeaponType weaponType; //Поле может быть null
    public Mood mood; //Поле не может быть null
    public Car car; //Поле не может быть null

    /**
     * конструктор
     *
     * @param id
     * @param name
     * @param coordinates
     * @param creationDate
     * @param realHero
     * @param hasToothpick
     * @param impactSpeed
     * @param soundtrackName
     * @param weaponType
     * @param mood
     * @param car
     */
    public HumanBeing(int id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, boolean realHero, boolean hasToothpick, float impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    public void display(HumanBeing human) {
        System.out.println(human.name);
    }

    public static <T> float getImpactSpeed(T t) {
        return impactSpeed;
    }
    public static <T> String getSoundtrackName(T t) {
        return soundtrackName;
    }
}