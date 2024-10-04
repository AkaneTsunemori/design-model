package factory.method;

import factory.method.creator.Logistics;
import factory.method.creator.RoadLogistics;
import factory.method.creator.SeaLogistics;

public class Client {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();
        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}
