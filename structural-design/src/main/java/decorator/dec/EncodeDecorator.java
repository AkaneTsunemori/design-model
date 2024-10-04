package decorator.dec;

import decorator.IReadWrite;

public class EncodeDecorator extends ComponentDecorator {
    public EncodeDecorator(IReadWrite iReadWrite){
        this.iReadWrite = iReadWrite;
    }
    public String read(String fileName) {
        return decode(iReadWrite.read(fileName));
    }

    public void write(String text,String fileName) {
        iReadWrite.write(encode(text),fileName);
    }
    public String encode(String text){
        return "encode"+text;
    }
    public String decode(String text){
        return text.substring(6);
    }
}
