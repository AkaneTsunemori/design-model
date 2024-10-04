package abstracted.factory.abstractFactory.impl;

import abstracted.factory.abstractFactory.IFurnitureFactory;
import abstracted.factory.abstractProduct.*;
import abstracted.factory.abstractProduct.impl.ArtDecoChair;
import abstracted.factory.abstractProduct.impl.ArtDecoSofa;

public class ArtDecoFactory implements IFurnitureFactory {
    @Override
    public IChair createChair() {
        System.out.println("ArtDecoChair created");
        return new ArtDecoChair();
    }

    @Override
    public ISofa createSofa() {
        System.out.println("ArtDecoSofa created");
        return new ArtDecoSofa();
    }

    @Override
    public ICoffeeTable createCoffeeTable() {
        System.out.println("ArtDecoCoffeeTable not support");
        return null;
    }
}
