package console;

import console.utilities.ConsoleReader;
import console.utilities.ConsoleWriter;
import entity.Operation;
import entity.User;
import service.CalculatorService;
import service.ServiceUser;

import java.util.List;
import java.util.Optional;

public class ConsoleApp implements Application {

    public static ConsoleSession consoleSession;
    private final ServiceUser serviceUser = new ServiceUser();
    private final CalculatorService calculatorService = new CalculatorService();
    ConsoleReader reader = new ConsoleReader();
    ConsoleWriter writer = new ConsoleWriter();

    @Override
    public void run() {
        while (true) {
            if (consoleSession == null) {
                writer.write("Hello Guest");
                writer.write("""
                        1 - Registration;
                        2 - Login;
                        3 - Logout;
                        """);
                int t = reader.readInt();
                switch (t) {
                    case 1 -> {
                        writer.write("Enter name");
                        String name = reader.readString();
                        writer.write("Enter username");
                        String username = reader.readString();
                        writer.write("Enter password");
                        String password = reader.readString();
                        User user = new User(name, username, password);
                        serviceUser.create(user);
                        continue;
                    }
                    case 2 -> {
                        writer.write("Enter username");
                        String username2 = reader.readString();
                        writer.write("Enter password");
                        String pass2 = reader.readString();
                        Optional<User> byUsername = serviceUser.findByUserName(username2);
                        if (byUsername.isPresent()) {
                            User user1 = byUsername.get();
                            if (user1.getPassword().equals(pass2)) {
                                consoleSession = new ConsoleSession(user1);
                                continue;
                            } else {
                                writer.write("Wrong password!");
                            }
                        } else {
                            writer.write("User not found!");
                            continue;
                        }
                    }
                    case 3 -> {
                        return;
                    }
                }
            } else {
                writer.write("Hello " + consoleSession.getCurrentUser().getName());
                writer.write("1 - Calculator, 2 - History, 3 - Logout, 4 - Exit");
                switch (reader.readInt()) {
                    case 1:
                        writer.write("Enter num 1");
                        double num1 = reader.readDouble();
                        writer.write("Enter num 2");
                        double num2 = reader.readDouble();
                        writer.write("Enter operation type");
                        String type = reader.readString();
                        Operation operation = new Operation(num1, num2, type, consoleSession.getCurrentUser());
                        Operation result = calculatorService.calculate(operation);
                        writer.write("Result = " + result.getRes());
                        continue;
                    case 2:
                        List<Operation> allByUser = calculatorService.findAllByUser(consoleSession.getCurrentUser());
                        for (Operation operation1 : allByUser) {
                            writer.write(operation1.toString());
                        }
                        continue;
                    case 3:
                        consoleSession = null;
                        continue;
                    case 4:
                        return;
                }
            }

        }
    }
}
