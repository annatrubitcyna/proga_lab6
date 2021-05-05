package commands;

import collectionClass.HumanBeing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class PrintUniqueSoundtrackName extends Command {
    public PrintUniqueSoundtrackName(String arg) {
        this.args=arg;
        name = "print unique soundtrack name";
        help = "вывести уникальные значения поля soundtrackName всех элементов в коллекции";
    }

    /**
     * Выводит уникальные значения поля soundtrackName всех элементов в коллекции
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
            otv+="Уникальные значения поля soundtrackName всех элементов в коллекции: ";
            HashSet<String> soundtrackNames = new HashSet<>();
            for (int i = 0; i < collection.size(); i++) {
                soundtrackNames.add(collection.get(i).soundtrackName);
            }
            ArrayList<String> arr = new ArrayList<>();
            arr.addAll(soundtrackNames);
//            ArrayList<String> arr=collection.stream().filter(HumanBeing::getSoundtrackName).distinct();
            for (int i = 0; i < arr.size(); i++) {
                otv+=arr.get(i)+" ";
            }
        }
        return otv+"\n";
    }
}
