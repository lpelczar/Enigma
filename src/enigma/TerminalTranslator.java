package enigma;

import app.Module;
import services.EnigmaService;
import registry.ServiceProvider;

import java.util.Scanner;

public class TerminalTranslator implements Module {

    private ServiceProvider provider;
    private String[] args;

    public void initialize(ServiceProvider provider) {
        this.provider = provider;
    }

    public TerminalTranslator(String... args) {
        this.args = args;
    }

    public String getName() {
        return "TerminalTranslator";
    }

    public void start() {
        String mode = args[0];
        String enigmaName = args[1];
        EnigmaService enigma = provider.getByName(enigmaName);

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            if (this.args[0].equals("-e")) {
                System.out.println(enigma.encipher(scan.nextLine()));
            } else if (this.args[0].equals("-d")) {
                System.out.println(enigma.decipher((scan.nextLine())));

            }
        }
    }
}
