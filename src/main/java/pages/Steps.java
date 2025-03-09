package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Steps {

    @FindBy(css = "input#name-input")
    public WebElement searchInputName;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/main/div/article/div/form/label[2]/input")
    public WebElement searchInputPassword;

    @FindBy(css = "#drink2")
    public WebElement searchСheckboxMilk;


    @FindBy(css = "#drink3")
    public WebElement searchСHeckboxCoffee;


    @FindBy(css = "input#color3")
    public WebElement searchRadioYellow;

    @FindBy(css = "select#automation")
    public WebElement searchSelectAutomation;

    @FindBy(css = "input#email")
    public WebElement searchEmail;

    @FindBy(css = "#feedbackForm > ul > li")
    public List<WebElement> searchTools;

    @FindBy(css = "#submit-btn")
    public WebElement searchSubmitButton;

    public Steps(WebDriver driver) {
        initElements(driver, this);
    }

    //public void sendKeys(String evg) {
    //}
}
