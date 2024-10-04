package abstracted.factory.abstractProduct.impl;

import abstracted.factory.abstractProduct.IChair;

public class ModernChair implements IChair {
    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public void sitOn() {
        System.out.println("sit on modern chair!");
    }
}
