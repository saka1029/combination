package stackoverflow;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Project1 {
    public static void main(String[] args) throws Exception {
        Network t1 = new Network();
        t1.start();
        Thread.sleep(20000);
        t1.changeConnection("disconnect");
    }
}

class Network extends Thread {
    static String server = "foo.com";
    static int port = 22;
    Socket socket;

    public void changeConnection(String command) throws UnknownHostException, IOException {
        if (command.equals("connect"))
            socket = new Socket(server, port);
        else if (command.equals("disconnect"))
            socket.close();
    }

    @Override
    public void run() {
    }
}