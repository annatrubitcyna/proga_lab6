package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;

public class RemoveById extends Command {
    public RemoveById(String arg) {
        this.args=arg;
        name = "remove_by_id";
        help = "удалить элемент из коллекции по его id";
    }

    /**
     * Удаляет элемент из коллекции по его id
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (args.equals("")) {
            otv+="Введите пожалуйста id"+"\n";
        } else {
            for (int i = 0; i < collection.size(); i++) {
                int id = collection.get(i).id;
                String sId = String.valueOf(id);
                if (sId.equals(args)) {
                    otv+="Элемент удален"+"\n";
                    collection.remove(i);
                    break;
                }
                else if(i==collection.size()-1){
                    otv+="Элемента с таким id нет"+"\n";
                }
            }
        }
        return otv;
    }
}
