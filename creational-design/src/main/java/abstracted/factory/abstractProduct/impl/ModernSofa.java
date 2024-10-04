package abstracted.factory.abstractProduct.impl;

import abstracted.factory.abstractProduct.ISofa;

public class ModernSofa implements ISofa {
    @Override
    public boolean isSoft() {
        return false;
    }

    @Override
    public void sitOn() {
        System.out.println("sit on modern sofa!");
    }
}
