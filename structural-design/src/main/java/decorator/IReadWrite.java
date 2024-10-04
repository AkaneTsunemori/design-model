package decorator;

public interface IReadWrite {
    public String read(String fileName);

    public void write(String text, String fileName);
}
