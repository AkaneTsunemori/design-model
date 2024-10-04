package abstracted.factory;

import abstracted.factory.abstractFactory.impl.ArtDecoFactory;
import abstracted.factory.abstractFactory.IFurnitureFactory;
import abstracted.factory.abstractFactory.impl.ModernFactory;

public class Client {
    IFurnitureFactory iFurnitureFactory;

    public Client(IFurnitureFactory furnitureFactory){
        this.iFurnitureFactory = furnitureFactory;
    }

    public void setIFurnitureFactory(IFurnitureFactory furnitureFactory){
        this.iFurnitureFactory = furnitureFactory;
    }

    public void generateServalFurnitures(){
        iFurnitureFactory.createChair();
        iFurnitureFactory.createSofa();
        iFurnitureFactory.createCoffeeTable();
    }

    public static void main(String[] args) {
        Client client = new Client(new ArtDecoFactory());
        client.generateServalFurnitures();
        System.out.println();
        client.setIFurnitureFactory(new ModernFactory());
        client.generateServalFurnitures();
    }

}
