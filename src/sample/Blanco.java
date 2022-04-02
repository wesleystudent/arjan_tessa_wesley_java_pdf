package sample;

public class Blanco implements File{
    @Override
    public void open(String extensionName, String extension) {
        System.out.println("Blanco");
    }
}
