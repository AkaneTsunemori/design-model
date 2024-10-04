package decorator.dec;

import decorator.IReadWrite;

public abstract class ComponentDecorator implements IReadWrite {
    public IReadWrite iReadWrite;
    public String read(String fileName) {
        return iReadWrite.read(fileName);
    }
    public void write(String text,String fileName) {
        iReadWrite.write(text,fileName);
    }
}
