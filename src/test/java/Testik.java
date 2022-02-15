import by.epam.finalproject.model.exception.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testik {
    public static void main(String[] args) throws DaoException {
        Scanner scanner = new Scanner(System.in);
        List<String> sraki = new ArrayList<>();
        Integer numberOfSrakas = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfSrakas; i++) {
            sraki.add(scanner.nextLine());
        }
        sraki.forEach(x -> System.out.println("Hello, " + x));
    }
}