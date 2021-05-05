package commands;

import collectionClass.HumanBeing;

import java.io.*;
import java.util.LinkedList;
//import com.google.code.gson.*;

public class Save extends Command {
    public Save(String arg) throws IOException {
        this.args=arg;
        name = "save";
        help = "сохранить  коллекцию в файл";
    }

    private LinkedList<HumanBeing> citizens;
//    private Gson serializer;

    /**
     * Сохраняет коллекцию в файл
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";

        String collectionTxt="";
        if (!args.equals("")) {
            for (int i = 0; i < collection.size(); i++) {
                HumanBeing first = collection.get(i);
                collectionTxt+="id:" + first.id + ", " + "name:" + first.name + ", " + "coordinate x:" + first.coordinates.x + ", " + "coordinate y:" + first.coordinates.y + ", " + "creation date:" + first.creationDate + ", " + "real hero:" + first.realHero + ", " + "has tooth pick:" + first.hasToothpick + ", " + "impackt speed:" + first.impactSpeed + ", " + "soundtrack name:" + first.soundtrackName + ", " + "weapon type:" + first.weaponType + ", " + "mood:" + first.mood + ", " + "car cool:" + first.car.cool+"\n";
            }
            try (FileWriter file = new FileWriter(args, false);) {
                file.write(collectionTxt);
                file.flush();
                otv+="Коллекция успешно сохранена";
            }
            catch (IOException ex) {
                otv+="Коллекция не может быть записана в файл."+"\n";
            }
        } else {
            for (int i = 0; i < collection.size(); i++) {
                HumanBeing first = collection.get(i);
                collectionTxt+="id:" + first.id + ", " + "name:" + first.name + ", " + "coordinate x:" + first.coordinates.x + ", " + "coordinate y:" + first.coordinates.y + ", " + "creation date:" + first.creationDate + ", " + "real hero:" + first.realHero + ", " + "has tooth pick:" + first.hasToothpick + ", " + "impackt speed:" + first.impactSpeed + ", " + "soundtrack name:" + first.soundtrackName + ", " + "weapon type:" + first.weaponType + ", " + "mood:" + first.mood + ", " + "car cool:" + first.car.cool+"\n";
            }
            try (FileWriter file = new FileWriter("C:\\Users\\777\\IdeaProjects\\lab6\\src\\data.txt", false);) {
                //System.out.println(collectionTxt);
                file.write(collectionTxt);
                file.flush();
                otv+="Коллекция успешно сохранена";
            } catch (IOException ex) {
                otv+="Коллекция не может быть записана в файл."+"\n";
            }
            //save C:\Users\777\IdeaProjects\lab5\src\data1.txt
//        try (BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonCollection)))) {
//            outputStreamWriter.write(serializer.toJson(collection));
//        } catch (Exception ex) {
//            System.out.println("Коллекция не может быть записана в файл.");
//        }
        }
        return otv;
    }
}
