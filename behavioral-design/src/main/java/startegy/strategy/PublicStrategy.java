package startegy.strategy;

public class PublicStrategy implements IRouterStrategy {
    @Override
    public String generateRoute() {
        return "get public strategy";
    }
}
