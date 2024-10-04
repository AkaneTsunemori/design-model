package factory.method.product;

public class Ship implements ITransport {
    @Override
    public void delivery() {
        System.out.println("Delivery by sea in a container");
    }
}
