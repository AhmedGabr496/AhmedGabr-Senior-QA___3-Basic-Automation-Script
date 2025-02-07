package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement profileTab;
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> mainMenus;
    @FindBy(partialLinkText = "Logout")
    WebElement logoutButton;

    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement>menus;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void doLogout() throws InterruptedException {
        profileTab.click();
        logoutButton.click();
        Thread.sleep(1000);
    }
}
