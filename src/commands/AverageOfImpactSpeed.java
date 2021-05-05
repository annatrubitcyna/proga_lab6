package commands;

import collectionClass.HumanBeing;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class AverageOfImpactSpeed extends Command {
    public AverageOfImpactSpeed(String arg) {
        this.args=arg;
        name = "average of impact speed";
        help = "вывести среднее значение поля impactSpeed для всех элементов коллекции";
    }

    /**
     * Выводит среднее значение поля impactSpeed для всех элементов коллекции
     *
     * @param collection коллекция
     */
    @Override
    public String work( LinkedList<HumanBeing> collection) {
        String otv = "";
        if (!args.equals("")) {
            otv+="На данном этапе команда не принимает аргументы"+"\n";
        } else {
//            float sum = 0.0f;
//            for (int i = 0; i < collection.size(); i++) {
//                sum += collection.get(i).impactSpeed;
//            }
//            otv+="среднее значение поля impactSpeed для всех элементов коллекции: " + sum / (collection.size())+"\n";
            otv="среднее значение поля impactSpeed для всех элементов коллекции: "+collection.stream()
                    .collect(Collectors.averagingDouble(HumanBeing::getImpactSpeed)).toString();
        }
        return otv;
    }
}
