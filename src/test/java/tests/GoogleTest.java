package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    private static WebDriver driver;

    @BeforeAll
    public static  void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1 () {
        driver.get(" https://practice-automation.com/form-fields/");
        //driver.findElement(By.cssSelector("input#name-input")).sendKeys("Etttt", Keys.ENTER);

       // var inputField = driver.findElement(By.id("name-input"));

        // Проверяем, что поле найдено
        //assertEquals(true, inputField.isDisplayed());

        // Вводим текст "Vladimir"
       // inputField.sendKeys("Vladimir");
        System.out.println("ввод имени Vladimir прошел успешно");

        // Можно дополнительно проверить, что текст введен корректно
       // String enteredText = inputField.getAttribute("value");
       // assertEquals("Vladimir", enteredText);


        driver.findElement(By.id("name-input")).sendKeys("Evg");
        System.out.println("ввод имени Evg прошел успешно");
        //driver.findElement(By.cssSelector("#feedbackForm.input")).sendKeys("Effff", Keys.ENTER);
        //System.out.println("ввод пароля прошел учпешно");
        // Ищем поле ввода по ID

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/article/div/form/label[2]/input")).sendKeys("password123");;

        //driver.findElement(By.id("feedbackForm > label:nth-child(3) > input[type=password]")).sendKeys("Evg");
        System.out.println("ввод пароля прошел успешно");


        driver.findElement(By.id("drink2")).click();
        System.out.println("ввод в чекбокс милк прошел успешно");

        driver.findElement(By.id("drink3")).click();
        System.out.println("ввод в чекбокс кофе прошел успешно");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement radioButton = driver.findElement(By.cssSelector("input#color3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
        radioButton.click();

        //driver.findElement(By.cssSelector("input#color3")).click();
        System.out.println("ввод в радиокнопку желтый прошел успешно");


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement selectElement = driver.findElement(By.cssSelector("select#automation"));

        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ENTER);
        //Actions actions1 = actions.sendKeys(Keys.ARROW_DOWN);// Выполняем действия
        //Actions actions2 = actions.sendKeys(Keys.ARROW_DOWN);

        // Создаем объект Select
        //Select select = new Select(selectElement);



        // Выбираем значение "default" по его value
        //select.selectByValue("default");

        // Проверяем, что выбранное значение соответствует "default"
        //WebElement selectedOption = select.getFirstSelectedOption();
        //assertEquals("default", selectedOption.getAttribute("value"), "Значение по умолчанию не выбрано");

        driver.findElement(By.cssSelector("input#email")).sendKeys("fizmat73@gmail.com");

        // Найти все элементы <li>, которые являются прямыми дочерними элементами <ul> внутри #feedbackForm
        List<WebElement> liElements = driver.findElements(By.cssSelector("#feedbackForm > ul > li"));

        // Получить количество элементов
        int totalLiElements = liElements.size();

        // Вывести количество элементов
        System.out.println("Общее количество элементов: " + totalLiElements);



        // Найти все элементы <li> с локатором #feedbackForm > ul > li
        List<WebElement> liElements2 = driver.findElements(By.cssSelector("#feedbackForm > ul > li"));

        // Переменные для хранения самого длинного текста и его длины
        String longestText = "";
        int maxLength = 0;

        // Пройтись по каждому элементу <li>
        for (WebElement li : liElements2) {
            // Получить текст элемента
            String text = li.getText();

            // Сравнить длину текста с текущим максимальным значением
            if (text.length() > maxLength) {
                maxLength = text.length();
                longestText = text;
            }
        }

        // Вывести самый длинный текст
        System.out.println("Самый длинный текст: " + longestText);


        WebElement textArea = driver.findElement(By.id("message"));
        textArea.clear(); // Очистить поле
        textArea.sendKeys(String.valueOf(totalLiElements), "\n", longestText); // Ввести новый текст
        //textArea.sendKeys(longestText);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Найти кнопку по id
        WebElement submitButton = driver.findElement(By.id("submit-btn"));

        // Нажать на кнопку
        submitButton.click();


        System.out.println("кнопка нажата");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Получить текст из alert
        String alertText = alert.getText();

        System.out.println(alertText);

        // Проверить, что текст alert соответствует ожидаемому
        if (alertText.equals("Message received!")) {
            System.out.println("Тест пройден: текст alert корректный.");
        } else {
            System.out.println("Тест не пройден: текст alert не соответствует ожидаемому.");
        }

        // Закрыть alert
        alert.accept();





        }


    @AfterAll
    public  static void close () {
      //  driver.quit();
    }


}
