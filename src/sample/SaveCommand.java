package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements ICommand
{
    public void execute(){
        //TODO create field for user input
        String filename = "test";
        String path = "C:\\arjan_tessa_wesley_java_pdf";
        String extension = "txt";

        if(createFile(filename, extension, path))
        {
            writeToFile(filename, extension, path);
        }
    }

    public boolean createFile(String filename, String extension, String path){
        try {
            System.out.println(path);
            File file = new File(path + "\\" + filename + "." + extension);
            if (file.createNewFile()) {
                System.out.println(("File Created: " + file.getName()));
                return true;
            } else {
                System.out.println("File already exists!");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
        return false;
    }

    public void writeToFile(String filename, String extension, String path) {
        try{

            FileWriter fileWriter = new FileWriter(path + "\\" + filename + "." + extension);

            //TODO make canvas into a image/pdf

            fileWriter.write("Canvas item");
            fileWriter.close();
            System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }

    }
}
