package assignment1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    public static void write(String file, String algo, int n, Metrics m, long timeMs) {
        try {
            File f = new File(file);
            boolean newFile = !f.exists(); // проверка новый файл или нет

            try (FileWriter fw = new FileWriter(f, true)) {
                if (newFile) {
                    fw.write("algorithm,n,timeMs,depth,comparisons,moves\n");
                }
                fw.write(algo + "," + n + "," + timeMs + "," + m.depth + "," + m.cmp + "," + m.moves + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}