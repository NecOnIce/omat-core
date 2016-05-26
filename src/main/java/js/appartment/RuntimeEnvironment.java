package js.appartment;

import js.appartment.pages.LoginPage;
import js.appartment.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The RuntimeEnvironment encapsulates all Runtime specific Instances and variables as well as all State's necessary
 * to perform the WebInterface interactions to Ogame.com
 *
 * @author Jonas Scherbaum
 */
public class RuntimeEnvironment {

    private WebDriver webDriver;
    private static RuntimeEnvironment runtimeEnvironment;
    private static String baseURL = "https://de.ogame.gameforge.com/";

    /**
     * Creates an instance of the RuntimeEnvironment
     */
    private RuntimeEnvironment() {
        webDriver = new FirefoxDriver();

        // ensure that the Browser is closed together with the Application
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                webDriver.close();
            }
        });
    }

    /**
     * Get the currently active instance of the RuntimeEnvironment
     *
     * @return the currently active RuntimeEnvironment
     */
    public static RuntimeEnvironment getInstace() {
        if (runtimeEnvironment == null) {
            runtimeEnvironment = new RuntimeEnvironment();
        }
        return runtimeEnvironment;
    }

    /**
     * return the currently used WebDriver Instance to get access to the Firefox Browser.
     *
     * @return the currently used WebDriver Instance
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Opens the given Page
     *
     * @param page The Page to open.
     */
    public static void openPage(Page page) {
        getInstace().getWebDriver().get(baseURL+page.getPageURL());
    }

    /**
     * Returns if the Runtime is currently logged in.
     *
     * @return true if the Runtime was llogged in, otherwise false.
     */
    public static boolean isLoggedIn() {
        return LoginPage.isLoggedIn();
    }
}
