package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class FilterContainsName extends Command {
    public FilterContainsName(String arg) {
        this.args=arg;
        name = "filter contains name";
        help = "вывести элементы, значение поля name которых содержит заданную подстроку";
    }

    /**
     * Выводит элементы, значение поля name которых содержит заданную подстроку
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (args.equals("")) {
            otv+="Введите пожалуйста подстроку"+"\n";
        } else {
            otv+="Элементы, значение поля name которых содержит заданную подстроку:"+"\n";
            for (int i = 0; i < collection.size(); i++) {
                if (collection.get(i).name.contains(args)) {
                    HumanBeing first = collection.get(i);
                    otv+="id:" + first.id + ", " + "name:" + first.name + ", " + "coordinate x:" + first.coordinates.x + ", " + "coordinate y:" + first.coordinates.y + ", " + "creation date:" + first.creationDate + ", " + "real hero:" + first.realHero + ", " + "has tooth pick:" + first.hasToothpick + ", " + "impackt speed:" + first.impactSpeed + ", " + "soundtrack name:" + first.soundtrackName + ", " + "weapon type:" + first.weaponType + ", " + "mood:" + first.mood + ", " + "car cool:" + first.car.cool+"\n";
                }
            }
        }
        return otv;
    }
}
