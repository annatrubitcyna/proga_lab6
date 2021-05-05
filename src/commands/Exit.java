package commands;

import collectionClass.HumanBeing;

import java.io.IOException;
import java.util.LinkedList;

public class Exit extends Command{
    public Exit(String arg) {
        this.args=arg;
        name = "exit";
        help = "завершить работу программы";
    }

    @Override
    public String work(LinkedList<HumanBeing> collection) throws IOException {
        return "";
    }
}
