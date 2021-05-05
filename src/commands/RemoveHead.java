package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class RemoveHead extends Command {
    public RemoveHead(String arg) {
        this.args=arg;
        name = "remove head";
        help = "вывести первый элемент коллекции и удалить его";
    }

    /**
     * Выводит и удаляет первый элемент из коллекции
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
            Head head = new Head("");
            otv+=head.work( collection);
            RemoveFirst removeFirst = new RemoveFirst("");
            otv+=removeFirst.work( collection);
            }
            catch(IndexOutOfBoundsException i){
                otv+="В коллекции нет элементов"+"\n";
            }
        }
        return otv;
    }
}
