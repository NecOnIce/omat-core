package js.appartment.pages;

/**
 * This Interface represents the Pages of the WebInterface.
 *
 * @author Jonas Scherbaum
 */
public interface Page {

    /**
     * Returns the Page URL Part.
     * Note: the Page URL Part must have a leading '/'-Seperator
     *
     * @return The Page URL Part.
     */
    String getPageURL();
}
