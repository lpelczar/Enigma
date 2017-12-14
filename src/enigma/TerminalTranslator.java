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
        if (this.args.length > 3 || this.args.length <= 1) {
            System.out.println("Incorrect commands!");

        } else {

            String mode = this.args[0];
            String enigmaName = this.args[1];

            if (provider.getByName(enigmaName) == null) {
                System.out.println("Enigma does not exist!");
                return;
            }

            EnigmaService enigma = provider.getByName(enigmaName);

            if (enigma.isKeyRequired() && this.args.length < 3) {
                System.out.println("You need to enter a key!");
                return;
            }
            if (!enigma.isKeyRequired() && this.args.length == 3) {
                System.out.println("Key is not needed for this cipher!");
                return;
            }

            if (this.args.length == 3) {
                String key = this.args[2];
                enigma.setKey(key);
            }

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
}
