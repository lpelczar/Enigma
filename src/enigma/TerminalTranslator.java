package enigma;

import app.Module;
import services.EnigmaService;
import registry.ServiceProvider;

import java.util.Scanner;

public class TerminalTranslator implements Module {

    private ServiceProvider provider;
    private String[] args;
    private EnigmaService enigma;

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

            this.enigma = provider.getByName(enigmaName);

            if (this.enigma.isKeyRequired() && this.args.length < 3) {
                System.out.println("You need to enter a key!");
                return;
            }
            if (!this.enigma.isKeyRequired() && this.args.length == 3) {
                System.out.println("Key is not needed for this cipher!");
                return;
            }

            if (this.args.length == 3) {
                if (this.args[2].chars().allMatch(Character::isLetter)) {
                    String key = this.args[2];
                    this.enigma.setKey(key.toUpperCase());
                } else {
                    System.out.println("Key need to contain only letters!");
                    return;
                }
            }

            translateInput();

        }
    }

    public void translateInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        while (scan.hasNextLine()) {

            if (this.args[0].equals("-e")) {
                System.out.print("Enciphered text: ");
                System.out.println(this.enigma.encipher(scan.nextLine()));
            } else if (this.args[0].equals("-d")) {
                System.out.println(this.enigma.decipher(scan.nextLine()));
            }
            System.out.print("Enter text: ");
        }
    }
}
