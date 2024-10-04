package abstracted.factory.abstractFactory.impl;

import abstracted.factory.abstractFactory.IFurnitureFactory;
import abstracted.factory.abstractProduct.*;
import abstracted.factory.abstractProduct.impl.ModernChair;
import abstracted.factory.abstractProduct.impl.ModernSofa;

public class ModernFactory implements IFurnitureFactory {
    @Override
    public IChair createChair() {
        System.out.println("ModernChair created");
        return new ModernChair();
    }

    @Override
    public ISofa createSofa() {
        System.out.println("ModernSofa created");
        return new ModernSofa();
    }

    @Override
    public ICoffeeTable createCoffeeTable() {
        System.out.println("ModernSofaCoffeeTable not support");
        return null;
    }
}
