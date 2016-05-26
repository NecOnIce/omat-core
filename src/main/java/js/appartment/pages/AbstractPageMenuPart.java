package js.appartment.pages;

import js.appartment.RuntimeEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This abstract Class encapsulates the Menu of the most of the Pages.
 *
 * @author Jonas Scherbaum
 */
public abstract class AbstractPageMenuPart implements Page {

    public AbstractPageMenuPart() {

        WebDriver webDriver = RuntimeEnvironment.getInstace().getWebDriver();
        WebElement menuTableElement = webDriver.findElement(By.id("menuTable"));
        // List<WebElement>
    }

    public void goToOverviewPage() {

    }

    public void goToResourcesPage() {

    }

    public void goToStationPage() {

    }

    public void goToTraderOverviewPage() {

    }

    public void goToResearchPage() {

    }

    public void goToShipyardPage() {

    }

    public void goToDefensePage() {

    }

    public void goToFleetPage() {

    }

    public void goToGalaxyPage() {

    }

    public void goToAlliancePage() {

    }

    public void goToPremiumPage() {

    }

    public void goToShopPage() {

    }
}
