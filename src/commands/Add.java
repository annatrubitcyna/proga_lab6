package commands;

import collectionClass.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Add extends Command {
    public Add(String arg) {
        this.args=arg;
        name = "add";
        help = "добавить новый элемент в коллекцию";
    }

    /**
     * Добавляет новый элемент в коллекцию
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) throws ArrayIndexOutOfBoundsException{
        String otv = "";
        try {
            String[] element = args.split(" ");
            int id = 0;
            String name = "abv"; //Поле не может быть null, Строка не может быть пустой
            int coordinatesX = 0;
            Long coordinatesY = Long.valueOf(0);
            Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY); //Поле не может быть null
            LocalDate localDate = LocalDate.of((int) Math.random() * 2021 + 1, (int) Math.random() * 12 + 1, (int) Math.random() * 31 + 1);
            LocalTime localTime = LocalTime.of((int) Math.random() * 25, (int) Math.random() * 61, (int) Math.random() * 61);
            ZoneId zoneId = ZoneId.of("UTC+1");
            ZonedDateTime creationDate = ZonedDateTime.of(localDate, localTime, zoneId); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
            boolean realHero = FALSE;
            boolean hasToothpick = FALSE;
            float impactSpeed = 0.0f;
            String soundtrackName = ""; //Поле не может быть null
            WeaponType weaponType = WeaponType.BAT; //Поле может быть null
            Mood mood = Mood.CALM; //Поле не может быть null
            Car car = new Car(TRUE); //Поле не может быть null
            try {
                id = Integer.parseInt(element[11]);
            } catch (NumberFormatException e) {
            }
            name = element[1];
            try {
                coordinatesX = Integer.parseInt(element[2]);
            } catch (NumberFormatException e) {
            }
            try {
                coordinatesY = new Long(element[3]);
                coordinates = new Coordinates(coordinatesX, coordinatesY);
            } catch (NumberFormatException e) {
            }
            try {
                realHero = new Boolean(element[4]);
            } catch (NumberFormatException e) {
            }
            try {
                hasToothpick = new Boolean(element[5]);
            } catch (NumberFormatException e) {
            }
            try {
                impactSpeed = new Float(element[6]);
            } catch (NumberFormatException e) {
            }
            soundtrackName = element[7];
            if (element[8].equals("KNIFE")) {
                weaponType = WeaponType.KNIFE;
            }
            if (element[8].equals("AXE")) {
                weaponType = WeaponType.AXE;
            }
            if (element[8].equals("SHOTGUN")) {
                weaponType = WeaponType.SHOTGUN;
            }
            if (element[8].equals("RIFLE")) {
                weaponType = WeaponType.RIFLE;
            }
            if (element[8].equals("BAT")) {
                weaponType = WeaponType.BAT;
            }
            if (element[9].equals("LONGING")) {
                mood = Mood.LONGING;
            }
            if (element[9].equals("GLOOM")) {
                mood = Mood.GLOOM;
            }
            if (element[9].equals("CALM")) {
                mood = Mood.CALM;
            }
            if (element[9].equals("RAGE")) {
                mood = Mood.RAGE;
            }
            if (element[9].equals("FRENZY")) {
                mood = Mood.FRENZY;
            }
            try {
                car = new Car(new Boolean(element[10]));
            } catch (NumberFormatException e) {
            }
            HumanBeing human = new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
            collection.add(human);
            //add Ann 10 35 True True 90.0 Name1 BAT CALM True
            otv+="Новый элемент добавлен"+"\n";
        }
        catch(ArrayIndexOutOfBoundsException a){
            otv+="Неверный формат данных"+"\n";
        }
        return otv;
    }
}
