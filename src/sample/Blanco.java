package sample;

public class Blanco implements File{
    @Override
    public java.io.File open(String extensionName, String extension) {
        System.out.println("Blanco");
        return null;
    }
}
