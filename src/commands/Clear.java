package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class Clear extends Command {
    public Clear(String arg) {
        this.args=arg;
        name = "clear";
        help = "очищает коллекцию";
    }

    /**
     * Удаляет все элементы коллекции
     *
     * @param collection коллекция, которую нужно очистить
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
            collection.clear();
            otv+="Коллекция очищена"+"\n";
        }
        return otv;
    }
}