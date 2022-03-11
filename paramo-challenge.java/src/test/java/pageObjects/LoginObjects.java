package pageObjects;

import org.openqa.selenium.By;

public class LoginObjects {

    public static By getBtnLogin() {
        return btnLogin;
    }

    public static By btnLogin = By.xpath(".//div[@class='button   header-button header-button--login']");

    public static By getBtnMenuLogin() {
        return btnMenuLogin;
    }

    public static By btnMenuLogin = By.xpath(".//a[@class='button   header-button header-button--login']");

    public static By getInputEmail() {
        return inputEmail;
    }

    public static By inputEmail = By.xpath(".//input[@data-test='input-username']");

    public static By getInputPass() {
        return inputPass;
    }

    public static By inputPass = By.xpath(".//input[@data-test='input-password']");

    public static By getSubmitLogin() {
        return submitLogin;
    }

    public static By submitLogin = By.xpath(".//button[@class='button  button--t1 ']");

    public static By getProfileNameElement() {
        return profileNameElement;
    }

    public static By profileNameElement = By.xpath(".//div[@class='user-info__profile-name']");

    public static By getIdUserElement() {
        return idUserElement;
    }

    public static By idUserElement = By.xpath(".//span[@class='user-avatar__title']");

    //STRING
    public static String emailUser = "QAES.99999@hotmail.com";
    public static String passUser = "Qaes1234";
    public static String profileName = "strong_eagle_25097942";
    public static String idUser = "ID 83970722";
}
