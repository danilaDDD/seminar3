package task3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task3 {
    public static void main(String[] args) {
        try {
            openFile("hhhh");
        } catch (NonExistedFileException e) {
            e.printStackTrace();
        }
    }

    public static int divide(int a, int b){
        try {
            return a / b;
        }catch (ArithmeticException e){
            throw new DivideByZeroException("divide by zero");
        }
    }

    public static void openFile(String path) throws NonExistedFileException {
        try {
            FileReader reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new NonExistedFileException("file not found");
        }
    }
}
