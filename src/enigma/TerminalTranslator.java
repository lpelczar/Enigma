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
            System.out.println(Colors.ANSI_RED + "Incorrect commands!" + Colors.ANSI_RESET);
        } else {
            String mode = this.args[0];
            String enigmaName = this.args[1];

            if (provider.getByName(enigmaName) == null) {
                System.out.println(Colors.ANSI_RED + "Enigma does not exist!" + Colors.ANSI_RESET);
                return;
            }

            this.enigma = provider.getByName(enigmaName);

            if (this.enigma.isKeyRequired() && this.args.length < 3) {
                System.out.println(Colors.ANSI_RED + "You need to enter a key!" + Colors.ANSI_RESET);
                return;
            }
            if (!this.enigma.isKeyRequired() && this.args.length == 3) {
                System.out.println(Colors.ANSI_RED + "Key is not needed for this cipher!" + Colors.ANSI_RESET);
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
        System.out.print(Colors.ANSI_BLUE + "Enter text: " + Colors.ANSI_RESET);
        while (scan.hasNextLine()) {

            if (this.args[0].equals("-e")) {
                System.out.print(Colors.ANSI_PURPLE + "Enciphered text: " + Colors.ANSI_RESET);
                System.out.println(this.enigma.encipher(scan.nextLine()));
            } else if (this.args[0].equals("-d")) {
                System.out.print(Colors.ANSI_PURPLE + "Deciphered text: " + Colors.ANSI_RESET);
                System.out.println(this.enigma.decipher(scan.nextLine()));
            }
            System.out.print(Colors.ANSI_BLUE + "Enter text: " + Colors.ANSI_RESET);
        }
    }
}
