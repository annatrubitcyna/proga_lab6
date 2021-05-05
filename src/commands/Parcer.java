package commands;

import collectionClass.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Parcer {
    public LinkedList<HumanBeing> work(){
        LinkedList<HumanBeing> collection = new LinkedList<>();
        String fileName=System.getenv("AAA");
        if (Objects.equals(fileName, null)){
            fileName = "C:\\Users\\Anna\\IdeaProjects\\lab5\\src\\data.json";}
        try {
            Path path = Paths.get(fileName);
            Scanner scanner = new Scanner(path);

            //построчно считываем файл
            scanner.useDelimiter(System.getProperty("line.separator"));
            String file = "";
            String a;
            int id = (int) (Math.random() * 1000);
            ; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
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
            HumanBeing human = new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
            List<Integer> arrayId = new ArrayList<Integer>();
            while (scanner.hasNext()) {
                a = scanner.next();
//            a.replaceAll("\\s+","");
//            System.out.println("1"+a);
                if (a.contains(":")) {
                    String[] c = a.split(":");
                    String x = c[0].replaceAll("\\W", "");
                    String y = c[1].replaceAll("\\W", "");
                    switch (x) {
                        case ("name"):
                            name = y;
                        case ("x"):
                            try {
                                coordinatesX = Integer.parseInt(y);
                            } catch (NumberFormatException e) {
                            }
                        case ("y"):
                            try {
                                coordinatesY = new Long(y);
                                coordinates = new Coordinates(coordinatesX, coordinatesY);
                            } catch (NumberFormatException e) {
                            }
                        case ("realHero"):
                            try {
                                realHero = new Boolean(y);
                            } catch (NumberFormatException e) {
                            }
                        case ("hasToothpick"):
                            try {
                                hasToothpick = new Boolean(y);
                            } catch (NumberFormatException e) {
                            }
                        case ("impactSpeed"):
                            try {
                                impactSpeed = new Float(y);
                            } catch (NumberFormatException e) {
                            }
                        case ("soundtrackName"):
                            soundtrackName = y;
                        case ("weaponType"):
                            if (y.equals("KNIFE")) {
                                weaponType = WeaponType.KNIFE;
                            }
                            if (y.equals("AXE")) {
                                weaponType = WeaponType.AXE;
                            }
                            if (y.equals("SHOTGUN")) {
                                weaponType = WeaponType.SHOTGUN;
                            }
                            if (y.equals("RIFLE")) {
                                weaponType = WeaponType.RIFLE;
                            }
                            if (y.equals("BAT")) {
                                weaponType = WeaponType.BAT;
                            }
                        case ("mood"):
                            if (y.equals("LONGING")) {
                                mood = Mood.LONGING;
                            }
                            if (y.equals("GLOOM")) {
                                mood = Mood.GLOOM;
                            }
                            if (y.equals("CALM")) {
                                mood = Mood.CALM;
                            }
                            if (y.equals("RAGE")) {
                                mood = Mood.RAGE;
                            }
                            if (y.equals("FRENZY")) {
                                mood = Mood.FRENZY;
                            }
                        case ("cool"):
                            try {
                                car = new Car(new Boolean(y));
                            } catch (NumberFormatException e) {
                            }
                    }
                }
                if (a.contains("}") & !a.contains(",")) {
                    if (!name.equals("") & coordinatesY < 762) {
                        while (arrayId.contains(id)) {
                            id = (int) (Math.random() * 1000);
                        }
                        arrayId.add(id);
                        human = new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
//                System.out.println("id:" + human.id + ", " + "name:" + human.name + ", " + "coordinate x:" + human.coordinates.x + ", " + "coordinate y:" + human.coordinates.y + ", " + "creation date:" + human.creationDate + ", " + "real hero:" + human.realHero + ", " + "has tooth pick:" + human.hasToothpick + ", " + "impackt speed:" + human.impactSpeed + ", " + "soundtrack name:" + human.soundtrackName + ", " + "weapon type:" + human.weaponType + ", " + "mood:" + human.mood + ", " + "car cool:" + human.car.cool);
                        collection.add(human);
                    } else {
                        System.out.println("в файле присутствуют ошибки");
                    }
                }
                if (a.contains("]")) {
                    collection.remove(collection.size() - 1);
                    System.out.println("Коллекция загружена");
                }
            }
            scanner.close();
            //System.out.println(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        catch (IOException n){
            System.out.println("Файл не найден");
        }
        return collection;
    }
}
