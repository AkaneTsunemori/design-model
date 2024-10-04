package factory.method.creator;

import factory.method.product.ITransport;

public abstract class  Logistics {
    public void planDelivery(){
        ITransport transport = createTransport();
        transport.delivery();
    }
    abstract ITransport createTransport();
}
