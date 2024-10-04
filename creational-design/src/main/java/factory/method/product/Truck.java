package factory.method.product;

public class Truck implements ITransport {
    @Override
    public void delivery() {
        System.out.println("Delivery by land in box");
    }
}
