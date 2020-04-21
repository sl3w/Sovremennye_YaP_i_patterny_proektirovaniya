package com.Chain_3_1;

import com.Car;

public class chainMain {
    public static void main(String[] args) {
        Chain rowPrint = new RowPrint();
        Chain columPrint  = new ColumPrint();

        rowPrint.setNextChain(columPrint);

        rowPrint.write(new Car("Машинка",5));
    }
}
