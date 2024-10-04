package startegy.strategy;

public class WalkStrategy implements IRouterStrategy {
    @Override
    public String generateRoute() {
        return "get route on foot";
    }
}
