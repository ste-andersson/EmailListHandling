import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("input.csv"));
        List<String> outputLines = new ArrayList<>();
        outputLines.add("First name,Last name,Email");

        Map<String, String> firstNameMap = new HashMap<>();
        firstNameMap.put("orjan", "örjan");
        firstNameMap.put("ake", "åke");
        firstNameMap.put("age", "åge");
        firstNameMap.put("asa", "åsa");
        firstNameMap.put("ase", "åse");
        firstNameMap.put("hakan", "håkan");
        firstNameMap.put("mans", "måns");
        firstNameMap.put("marten", "mårten");
        firstNameMap.put("pal", "pål");
        firstNameMap.put("kare", "kåre");
        firstNameMap.put("par", "pär");
        firstNameMap.put("marta", "märta");
        firstNameMap.put("bjorn", "björn");
        firstNameMap.put("borje", "börje");
        firstNameMap.put("goran", "göran");
        firstNameMap.put("gosta", "gösta");
        firstNameMap.put("gote", "göte");
        firstNameMap.put("jorgen", "jörgen");
        firstNameMap.put("soren", "sören");
        firstNameMap.put("osten", "östen");
        firstNameMap.put("torbjorn", "torbjörn");
        firstNameMap.put("hjordis", "hjördis");

        Map<String, String> lastNameMap = new HashMap<>();
        lastNameMap.put("soder", "söder");
        lastNameMap.put("back", "bäck");
        lastNameMap.put("gard", "gård");


        for (int i = 1; i < lines.size(); i++) {
            String email = lines.get(i).toLowerCase();
            String firstName = email.substring(0, email.indexOf("."));
            String lastName = email.substring(email.indexOf(".")+1, email.indexOf("@"));
            firstName = firstNameMap.getOrDefault(firstName, firstName);
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, firstName.length());
            for(var entry : lastNameMap.entrySet()) {
                lastName = lastName.replace(entry.getKey(), entry.getValue());
            }
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1, lastName.length());
            System.out.println(firstName + " " + lastName + " " + email);
            outputLines.add(firstName + "," + lastName + "," + email);
        }

        Files.write(Path.of("output.csv"), outputLines);

    }
}