package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class UpdateId extends Command {
    public UpdateId(String arg) {
        this.args=arg;
        name = "update id";
        help = " обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Обновляет значение элемента коллекции, id которого равен заданному
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        otv+="Элемент обновлен"+"\n";
        if (args.equals("")) {
            otv+="Введите дополнительные аргументы"+"\n";
        } else {
            RemoveById removeById = new RemoveById(args.split(" ")[args.split(" ").length - 1]);
            System.out.println(args.split(" ")[args.split(" ").length - 1]);
            System.out.println(args);
            otv+=removeById.work(collection);
            Add add = new Add(args);
            otv+=add.work( collection);
        }
        return otv;
    }
    //updateId Ann 10 35 True True 90.0 Name1 BAT CALM True 4
}
