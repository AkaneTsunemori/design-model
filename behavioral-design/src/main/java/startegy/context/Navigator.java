package startegy.context;

import startegy.strategy.IRouterStrategy;

public class Navigator {
    private IRouterStrategy iRouterStrategy;
    public void setIRouterStrategy(IRouterStrategy routerStrategy){
        iRouterStrategy = routerStrategy;
    }
    public String getRoute(){
        return iRouterStrategy.generateRoute();
    }
}
