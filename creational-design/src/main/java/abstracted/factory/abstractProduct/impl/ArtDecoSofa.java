package abstracted.factory.abstractProduct.impl;

import abstracted.factory.abstractProduct.ISofa;

public class ArtDecoSofa implements ISofa {

    @Override
    public boolean isSoft() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("sit on art art decorate sofa!");

    }
}
