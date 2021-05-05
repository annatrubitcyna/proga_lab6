import collectionClass.HumanBeing;
import commands.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

public class Client2 {
    public static void main(String[] args) {
        System.out.println("Starting client module.\nConnecting to server ...");
        try (Socket outcoming = new Socket(InetAddress.getLocalHost(), 7777)) {
            outcoming.setSoTimeout(10000);
            try (ObjectOutputStream toServer = new ObjectOutputStream(outcoming.getOutputStream());
                 ObjectInputStream fromServer = new ObjectInputStream(outcoming.getInputStream());
                 Scanner fromKeyboard = new Scanner(System.in)) {
                System.out.println((String) fromServer.readObject());
                String line = "";
                String commanda = "";
                String arg = "";
                LinkedList<HumanBeing> collection = new LinkedList<>();
                List<Integer> arrayId = new ArrayList<Integer>();
                int id = (int) (Math.random() * 1000);
                do {
                    System.out.println("введите команду");
                    line = fromKeyboard.nextLine();
                    commanda = line.split(" ")[0];
                    if (line.split(" ").length != 1) {
                        arg = line.split(" ")[1];
                    } else {
                        arg = "";
                    }
                    switch (commanda) {
                        case ("exit"):
                            Object exit = new Exit(arg);
                            toServer.writeObject(exit);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("help"):
                            Object help = new Help(arg);
                            toServer.writeObject(help);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("head"):
                            Head head = new Head(arg);
                            toServer.writeObject(head);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("info"):
                            Info info = new Info(arg);
                            toServer.writeObject(info);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("add"):
                            while (arrayId.contains(id)) {
                                id = (int) (Math.random() * 1000);
                            }
                            arrayId.add(id);
                            Add add = new Add(line + " " + id);
                            toServer.writeObject(add);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("averageOfImpactSpeed"):
                            AverageOfImpactSpeed averageOfImpactSpeed = new AverageOfImpactSpeed(arg);
                            toServer.writeObject(averageOfImpactSpeed);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("clear"):
                            Clear clear = new Clear(arg);
                            toServer.writeObject(clear);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("executeScript"):
                            ExecuteScript executeScript = new ExecuteScript(arg);
                            toServer.writeObject(executeScript);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("filterContainsName"):
                            FilterContainsName filterContainsName = new FilterContainsName(arg);
                            toServer.writeObject(filterContainsName);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("printUniqueSoundtrackName"):
                            PrintUniqueSoundtrackName printUniqueSoundtrackName = new PrintUniqueSoundtrackName(arg);
                            toServer.writeObject(printUniqueSoundtrackName);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("removeById"):
                            RemoveById removeById = new RemoveById(arg);
                            toServer.writeObject(removeById);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("removeFirst"):
                            RemoveFirst removeFirst = new RemoveFirst(arg);
                            toServer.writeObject(removeFirst);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("removeHead"):
                            RemoveHead removeHead = new RemoveHead(arg);
                            toServer.writeObject(removeHead);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("save"):
                            Save save = new Save(arg);
                            toServer.writeObject(save);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("show"):
                            Show show = new Show(arg);
                            toServer.writeObject(show);
                            System.out.println((String) fromServer.readObject());
                            break;
                        case ("updateId"):
                            UpdateId updateId = new UpdateId(line);
                            toServer.writeObject(updateId);
                            System.out.println((String) fromServer.readObject());
                            break;
                        default:
                            System.out.println("Такой команды нет");
                    }
                }while (!commanda.equals("exit"));
//                while (!(command = fromKeyboard.nextLine()).equals("exit")) {
//                    toServer.writeObject(command);
//                    System.out.println((String) fromServer.readObject());
//                }
                System.out.println("Closing socket and terminating program.");
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        }  catch (IOException e) {
            System.out.println("Could not connect. Something went wrong.");
        }
    }
}
