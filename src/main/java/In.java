import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class In {
    private Scanner scanner;

    public In(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        scanner = new Scanner(file);
    }

    public int[] readAllInts(){
        String[] tokens = scanner.useDelimiter("\\Z").next().split("\\s+");
        int[] ints = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            ints[i] = Integer.parseInt(tokens[i]);
        }
        return ints;
    }
}
