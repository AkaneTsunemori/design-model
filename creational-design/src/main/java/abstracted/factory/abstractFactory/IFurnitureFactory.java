package abstracted.factory.abstractFactory;

import abstracted.factory.abstractProduct.IChair;
import abstracted.factory.abstractProduct.ICoffeeTable;
import abstracted.factory.abstractProduct.ISofa;

public interface IFurnitureFactory {
    public IChair createChair();
    public ISofa createSofa();
    public ICoffeeTable createCoffeeTable();
}
