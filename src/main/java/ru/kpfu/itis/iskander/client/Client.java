package ru.kpfu.itis.iskander.client;

import ru.kpfu.itis.iskander.Protocol;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), Protocol.PORT);
            MsgWriterThread msgWriterThread = new MsgWriterThread(socket);
            MsgReaderThread msgReaderThread = new MsgReaderThread(socket);
            msgReaderThread.start();
            msgWriterThread.start();
        } catch (IOException e) {
            System.out.println("Прозошла ошибка");
        }
    }

}
