package mediator.impl;

import mediator.Component;
import mediator.Mediator;

public class Button extends Component {
    public Button(Mediator mediator) {
        super(mediator);
    }
    public void click(){
        //doSth
        mediator.signal(this,"button clicked");
    }
}
