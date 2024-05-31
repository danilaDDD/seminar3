import java.io.IOException;

/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */

public class Counter implements AutoCloseable {
    public int counter = 0;
    private boolean closed = false;

    public void add() throws IOException {
        if(closed)
            throw new IOException("recource is closed");

        counter++;
    }
    @Override
    public void close() throws IOException {
        closed = true;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        Counter counter = new Counter();
        try(counter){
            System.out.println(counter.counter);
            counter.add();
        }
        System.out.println(counter.counter);
        counter.add();
    }
}