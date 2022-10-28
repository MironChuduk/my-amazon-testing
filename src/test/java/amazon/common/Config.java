package amazon.common;

public class Config {

    public static final String CHROME_PATH = "src/test/resources/chromedriver";
    /**
     * Clear browser cookies after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = false;

    /**
     * To keep the browser open after suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;
    /**
     * To run tests without browser window
     * if true - run without window
     */
    public static final Boolean RUN_TEST_WITH_BROWSER_WINDOW = false;
}
