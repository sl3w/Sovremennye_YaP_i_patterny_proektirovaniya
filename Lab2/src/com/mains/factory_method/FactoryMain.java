package com.mains.factory_method;

import com.Transport;
import com.exceptions.DuplicateModelNameException;
import com.exceptions.NoSuchModelNameException;
import com.model.Moto;
import com.model.interfaces.Transportable;

import java.util.Arrays;

public class FactoryMain {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {

//         до интерфейсов
        Transportable veh = new Moto("car1", 10);

        write(veh.toString());

        write(veh.getMarka());
        write(Arrays.toString(veh.getModelsNameArray()));
        write(Arrays.toString(veh.getPricesArray()));

        veh.deleteModel("model_10");

        write(veh.toString());

        veh.setPriceByModelName("model_9", 999);
        veh.setNewModelName("model_9", "model_99");

        write(veh.toString());

        write("Models count: " + veh.getModelsCount());


//        интерфейсы
//        Transportable vehicle = new Auto("marka", 4);
        write("------------------------------------");
        write("Average price:" + Transport.getAverageModelsPrice(veh));
        Transport.printModelsWithPrice(veh);

//        фабрики
//        write(Transport.createInstance("car", 5).toString());
//
//        MotoFactory motoFactory = MotoFactory.getFactory();
//        Transport.setTransportFactory(motoFactory);
//
//        write(Transport.createInstance("moto", 7).toString());
    }

    private static void write(String str) {
        System.out.println(str);
    }
}
