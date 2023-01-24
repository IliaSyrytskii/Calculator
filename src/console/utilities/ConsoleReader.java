package console.utilities;

import java.util.Scanner;

public class ConsoleReader implements Reader{

    private Scanner sc = new Scanner(System.in);

    @Override
    public String readString() {
        return sc.next();
    }

    @Override
    public Double readDouble() {
        return sc.nextDouble();
    }

    @Override
    public int readInt() {
        return sc.nextInt();
    }

}
