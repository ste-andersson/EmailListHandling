import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        List<String> lines = Files.readAllLines(Path.of("input.csv"));
        List<String> outputLines = new ArrayList<>();
        outputLines.add("First name,Last name,Email");


        for (int i = 1; i < lines.size(); i++) {
            String email = lines.get(i);
            String firstName = email.substring(0, 1).toUpperCase() + email.substring(1, email.indexOf("."));
            String lastName = email.substring(email.indexOf(".")+1, email.indexOf(".")+2).toUpperCase() + email.substring(email.indexOf(".")+2, email.indexOf("@"));
            System.out.println(firstName + " " + lastName + " " + email);
            outputLines.add(firstName + "," + lastName + "," + email);
        }

        Files.write(Path.of("output.csv"), outputLines);

    }
}