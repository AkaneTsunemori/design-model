package mediator.impl;

import mediator.Component;
import mediator.Mediator;

public class CheckBox extends Component {
    public CheckBox(Mediator mediator) {
        super(mediator);
    }
    public boolean check(){
        return true;
    }
}
