package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Steps;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    private static WebDriver driver;
    private static Steps steps;

    @BeforeAll
    public static  void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        steps = new Steps(driver);
    }

    @AfterEach
    public void afterTest () throws InterruptedException {
        //задержка в 1 секунду, чтобы было видно все измененения на сайте
        Thread.sleep(1000);
    }

    @DisplayName("Заполнение поля Name")
    @org.junit.jupiter.api.Test
    public void test1 () {
        driver.get(" https://practice-automation.com/form-fields/");
        steps.searchInputName.sendKeys("Evgeniy");
        System.out.println("ввод имени Evgeniy прошел успешно");
        // Можно дополнительно проверить, что текст введен корректно
        // String enteredText = inputField.getAttribute("value");
        // assertEquals("Evgeniy", enteredText);
    }

    @DisplayName("Заполнение поля Password")
    @org.junit.jupiter.api.Test
    public void test2 () {
        steps.searchInputPassword.sendKeys("password123");
        //driver.findElement(By.id("feedbackForm > label:nth-child(3) > input[type=password]")).sendKeys("Evg");
        System.out.println("ввод пароля прошел успешно");
    }

    @DisplayName("Выбор чекбоксов Milk и Coffee")
    @org.junit.jupiter.api.Test
    public void test3 () {
        steps.searchСheckboxMilk.click();
        System.out.println("ввод в чекбокс Милк прошел успешно");
        steps.searchСHeckboxCoffee.click();
        System.out.println("ввод в чекбокс Кофе прошел успешно");
    }

    @DisplayName("Выбор радиокнопки Yellow")
    @org.junit.jupiter.api.Test
    public void test4 () {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement radioButton = steps.searchRadioYellow;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
        radioButton.click();
        System.out.println("ввод в радиокнопку Желтый прошел успешно");
    }


    @DisplayName("Выбор из выпадающего списка Do you like automation")
    @org.junit.jupiter.api.Test
    public void test5 () {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement selectElement = steps.searchSelectAutomation;
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("select#automation")).sendKeys(Keys.ENTER);
        // наверное, еще можно было иначе - выбрать значение по его value
        //Select select = new Select(selectElement);
        //select.selectByValue("default");
        // Проверяем, что выбранное значение соответствует "default"
        //WebElement selectedOption = select.getFirstSelectedOption();
        //assertEquals("default", selectedOption.getAttribute("value"), "Значение по умолчанию не выбрано");
    }


    @DisplayName("заполнение поля Email")
    @org.junit.jupiter.api.Test
    public void test6 () {
        steps.searchEmail.sendKeys("fizmat73@gmail.com");
    }


    @DisplayName("запись в поле Message количества инструиментов и нахождение инструмента, содержащего наибольшее количество символов")
    @org.junit.jupiter.api.Test
    public void test7 () {
        // Найти все элементы <li>, которые являются прямыми дочерними элементами <ul> внутри #feedbackForm
        // List<WebElement> liElements = driver.findElements(By.cssSelector("#feedbackForm > ul > li"));
        int totalLiElements = steps.searchTools.size();
        System.out.println("Общее количество элементов: " + totalLiElements);
        List<WebElement> liElements = steps.searchTools;
        String longestText = "";
        int maxLength = 0;
        // Пробегаем по каждому элементу <li>
        for (WebElement li : liElements) {
            // Получиаем текст элемента
            String text = li.getText();
            // Сравниваем длину текста с текущим максимальным значением
            if (text.length() > maxLength) {
                maxLength = text.length();
                longestText = text;
            }
        }
        System.out.println("Самый длинный текст: " + longestText);
        WebElement textArea = driver.findElement(By.id("message"));
        textArea.clear(); // Очищаем поле
        textArea.sendKeys(String.valueOf(totalLiElements), "\n", longestText); // Вводим текст: кол-во элементов li и значение самого длинного элемента

        }


        @DisplayName("нажатие кнопки Submit")
        @org.junit.jupiter.api.Test
        public void test8 () {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
           // WebElement submitButton = steps.searchSubmitButton;
            steps.searchSubmitButton.click();
            System.out.println("кнопка нажата");
        }


        @DisplayName("проверка ожидаемого результата Alert с текстом Message received!")
        @org.junit.jupiter.api.Test
        public void test9 () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println(alertText);

        // Проверить, что текст alert соответствует ожидаемому через assert
        assertEquals("Message received!", alertText);
        System.out.println("asserEquals Message received! и alertText");

        // то же самое, но через if с выводом в print
        if (alertText.equals("Message received!")) {
            System.out.println("Тест пройден: текст alert корректный.");
        } else {
            System.out.println("Тест не пройден: текст alert не соответствует ожидаемому.");
        }

        // Закрыdftv alert
        alert.accept();
        }


    @AfterAll
    public  static void close () {
      driver.quit();
    }


}
