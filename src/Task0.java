import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;

/**
 * Перепишите код, воспользовавшись механизмом try-with-resources
 */
public class Task0 {

    public void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try(BufferedReader in = newBufferedReader(pathRead);
        BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }
}