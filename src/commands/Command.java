package commands;

import collectionClass.HumanBeing;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.PriorityQueue;

public abstract class Command implements Serializable {
    public String name;
    public String help;
    public String args;

    /**
     * Метод выполнения команды
     *
     * @param collection коллекция, с которой работает пользователь
     */
    public abstract String work(LinkedList<HumanBeing> collection) throws IOException;

    /**
     * @return имя команды
     */
    public String getName() {
        return name;
    }

    /**
     * @return описание работы команды
     */
    public String getHelp() {
        return help;
    }

}
