package entity;

public class Calculator {
    public double Ñalculate (Operation operation) {
        switch (operation.getType()) {
            case "sum" -> {
                operation.setRes(sum(operation.getNum1(), operation.getNum2()));
            }
            case "sub" -> {
                operation.setRes(sub(operation.getNum1(), operation.getNum2()));
            }
            case "mult" -> {
                operation.setRes(mult(operation.getNum1(), operation.getNum2()));
            }
            case "div" -> {
                operation.setRes(div(operation.getNum1(), operation.getNum2()));
            }
        }
        return 0;
    }
    private static double sum (double a, double b) {
        return a + b;
    }
    private static double sub (double a, double b) {
        return a - b;
    }
    private static double mult (double a, double b) {
        return a * b;
    }
    private static double div (double a, double b) {
        return a / b;
    }

}
