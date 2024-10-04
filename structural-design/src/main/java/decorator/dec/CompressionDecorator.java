package decorator.dec;

import decorator.IReadWrite;

public class CompressionDecorator extends ComponentDecorator {
    String cut;

    public CompressionDecorator(IReadWrite iReadWrite) {
        this.iReadWrite = iReadWrite;
    }

    public String read(String fileName) {
        return deCompress(iReadWrite.read(fileName));
    }

    public void write(String text, String fileName) {
        iReadWrite.write(compress(text), fileName);
    }

    public String compress(String text) {
        cut = text.substring(0, 5);
        return text.substring(5);
    }

    public String deCompress(String text) {
        return cut + text;
    }
}
