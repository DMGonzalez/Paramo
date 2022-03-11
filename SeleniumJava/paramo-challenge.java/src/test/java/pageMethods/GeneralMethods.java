package pageMethods;

import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.GeneralObjects;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneralMethods {
    public static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.casino");
        try {
            GeneralMethods.elementWaitDisplayedSet(GeneralObjects.getCloseWelcome(), 15);
            GeneralMethods.elementClick(GeneralObjects.getCloseWelcome());
        } catch (Exception e) {
            GeneralMethods.elementWaitDisplayedSet(GeneralObjects.getBtnSingIn(), 6);
        }
        System.out.println("URL OPEN SUCCESSFULLY");
    }

    public static void obtengoElementos() throws InterruptedException {
        Thread.sleep(500);
        String elementos = driver.getPageSource();
        System.out.println(elementos);
    }

    public static void elementClick(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).click();
    }

    public static void elementClickSet(By element, int timeWait) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, timeWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).click();
    }

    public static void checkTitleResults(By listElement, String textContains) {
        GeneralMethods.elementWaitDisplayedSet(listElement, 30);
        List<WebElement> listResult2 = GeneralMethods.driver.findElements(listElement);
        for (WebElement listResults : listResult2) {
            assertTrue((listResult2.size()) >= 1);
            String resultado = listResults.getText();
            String resultado1 = resultado.toUpperCase();
            if (resultado.contains(textContains)) {
                System.out.println("EL TITULO DEL RESULTADO =>" + resultado + " CONTIENE EL TEXTO => " + textContains);
            } else if (resultado1.contains(textContains)) {
                System.out.println("EL TITULO DEL RESULTADO =>" + resultado1 + " CONTIENE EL TEXTO => " + textContains);
            } else {
                Assert.fail("ERROR!: EL TITULO DEL RESULTADO =>" + resultado + " NO CONTIENE EL TEXTO => " + textContains);
            }
        }
    }

    public static void elementDoubleClick(By element) {
        Actions a = new Actions(driver);
        WebElement ele = driver.findElement(element);
        a.doubleClick(ele);
    }

    public static void elementWaitDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }

    public static void elementWaitPresence(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void elementWaitPresenceSet(By element, int secondsWait) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, secondsWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void elementWaitInvisibility(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static void elementSendText(By element, String text) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).click();
        GeneralMethods.driver.findElement(element).sendKeys(text);
    }

    public static boolean checkListElementText(By element, String text) {
        List<WebElement> elements = driver.findElements(element);
        return elements.stream().anyMatch(e -> e.getText().trim().equals(text));
    }

    public static void scrollToElement(By element, int tiempoEnSegundos, int timeFindElement) {
        Awaitility.await().atMost(tiempoEnSegundos, SECONDS).until(() -> {
            try {
                WebDriverWait wait = new WebDriverWait(driver, timeFindElement);
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                return true;
            } catch (Throwable throwable) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,1000)");
                System.out.println("Looking for element...");
                return false;
            }
        });
    }

    public static void waitToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void closeDriver() throws InterruptedException {
        System.out.println("Close driver...");
        driver.quit();
    }

    public static void elementClear(By element) {
        WebDriverWait wait = new WebDriverWait(GeneralMethods.driver, 10);
        new Actions(driver).moveToElement(GeneralMethods.driver.findElement(element)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        GeneralMethods.driver.findElement(element).clear();
    }

    public static void checkElementText(By element, String text) {
        Awaitility.await().atMost(10, SECONDS).until(() -> {
            try {
                assertEquals(text, GeneralMethods.driver.findElement(element).getText());
                System.out.println("Element text " + GeneralMethods.driver.findElement(element).getText() + " equals " + text);

                return true;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return false;
            }
        });
    }

    public static void viewTextElementDisplayed(By element) {
        String txtElement = driver.findElement(element)
                .getText();
        System.out.println("ELEMENT '" + txtElement + "' IS DISPLAYED");
    }

    public static void viewTextElement(By element) {
        String txtElement = driver.findElement(element)
                .getText();
        System.out.println("ELEMENT " + txtElement);
    }

    public static void elementWaitDisplayedSet(By element, int secondsWait) {
        WebDriverWait wait = new WebDriverWait(driver, secondsWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
