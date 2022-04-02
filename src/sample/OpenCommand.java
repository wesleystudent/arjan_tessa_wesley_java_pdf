package sample;

import java.io.File;

public class OpenCommand implements Command{
    private final Receiver receiver = new Receiver();
    public File file = null;

    @Override
    public synchronized void execute() {
        System.out.println("Open Command");
        file = receiver.open();
    }
}
