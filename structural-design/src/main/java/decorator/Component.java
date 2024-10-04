package decorator;

public class Component implements IReadWrite{
    String text;
    public String read(String fileName) {
        System.out.println("读取文件 :"+fileName+"内容: "+ text);
        return text;
    }
    public void write(String text,String fileName) {
        this.text = text;
        System.out.println("写入文件:"+fileName+"内容: "+ text);
    }
}
