package assignment1;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    public static void write(String file, String algo, int n, Metrics m, long timeMs) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(algo + "," + n + "," + m.cmp + "," + m.moves + "," + m.depth + "," + timeMs + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}