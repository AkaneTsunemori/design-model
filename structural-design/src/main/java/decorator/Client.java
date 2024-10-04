package decorator;

import decorator.dec.ComponentDecorator;
import decorator.dec.CompressionDecorator;
import decorator.dec.EncodeDecorator;

public class Client {
    public static void main(String[] args) {
        IReadWrite readWrite = new Component();
        readWrite.write("text content", "a.txt");
        System.out.println("读取结果:" + readWrite.read("a.txt"));

        System.out.println("只使用加密");
        ComponentDecorator stack = new EncodeDecorator(readWrite);
        stack.write("text content", "a.txt");
        System.out.println("读取结果:" + stack.read("a.txt"));

        System.out.println("使用加密,压缩");
        stack = new CompressionDecorator(readWrite);
        stack.write("text content", "a.txt");
        System.out.println("读取结果:" + stack.read("a.txt"));


        //装饰器可以实现多层的装饰,类似一个栈的结构不断的加装饰
        System.out.println("使用加密,压缩,压缩");
        stack = new CompressionDecorator(stack);
        stack.write("text content", "a.txt");
        System.out.println("读取结果:" + stack.read("a.txt"));
    }
}
