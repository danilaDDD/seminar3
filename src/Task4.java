import java.util.ArrayList;
import java.util.List;

/**
 Напишите метод, на вход которого подаётся двумерный квадратный (ширина = высоте) массив.
 При подаче массива другого размера необходимо бросить исключение SizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в число и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение DataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    static String[][] arr = new String[][] {
            {"1", "1.5eeee", "1.5"},
            {"1,", "1.5", "1.5"},
            {"1", "1.5", "1.5ddd"}
    };


    public static void main(String[] args) {
        System.out.println(sum2d(arr));
    }

    public static double sum2d(String[][] arr) {
        double sum = 0;
        List<MatrixErrorDTO> errors = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr.length != arr[i].length)
                throw new SizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Double.parseDouble(arr[i][j]);
                }catch (NumberFormatException e){
                    errors.add(new MatrixErrorDTO(i, j, arr[i][j]));
                }
            }

        }

        if(!errors.isEmpty())
            throw new DataException(errors);
        return sum;
    }

}

class MatrixErrorDTO{
    int x;
    int y;
    String invalidValue;

    public MatrixErrorDTO(int y, int x, String invalidValue) {
        this.y = y;
        this.x = x;
        this.invalidValue = invalidValue;
    }

    @Override
    public String toString() {
        return String.format("{x=%s, y=%s, value=%s}", x, y, invalidValue);
    }
}