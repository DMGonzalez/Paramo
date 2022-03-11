package pageMethods;

import org.junit.Assert;
import pageObjects.GeneralObjects;
import pageObjects.RegistrationObjects;

import static org.junit.Assert.assertTrue;

public class RegistrationMethods {
    public static void userRegistration() {
        System.out.println("Go registration page");
        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getBtnRegistration(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getBtnRegistration());
        System.out.println("waiting for registration page...");

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getInputEmail(), 15);
        System.out.println("Enter credentials");
        GeneralMethods.elementSendText(RegistrationObjects.getInputEmail(), RegistrationObjects.emailUser);
        System.out.println("EMAIL CREATE IS => " + RegistrationObjects.emailUser);

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getInputPassword(), 15);
        GeneralMethods.elementSendText(RegistrationObjects.getInputPassword(), RegistrationObjects.passwordUser);

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getInputConfirmPass(), 15);
        GeneralMethods.elementSendText(RegistrationObjects.getInputConfirmPass(), RegistrationObjects.passwordUser);

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getTermsConditions(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getTermsConditions());

        try {
            GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getCodeCaptcha(), 5000);
            System.out.println("CAPTCHA CODE IS REQUIRED... PLEASE ENTER CODE OR DISABLE IT");
            Thread.sleep(15000);
        } catch (Exception e) {
            System.out.println("Submit form..");
        }

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getSubmitForm(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getSubmitForm());

        System.out.println("Checking user email");
        try {
            GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getErrorEmail(), 6);
            Assert.fail("ERROR!: EMAIL IS ALREADY REGISTERED");
        } catch (Exception e) {
            System.out.println("EMAIL OK");
        }
        System.out.println("Checking CAPTCHA");
        try {
            GeneralMethods.elementWaitDisplayedSet(GeneralObjects.getCaptchaRequired(), 6);
            System.out.println("CAPTCHA IS REQUIRED... PLEASE ENTER CAPTCHA OR DISABLE IT");
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("Checking user register...");
        }
    }

    public static void userCheck() {
        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getNotificationTitle(), 15);
        GeneralMethods.viewTextElementDisplayed(RegistrationObjects.getNotificationTitle());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getNotificationDescription(), 15);
        GeneralMethods.viewTextElementDisplayed(RegistrationObjects.getNotificationDescription());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getViewProfile(), 15);
        GeneralMethods.viewTextElementDisplayed(RegistrationObjects.getViewProfile());
        System.out.println("USER REGISTER SUCCESSFULLY");

        System.out.println("Go to profile menu");
        GeneralMethods.elementClick(RegistrationObjects.getViewProfile());
        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getProfileName(), 30);

        String profileName = GeneralMethods.driver.findElement(RegistrationObjects.getProfileName())
                .getText();
        System.out.println("PROFILE NAME IS => " + profileName);
        String profileID = GeneralMethods.driver.findElement(RegistrationObjects.getProfileID())
                .getText();
        System.out.println("PROFILE ID IS => " + profileID);

        System.out.println("Checking user email");
        GeneralMethods.elementClick(RegistrationObjects.getProfileButton());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getContactsButton(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getContactsButton());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getEmailCheck(), 15);
        String emailInput = GeneralMethods.driver.findElement(RegistrationObjects.getEmailCheck())
                .getAttribute("value");
        assertTrue(emailInput.contains(RegistrationObjects.emailUser));
        System.out.println("EMAIL DISPLAYED => " + emailInput + " IS EQUAL TO EMAIL REGISTERED => " + RegistrationObjects.emailUser);
    }

    public static void depositAndCheck() {
        System.out.println("Go to deposit");
        GeneralMethods.elementClickSet(RegistrationObjects.getCloseProfile(), 14);
        GeneralMethods.elementClickSet(RegistrationObjects.getBuyCredits(), 15);
        GeneralMethods.elementClickSet(RegistrationObjects.getDepositButton(), 15);

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getEnterAmount(), 15);
        GeneralMethods.elementSendText(RegistrationObjects.getEnterAmount(), RegistrationObjects.QAmount);
        GeneralMethods.elementClick(RegistrationObjects.getFirstDeposit());
        GeneralMethods.elementClick(RegistrationObjects.getSubmitDeposit());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getMessageDeposit(), 15);
        GeneralMethods.viewTextElementDisplayed(RegistrationObjects.getMessageDeposit());
        GeneralMethods.elementWaitInvisibility(RegistrationObjects.getMessageDeposit());
        GeneralMethods.elementWaitInvisibility(RegistrationObjects.getMessageDone());

        System.out.println("Checking it");
        GeneralMethods.elementClick(RegistrationObjects.getProfileUser());
        GeneralMethods.elementClick(RegistrationObjects.getGoToProfile());
        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getTransactionHistory(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getTransactionHistory());

        GeneralMethods.elementWaitDisplayedSet(RegistrationObjects.getListMode(), 15);
        GeneralMethods.elementClick(RegistrationObjects.getListMode());

        GeneralMethods.elementWaitPresence(RegistrationObjects.getTypeTransaction());

        String typeTransaction = GeneralMethods.driver.findElement(RegistrationObjects.getTypeTransaction())
                .getText();
        assertTrue(typeTransaction.contains("Deposit"));
        String amount = GeneralMethods.driver.findElement(RegistrationObjects.getQAmountElement())
                .getText();
        assertTrue(amount.contains(RegistrationObjects.QAmount));
        String idTransaction = GeneralMethods.driver.findElement(RegistrationObjects.getIDTransaction())
                .getText();
        String currency = GeneralMethods.driver.findElement(RegistrationObjects.getCurrency())
                .getText();
        String date = GeneralMethods.driver.findElement(RegistrationObjects.getDateInfo())
                .getText();
        String statusTransaction = GeneralMethods.driver.findElement(RegistrationObjects.getStatusTransaction())
                .getText();
        System.out.println("ID transaction: " + idTransaction);
        System.out.println("Type: " + typeTransaction);
        System.out.println("Enter Amount: " + amount);
        System.out.println("Currency: " + currency);
        System.out.println("Date: " + date);
        System.out.println("Status Transaction: " + statusTransaction);
    }
}
