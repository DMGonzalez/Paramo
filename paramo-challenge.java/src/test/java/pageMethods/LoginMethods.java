package pageMethods;

import pageObjects.GeneralObjects;
import pageObjects.LoginObjects;

public class LoginMethods {
    public static void userLogin() throws InterruptedException {
        System.out.println("Starting test...");
        System.out.println("Go login page");
        GeneralMethods.elementWaitDisplayedSet(LoginObjects.getBtnLogin(), 15);
        GeneralMethods.elementClick(LoginObjects.getBtnLogin());

        GeneralMethods.elementWaitDisplayedSet(LoginObjects.getBtnMenuLogin(), 15);
        GeneralMethods.elementClick(LoginObjects.getBtnMenuLogin());

        System.out.println("Enter credentials");
        GeneralMethods.elementWaitDisplayedSet(LoginObjects.getInputEmail(), 15);
        GeneralMethods.elementSendText(LoginObjects.getInputEmail(), LoginObjects.emailUser);

        GeneralMethods.elementSendText(LoginObjects.getInputPass(), LoginObjects.passUser);
        GeneralMethods.elementClick(LoginObjects.getSubmitLogin());
        System.out.println("Checking CAPTCHA");
        try {
            GeneralMethods.elementWaitDisplayedSet(GeneralObjects.getCaptchaRequired(), 6);
            System.out.println("CAPTCHA IS REQUIRED... PLEASE ENTER CAPTCHA OR DISABLE IT");
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("CHECKING LOGIN...");
        }
    }

    public static void checkLogin() {
        GeneralMethods.elementWaitDisplayedSet(LoginObjects.getIdUserElement(), 20);
        System.out.println("Getting ID");
        String idUserDisplayed = GeneralMethods.driver.findElement(LoginObjects.getIdUserElement())
                .getText();
        GeneralMethods.checkElementText(LoginObjects.getIdUserElement(), LoginObjects.idUser);
        System.out.println("Getting profile name");
        String profileNameDisplayed = GeneralMethods.driver.findElement(LoginObjects.getProfileNameElement())
                .getText();
        GeneralMethods.checkElementText(LoginObjects.getProfileNameElement(), LoginObjects.profileName);
        System.out.println("Checking data");
        System.out.println("USER " + idUserDisplayed);
        System.out.println("PROFILE NAME => " + profileNameDisplayed);
        System.out.println("LOGIN SUCCESSFULLY");
    }
}
