package commands;

import collectionClass.HumanBeing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;

public class Info extends Command {
    public Info(String arg) {
        this.args=arg;
        name = "info";
        help = "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) throws IOException {
        String otv = "";
        if (!args.equals("")) otv+="Команда не принимает аргументы"+"\n";
        else {
            otv+="Тип коллекции: " + collection.getClass().getName()+"\n";
            String fileName = "C:\\Users\\777\\IdeaProjects\\lab5\\src\\data.json";
            Path file = Paths.get(fileName);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            otv+="Время создания коллекции: " + attr.creationTime()+"\n";
            otv+="Количество элементов в коллеции: " + collection.size()+"\n";
        }
        return otv;
    }
}
