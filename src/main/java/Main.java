public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        TopSecret program = new TopSecret(args);
        program.connector(args);
    }
}