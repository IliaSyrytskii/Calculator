package console.utilities;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
