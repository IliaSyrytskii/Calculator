package service;

import entity.Operation;
import entity.User;
import storage.InMemoryOperationStorage;
import entity.Calculator;

import java.util.List;

public class CalculatorService {

    Calculator calculator = new Calculator();

    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();

    public Operation calculate(Operation operation) {
        operation.setRes(calculator.Ñalculate(operation));
        storage.save(operation);
        return operation;
    }

    public List<Operation> findAllByUser(User user) {
        return storage.getAllByUserId(user.getId());
    }

}
