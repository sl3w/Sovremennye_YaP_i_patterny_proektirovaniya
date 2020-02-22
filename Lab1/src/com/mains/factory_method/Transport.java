package com.mains.factory_method;

import com.exceptions.DuplicateModelNameException;
import com.factories.AutoFactory;
import com.factories.interfaces.TransportFactory;
import com.model.interfaces.Transportable;

public class Transport {
    private static TransportFactory factory = new AutoFactory();

    public static void setTransportFactory(TransportFactory transportFactory) {
        factory = transportFactory;
    }

    public static double getAverageModelsPrice(Transportable vehicle) {
        double sum = 0;
        double[] prices = vehicle.getPricesArray();
        if (prices.length > 0) {
            for (int i = 0; i < prices.length; i++) {
                sum += prices[i];
            }
            return sum / prices.length;
        }
        return 0; //or Double.NaN
    }

    public static void printModels(Transportable vehicle) {
        String[] models = vehicle.getModelsNameArray();
        for (int i = 0; i < models.length; i++) {
            System.out.println(models[i]);
        }
    }

    public static void printPrices(Transportable vehicle) {
        double[] prices = vehicle.getPricesArray();
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
    }

    public static void printModelsWithPrice(Transportable vehicle) {
        String[] models = vehicle.getModelsNameArray();
        double[] prices = vehicle.getPricesArray();
        for (int i = 0; i < models.length; i++) {
            System.out.println(models[i] + " – " + prices[i]);
        }
    }

    public static Transportable createInstance(String name, int size) throws DuplicateModelNameException {
        return factory.createInstance(name, size);
    }
}
