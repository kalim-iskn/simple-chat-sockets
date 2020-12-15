package ru.kpfu.itis.iskander.server;

import ru.kpfu.itis.iskander.Protocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static ArrayList<SocketConnection> socketConnections = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(Protocol.PORT);
        } catch (IOException e) {
            System.out.println("Произошла ошибка с сервером");
        }

        if (server != null) {
            while (true) {
                try {
                    Socket socket = server.accept();
                    socketConnections.add(new SocketConnection(socket));
                } catch (IOException e) {
                    break;
                }
            }
        }
    }

    public static ArrayList<SocketConnection> getSocketConnections() {
        return socketConnections;
    }

    public static void deleteSocketConnection(SocketConnection socketConnection) {
        socketConnections.remove(socketConnection);
    }

}
