import js.appartment.RuntimeEnvironment;
import js.appartment.pages.LoginPage;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jonas Scherbaum
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainMenuTest.class
})
public class WebInterfaceTestSuit {

    @Before
    public void setUp() throws Exception {

        RuntimeEnvironment.getInstace();
        if (!RuntimeEnvironment.isLoggedIn()) {
            LoginPage login = new LoginPage();
            login.login("NecOnIce", "*34anyplecho", "Japetus");
        }
    }
}
