package js.appartment;

import js.appartment.exceptions.UniverseNotFoundException;
import js.appartment.pages.LoginPage;

import java.util.Scanner;
import java.util.Set;

/**
 * @author Jonas Scherbaum
 */
public class Launcher {

    public static void main(String[] args) throws UniverseNotFoundException {

        RuntimeEnvironment.getInstace();

        LoginPage login = new LoginPage();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type in your username: ");
        String username = scanner.nextLine();
        System.out.print("Please type in your password: ");
        String password = scanner.nextLine();

        System.out.println("The following universes are possible to select:");
        Set<String> universeNames = login.getUniverseNames();

        universeNames.forEach((String universe) -> {
            System.out.println(universe);
        });
        System.out.println();
        System.out.print("Please choose Universe: ");
        String universe = scanner.nextLine();

        login.login(username, password, universe);

        RuntimeEnvironment.getInstace().getWebDriver().close();
    }
}
