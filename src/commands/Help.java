package commands;

import collectionClass.HumanBeing;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;

public class Help extends Command {
    public Help(String arg) {
        this.args=arg;
        name = "help";
        help = "выводит справку по доступным командам";
    }

    public static HashSet<Command> commands = new HashSet<>();

    /**
     * Выводит справку по командам
     *
     * @param collection коллекция, с которой работает пользователь
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) throws IOException {
        String otv = "";
        if (!args.equals("")) {
            otv="На данном этапе команда не принимает аргументы";
        } else {
            commands.add(new Add(args));
            commands.add(new AverageOfImpactSpeed(args));
            commands.add(new Clear(args));
            commands.add(new ExecuteScript(args));
            commands.add(new FilterContainsName(args));
            commands.add(new Head(args));
            commands.add(new Help(args));
            commands.add(new Info(args));
            commands.add(new Exit(args));
            commands.add(new PrintUniqueSoundtrackName(args));
            commands.add(new RemoveById(args));
            commands.add(new RemoveFirst(args));
            commands.add(new RemoveHead(args));
            commands.add(new Save(args));
            commands.add(new Show(args));
            commands.add(new UpdateId(args));
            for (Command command : commands) {
                //System.out.println("Команда " + command.getName() + ": " + command.getHelp());
                otv += "Команда " + command.getName() + ": " + command.getHelp() + "\n";
            }
        }
        return otv;
    }
}