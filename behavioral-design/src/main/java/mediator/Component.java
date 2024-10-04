package mediator;

public abstract class Component {
    public Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
    public Component() {
    }
    void click(){}
    void keyPress(){}
}
