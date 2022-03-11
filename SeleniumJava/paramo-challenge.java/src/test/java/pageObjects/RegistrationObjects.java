package pageObjects;

import org.openqa.selenium.By;

public class RegistrationObjects {

    public static By getBtnRegistration() {
        return btnRegistration;
    }

    public static By btnRegistration = By.xpath(".//a[@class='button   header-button header-button--registration']");

    public static By getInputEmail() {
        return inputEmail;
    }

    public static By inputEmail = By.xpath(".//input[@data-test='input-email']");

    public static By getInputPassword() {
        return inputPassword;
    }

    public static By inputPassword = By.xpath(".//input[@data-test='input-password']");

    public static By getInputConfirmPass() {
        return inputConfirmPass;
    }

    public static By inputConfirmPass = By.xpath(".//input[@data-test='input-password_confirmation']");

    public static By getTermsConditions() {
        return termsConditions;
    }

    public static By termsConditions = By.xpath(".//label[@for='core__protected_modules_user_yiiForm_RegistrationForm_terms_and_conditions']");

    public static By getCodeCaptcha() {
        return codeCaptcha;
    }

    public static By codeCaptcha = By.xpath(".//input[@name='core__protected_modules_user_yiiForm_RegistrationForm[captcha]']");

    public static By getSubmitForm() {
        return submitForm;
    }

    public static By submitForm = By.xpath(".//button[@data-test='control-submit']");

    public static By getErrorEmail() {
        return errorEmail;
    }

    public static By errorEmail = By.xpath(".//div[@id='core__protected_modules_user_yiiForm_RegistrationForm_email_em_']");

    public static By getNotificationTitle() {
        return notificationTitle;
    }

    public static By notificationTitle = By.xpath(".//h1[@class='notification__title']");

    public static By getNotificationDescription() {
        return notificationDescription;
    }

    public static By notificationDescription = By.xpath(".//p[@class='notification__description']");

    public static By getViewProfile() {
        return viewProfile;
    }

    public static By viewProfile = By.xpath(".//a[@class='button button--s2 button--t1 ']");

    public static By getProfileName() {
        return profileName;
    }

    public static By profileName = By.xpath(".//div[@class='form-avatar__right']//div[@class='user-info__profile-name']");

    public static By getProfileID() {
        return profileID;
    }

    public static By profileID = By.xpath(".//div[@class='form-avatar__right']//div[@class='profile-info__id']//span");

    public static By getProfileButton() {
        return profileButton;
    }

    public static By profileButton = By.xpath(".//a[@class='profile-menu__item-link']//span[text()=' Profile settings ']");

    public static By getContactsButton() {
        return contactsButton;
    }

    public static By contactsButton = By.xpath("//li[text()='Contacts']");

    public static By getEmailCheck() {
        return emailCheck;
    }

    public static By emailCheck = By.xpath(".//input[@data-test='input-email']");

    public static By getCloseProfile() {
        return closeProfile;
    }

    public static By closeProfile = By.xpath(".//button[@title='Close (Esc)']");

    public static By getBuyCredits() {
        return buyCredits;
    }

    public static By buyCredits = By.xpath(".//a[@href='/cabinet/buycredits/choosePayMethod' and @class='header-user__transactions']");

    public static By getDepositButton() {
        return depositButton;
    }

    public static By depositButton = By.xpath(".//a[@id='withdraw-button-19']");

    public static By getEnterAmount() {
        return enterAmount;
    }

    public static By enterAmount = By.xpath(".//input[@data-test='input-amount']");

    public static By getFirstDeposit() {
        return firstDeposit;
    }

    public static By firstDeposit = By.xpath(".//label[@class='special-radio__label']//span[contains(text(),' First Deposit')]");

    public static By getSubmitDeposit() {
        return submitDeposit;
    }

    public static By submitDeposit = By.xpath(".//button[@id='btn-deposit']");

    public static By getMessageDeposit() {
        return messageDeposit;
    }

    public static By messageDeposit = By.xpath(".//div[@class='toast-message']");

    public static By getMessageDone() {
        return messageDone;
    }

    public static By messageDone = By.xpath(".//div[class='toast toast-success']");

    public static By getProfileUser() {
        return profileUser;
    }

    public static By profileUser = By.xpath(".//div[@class='user-info__profile-name']");

    public static By getGoToProfile() {
        return goToProfile;
    }

    public static By goToProfile = By.xpath(".//a[@data-test='nav-reg-head']");

    public static By getTransactionHistory() {
        return transactionHistory;
    }

    public static By transactionHistory = By.xpath(".//i[@class=' icon-transactions-history']");

    public static By getListMode() {
        return listMode;
    }

    public static By listMode = By.xpath(".//i[@class='icon-table']");

    public static By getTypeTransaction() {
        return typeTransaction;
    }

    public static By typeTransaction = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[2]");

    public static By getQAmountElement() {
        return QAmountElement;
    }

    public static By QAmountElement = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[3]");

    public static By getIDTransaction() {
        return IDTransaction;
    }

    public static By IDTransaction = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[1]");

    public static By getCurrency() {
        return currency;
    }

    public static By currency = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[4]");

    public static By getDateInfo() {
        return dateInfo;
    }

    public static By dateInfo = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[5]");

    public static By getStatusTransaction() {
        return statusTransaction;
    }

    public static By statusTransaction = By.xpath("(.//tbody[@data-items-container='deposit']//tr//td)[6]");
    //STRINGS
    static int number = (int) (Math.random() * 999999);
    public static String emailUser = "qaes." + number + "@hotmail.com";
    public static String passwordUser = "Qaes1234";
    public static String QAmount = "500";
}
