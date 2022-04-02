package sample;

public class CloseCommand implements Command {
    private Receiver receiver = new Receiver();

    public void execute(){
        System.out.println("Close Command");
        receiver.close();
    }
}
