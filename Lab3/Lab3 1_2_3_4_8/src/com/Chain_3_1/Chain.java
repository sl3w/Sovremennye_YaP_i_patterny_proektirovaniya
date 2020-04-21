package com.Chain_3_1;

import com.interfaces.Vehicle;

public interface Chain {
    void setNextChain(Chain chain);
    void write(Vehicle vehicle);
}
