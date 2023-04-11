package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainS {
    public static void main(String[] args) {
        ArrayList<ServerThread> threadList = new ArrayList<>();
        try (ServerSocket ServerSocket = new ServerSocket(5000)){
            Socket socket = ServerSocket.accept();
            ServerThread serverThread = new ServerThread(socket, threadList);
            threadList.add(serverThread);
            serverThread.start();
        } catch (Exception e) {
            System.out.println("Exception in server main" + e.getStackTrace());
        }
    }
}
