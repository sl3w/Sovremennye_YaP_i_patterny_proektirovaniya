package com.mains.factory_method;

import com.exceptions.DuplicateModelNameException;
import com.exceptions.NoSuchModelNameException;
import com.factories.MotoFactory;

public class FactoryMain {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {

//         до интерфейсов
//        Moto veh = new Moto("car1", 10);
//
//        write(veh.toString());
//
//        write(veh.getMarka());
//        write(Arrays.toString(veh.getModelsNameArray()));
//        write(Arrays.toString(veh.getPricesArray()));
//
//        veh.deleteModel("model10");
//
//        write(veh.toString());
//
//        veh.setPriceByModelName("model9", 999);
//        veh.setNewModelName("model9", "model999");
//
//        write(veh.toString());
//
//        write("Models count: " + veh.getModelsCount());


//        интерфейсы
//        Vehiclable vehicle = new Auto("marka", 4);
//        write("Average price:" + Vehicle.getAverageModelsPrice(vehicle));
//        Vehicle.printModelsWithPrice(vehicle);

//        фабрики
        write(Vehicle.createInstance("car", 5).toString());

        MotoFactory motoFactory = new MotoFactory();
        Vehicle.setTransportFactory(motoFactory);

        write(Vehicle.createInstance("moto", 7).toString());
    }

    private static void write(String str) {
        System.out.println(str);
    }
}
