package com;

import com.exception.DuplicateModelNameException;
import com.interfaces.TransportFactory;
import com.interfaces.Vehicle;

public class Utils {
    // метод, возвращающий среднее арифметическое цен моделей для заданного Транспортного средства
    public static double getAverageCost (Vehicle vehicle){
        double[] array = vehicle.getCostModelArray();
        double average = 0;
        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        return average / array.length;
    }

    //методы, обеспечивающие вывод на экран всех моделей и всех цен на модели для заданного Транспортного средства.
    public  static void printNameModels(Vehicle vehicle){
        String[] arrayName = vehicle.getNameModelArray();
        String temp = "NameModels = [";
        for (int i = 0; i < arrayName.length; i++) {
            temp += arrayName[i] + ", ";
        }
        temp +="]";
        System.out.println(temp);
    }
    public static void printCostModels(Vehicle vehicle){
        double[] arrayCost = vehicle.getCostModelArray();
        String temp = "NameModels = [";
        for (int i = 0; i < arrayCost.length; i++) {
            temp += Double.toString(arrayCost[i]) + ", ";
        }
        temp +="]";
        System.out.println(temp);
    }

    private static TransportFactory factory = new AutoFactory();
    public static void setTransportFactory(TransportFactory  factory){
        Utils.factory = factory;
    }

    public static Vehicle createInstance(String name, int length) throws DuplicateModelNameException {
        return factory.createInstance(name, length);
    }
    public static Vehicle synchronizedTransport (Vehicle t){
        return new TransportDecorator(t);
    }
}
