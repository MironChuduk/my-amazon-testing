package common;

public class Config {

    public static final String PLATFORM_AND_BROWSER = "mac_chrome";
    /**
     * Clear browser cookies after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * To keep the browser open after suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /**
     * To open the Chrome browser with "--incognito" option
     * if true - browser opens in incognito mode
     */
    public static final Boolean INCOGNITO_MODE = false;

}
