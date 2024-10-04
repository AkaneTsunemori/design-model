package factory.method.creator;

import factory.method.product.ITransport;
import factory.method.product.Truck;

public class RoadLogistics extends Logistics{

    @Override
    public ITransport createTransport() {
        return new Truck();
    }
}
