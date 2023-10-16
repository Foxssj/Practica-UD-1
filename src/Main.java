import net.salesianos.launcher.ProcessLauncher;
import net.salesianos.utils.Utils;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = Utils.getAllLines("C:\\Users\\nican\\Desktop\\Cosas de clase" +
                "\\pro\\Practica UD-1\\src\\lorem_ipsum.txt");
        ArrayList<Process> allProcesses = new ArrayList<>();

        Integer lineCounter = 0;
        for (String line : lines) {
            lineCounter++;
            String outputFileName = "outputLine" + lineCounter + ".txt";
            Process javaProcess = ProcessLauncher.initWordCounterProcess(line, outputFileName);
            allProcesses.add(javaProcess);
        }

        for (Process process : allProcesses) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer totalWords = 0;

        for (int i = 1; i <= lineCounter; i++) {
            String outputFileName = "outputLine" + i + ".txt";
            String outputFileRoute = "C:\\Users\\nican\\Desktop\\Cosas de clase\\pro\\Practica UD-1" +
                    "\\src\\net\\salesianos\\outputs" + outputFileName;
            Integer wordsFromFile = Utils.getTotalWordsFrom(outputFileRoute);
            totalWords += wordsFromFile;



            System.out.println("El fichero " + outputFileName + " tiene " + wordsFromFile + " palabras");

            File outputFile = new File(outputFileRoute);
            outputFile.delete();
        }

        System.out.println("El fichero tiene " + lines.size() + " lineas y " + totalWords + " palabras.");


    }
}