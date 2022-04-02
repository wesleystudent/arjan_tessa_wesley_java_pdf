package sample;

public class OpenCommand implements Command{
    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        System.out.println("Open Command");
        receiver.open();
    }
}
