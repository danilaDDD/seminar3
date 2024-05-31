package task3;

import java.io.FileNotFoundException;

public class NonExistedFileException extends FileNotFoundException {
    public NonExistedFileException(String s) {
        super(s);
    }
}
