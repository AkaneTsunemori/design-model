package factory.method.creator;

import factory.method.product.Ship;
import factory.method.product.ITransport;

public class SeaLogistics extends Logistics{
    @Override
    ITransport createTransport() {
        return new Ship();
    }
}
