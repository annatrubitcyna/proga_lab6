package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class RemoveFirst extends Command {

    public RemoveFirst(String arg) {
        this.args=arg;
        name = "remove_first";
        help = "удалить первый элемент из коллекции";
    }

    /**
     * Удаляет первый элемент из коллекции
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) throws IndexOutOfBoundsException{
        String otv = "";
        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
            try {
                collection.remove(0);
                otv+="Первый элемент удален"+"\n";
            }
            catch(IndexOutOfBoundsException i){
                otv+="В коллекции нет элементов"+"\n";
                }
        }
        return otv;
    }
}
