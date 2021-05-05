package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class Head extends Command {
    public Head(String arg) {
        this.args=arg;
        name = "head";
        help = "вывести первый элемент коллекции";
    }

    /**
     * Выводит первый элемент коллекции
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
            HumanBeing first = collection.get(0);
            otv+="Первый элемент коллекции"+"\n";
            otv+="id:" + first.id + ", " + "name:" + first.name + ", " + "coordinate x:" + first.coordinates.x + ", " + "coordinate y:" + first.coordinates.y + ", " + "creation date:" + first.creationDate + ", " + "real hero:" + first.realHero + ", " + "has tooth pick:" + first.hasToothpick + ", " + "impackt speed:" + first.impactSpeed + ", " + "soundtrack name:" + first.soundtrackName + ", " + "weapon type:" + first.weaponType + ", " + "mood:" + first.mood + ", " + "car cool:" + first.car.cool+"\n";
        }
        return otv;
    }
}
