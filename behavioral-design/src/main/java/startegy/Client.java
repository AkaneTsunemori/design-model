package startegy;

import startegy.context.Navigator;
import startegy.strategy.PublicStrategy;
import startegy.strategy.RoadStrategy;

public class Client {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        navigator.setIRouterStrategy(new RoadStrategy());
        System.out.println(navigator.getRoute());
        navigator.setIRouterStrategy(new PublicStrategy());
        System.out.println(navigator.getRoute());
    }
}
