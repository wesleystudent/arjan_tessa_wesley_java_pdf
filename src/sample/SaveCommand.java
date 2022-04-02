package sample;

public class SaveCommand implements Command {
    private Receiver receiver = new Receiver();

    @Override
    public void execute(){
        System.out.println("Save Command");
        receiver.save();
    }
}
