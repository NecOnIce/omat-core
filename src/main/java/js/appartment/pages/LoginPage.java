package js.appartment.pages;

import js.appartment.RuntimeEnvironment;
import js.appartment.exceptions.UniverseNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This Class handles the Login Page of Ogame.com
 *
 * @author Jonas Scherbaum
 */
public class LoginPage implements Page {

    private static final String LOGIN_PAGE_URL = "";
    private Map<String, WebElement> universeWebElementMapping;
    private WebElement universeSelectElement;
    private WebElement usernameLoginElement;
    private WebElement passwordLoginElement;
    private WebElement loginButtonElement;
    private WebElement loginFieldButton;

    private static boolean isLoggedIn;

    /**
     * Creates all necessary WebElements of the LoginPage
     */
    public LoginPage() {

        RuntimeEnvironment.openPage(this);
        WebDriver webDriver = RuntimeEnvironment.getInstace().getWebDriver();
        loginFieldButton = webDriver.findElement(By.id("loginBtn"));
        universeSelectElement = webDriver.findElement(By.id("serverLogin"));
        List<WebElement> universeOptionElements = universeSelectElement.findElements(By.tagName("option"));

        universeWebElementMapping = new HashMap<>();
        loginFieldButton.click();
        universeOptionElements.forEach((WebElement option) -> {
            String universe = option.getText();
            universeWebElementMapping.put(universe, option);
        });
        loginFieldButton.click();

        usernameLoginElement = webDriver.findElement(By.id("usernameLogin"));
        passwordLoginElement = webDriver.findElement(By.id("passwordLogin"));
        loginButtonElement = webDriver.findElement(By.id("loginSubmit"));
    }

    @Override
    public String getPageURL() {
        return LOGIN_PAGE_URL;
    }

    /**
     * Logs in into the given Universe with the given Credentials
     *
     * @param username The Username
     * @param password The Password
     * @param universe The Universe to login
     * @throws UniverseNotFoundException if the given universe was not found.
     */
    public void login(String username, String password, String universe) throws UniverseNotFoundException {

        loginFieldButton.click();
        universeSelectElement.click();
        WebElement option = universeWebElementMapping.get(universe);

        if (option == null) {
            throw new UniverseNotFoundException("The Universe: " + universe + " could not be found.");
        }
        option.click();

        usernameLoginElement.sendKeys(username);
        passwordLoginElement.sendKeys(password);
        loginButtonElement.click();

        isLoggedIn = true;
    }

    /**
     * Checks whether we are logged in.
     *
     * @return True if we are logged in
     */
    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * extracts all available Universe's  from the Login Page.
     *
     * @return The List of all available Universes
     */
    public Set<String> getUniverseNames() {
        return this.universeWebElementMapping.keySet();
    }
}
