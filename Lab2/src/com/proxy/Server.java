package com.proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Сервер включен");
        System.out.println("Ожидание подключения клиента");
        try (ServerSocket server = new ServerSocket(5000)) {
            Socket client = server.accept();
            System.out.println("Клиент подключился");

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            double a = in.readDouble();
            System.out.println("Первое число принято: " + a);

            double b = in.readDouble();
            System.out.println("Второе число принято: " + b);

            double c = a * b;
            System.out.println("Перемножил, получил: " + c);

            out.writeDouble(c);
            System.out.println("Клиенту отправлен ответ: " + c);
            out.flush();

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
