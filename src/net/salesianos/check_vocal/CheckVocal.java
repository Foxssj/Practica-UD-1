package net.salesianos.check_vocal;

public class CheckVocal {
    public static void main(String[] args) {
        String character = args[0];
        String text = args[1];
        String[] words = text.split(" ");
        int counter = 0;

        for (String palabra : words) {
            System.out.println(palabra);
        }
    }
}
