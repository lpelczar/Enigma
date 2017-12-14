package enigma;

import app.Module;

public class App {

    private static ServiceRepository repo;
    private final String[] args;

    public App(String[] args) {
        this.args = args;
    }

    public static void main(String... args) {

        new App(args).start();

    }

    private void start() {
        if (this.args.length == 0) {

            System.out.println("Please enter following commands: -e | -d (enciper/decipher) CIPHER [KEY]");

        } else {

            repo = new ServiceRepository();
            repo.register(new PolybiusSquareEnigma());
            repo.register(new VigenereEnigma());
            repo.register(new ROT13("ROT13"));

            if (args[0].equals("-l")) {
                for (String s : repo.listAll()) {
                    System.out.println(s);
                }
                return;
            }

            Module module = new TerminalTranslator(args);
            module.initialize(repo);
            module.start();
        }

    }
}
