package sel.course.project.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Olga on 12/20/2016.
 */
public class MainPage {
    private WebDriver wd;
    private WebDriverWait wait;

    @FindBy(css = "div#cart a.content span.quantity")
    private WebElement cartItemsMainPage;


    public MainPage(WebDriver w, WebDriverWait wt){
        wd = w;
        wait = wt;
        PageFactory.initElements(wd, this);
    }

    public int getPreviousCartNumber(){
        String cartItem = cartItemsMainPage.getText();
        int previousNumber = Integer.parseInt(String.valueOf(cartItem));
        System.out.println("Shopping cart contains "+previousNumber+" items");
        return previousNumber;
    }

    public void selectItem(String itemTitle) {
        wd.findElement(By.cssSelector("div#box-most-popular a.link[title='" + itemTitle + "']")).click();
        wait.until(titleIs(itemTitle + " | Rubber Ducks | My Store"));
    }
}
