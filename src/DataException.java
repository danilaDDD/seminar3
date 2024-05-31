import java.util.List;

public class DataException extends NumberFormatException{
    public DataException(int i, int j) {
        super(String.format("in cell [%s][%s] is not number", i, j));
    }

    public DataException(List<MatrixErrorDTO> errors) {
        super(String.format("in cells %s invalid", errors));
    }
}
