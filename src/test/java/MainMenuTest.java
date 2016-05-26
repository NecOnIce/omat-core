import js.appartment.RuntimeEnvironment;
import js.appartment.pages.AbstractPageMenuPart;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author Jonas Scherbaum
 */
public class MainMenuTest {

    private class TestPage extends AbstractPageMenuPart {

        @Override
        public String getPageURL() {
            return null;
        }
    }

    @Test
    public void testGoToOverview() {

        try {
            TestPage testPage = new TestPage();
            testPage.goToOverviewPage();
        } catch (Exception e) {
            fail("Should go to Overview Page, instead an exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGoToResourcesPage() {

        try {
            TestPage testPage = new TestPage();
            testPage.goToResourcesPage();
        } catch (Exception e) {
            fail("Should go to ResourcesPage, instead an exception was thrown: " + e.getMessage());
        }
    }


}
