package pageObjects;

import org.openqa.selenium.By;

public class GeneralObjects {

    public static By getCloseWelcome() {
        return closeWelcome;
    }

    public static By closeWelcome = By.xpath(".//button[@title='Close (Esc)']");

    public static By getBtnSingIn() {
        return btnSingIn;
    }

    public static By btnSingIn = By.xpath(".//div[@class='button   header-button header-button--login']");

    public static By getCaptchaRequired() {
        return captchaRequired;
    }

    public static By captchaRequired = By.xpath(".//iframe[contains(@title,'recaptcha')]");
}
