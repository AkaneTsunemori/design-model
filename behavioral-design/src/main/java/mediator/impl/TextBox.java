package mediator.impl;

import mediator.Component;
import mediator.Mediator;

public class TextBox extends Component {
    public TextBox(Mediator mediator){
        super(mediator);
    }
    public void click(){
        //doSth
        mediator.signal(this,"can upload text");
    }
}
