
import collectionClass.HumanBeing;
import commands.Command;
import commands.Parcer;
import commands.Save;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        try (ServerSocket ss = new ServerSocket(7777)) {
            System.out.println("ServerSocket awaiting connections...");
            Parcer parcer=new Parcer();
            LinkedList<HumanBeing> collection =parcer.work();
            try (Socket socket = ss.accept()) {
                System.out.println("Connection from " + socket + "!");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                    objectOutputStream.writeObject("Connection establish.");
                    while (true) {
                        Object message = objectInputStream.readObject();
                        Command command=null;
                        String arg = "";
                        if (message instanceof Command)
                            command = (Command)message;
                            if (command.name.equals("exit")){
                                Save save=new Save("");
                                objectOutputStream.writeObject(save.work(collection)+" Конец работы");
                                System.out.println("Client initialize connections suicide ...");
                                objectOutputStream.writeUTF("Server reply - "+message + " - OK");
                                objectOutputStream.flush();
                                Thread.sleep(3000);
                                break;
                            }
                            else{
                                objectOutputStream.writeObject(command.work(collection));
                            }
                        System.out.println("Received [" + message + "] from: " + socket);
//                        message = "Answer ::: " + message + "\ntest string";
//                        objectOutputStream.writeObject(message);
                    }
                }
            }
        }
    }
}
