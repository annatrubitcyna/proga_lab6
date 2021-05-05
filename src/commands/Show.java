package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class Show extends Command {
    public Show(String arg) {
        this.args=arg;
        name = "show";
        help = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Выводит элементы коллекции
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";

        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
            otv+="Элементы коллекции:";
            for (int i = 0; i < collection.size(); i++) {
                HumanBeing first = collection.get(i);
                otv+="id:" + first.id + ", " + "name:" + first.name + ", " + "coordinate x:" + first.coordinates.x + ", " + "coordinate y:" + first.coordinates.y + ", " + "creation date:" + first.creationDate + ", " + "real hero:" + first.realHero + ", " + "has tooth pick:" + first.hasToothpick + ", " + "impackt speed:" + first.impactSpeed + ", " + "soundtrack name:" + first.soundtrackName + ", " + "weapon type:" + first.weaponType + ", " + "mood:" + first.mood + ", " + "car cool:" + first.car.cool+"\n";
            }
        }
        return otv;
    }
}
