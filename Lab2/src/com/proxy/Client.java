package com.proxy;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите первое число:");
        String s = br.readLine();
        while (!isDigit(s)) {
            s = br.readLine();
        }
        double a = Double.parseDouble(s);

        System.out.println("Введите второе число:");
        s = br.readLine();
        while (!isDigit(s)) {
            s = br.readLine();
        }
        double b = Double.parseDouble(s);

        br.close();

        System.out.println("\r\nЯ перемножил: " + mult(a, b));
    }

    private static double mult(double a, double b) {
        try (Socket socket = new Socket("localhost", 5000);
             DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream())) {

            oos.writeDouble(a);
            oos.writeDouble(b);
            oos.flush();

            System.out.println("Числа " + a + " и " + b + " отправлены на сервер");

            System.out.println("Ожидание ответа сервера...");
            double c = ois.readDouble();
            System.out.println("Ответ получен");
            System.out.println("Результат от сервера: " + c);

            return c;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.NaN;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Не-а, это не число...");
            return false;
        }
    }
}
