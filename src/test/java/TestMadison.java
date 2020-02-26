import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestMadison {
    @Test
    public void homePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.dev.evozon.com/");
        String title =driver.getTitle();
        System.out.println(title);
        String URL= driver.getCurrentUrl();
        System.out.println(URL);
        WebElement logo = driver.findElement(By.cssSelector("#header > div > a"));
        logo.click();
        WebElement man = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        man.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();



    }
    @Test
    public void account(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.dev.evozon.com/");
        WebElement account= driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();
        WebElement myaccount= driver.findElement(By.cssSelector("#header-account > div > ul > li.first > a"));
        myaccount.click();
        driver.quit();
    }
    @Test
    public void language(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.dev.evozon.com/");
        WebElement language=driver.findElement(By.cssSelector("#select-language"));
        language.click();
        WebElement french=driver.findElement(By.cssSelector("#select-language > option:nth-child(2)"));
        french.click();
        driver.quit();
    }
    @Test
    public void search(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.dev.evozon.com/");
        WebElement search=driver.findElement(By.cssSelector("#search"));
        search.clear();
        search.sendKeys("women");
        WebElement seachbutton=driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        seachbutton.click();
        driver.quit();
    }
    @Test
    public void newProductList(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa2.dev.evozon.com/");
        List<WebElement> newElems = driver.findElements(By.cssSelector(".item.last"));
        for(WebElement e: newElems){
        System.out.println(e.getText());
        }
        driver.quit();
        }
        @Test
        public void navigation(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://qa2.dev.evozon.com/");
            List<WebElement> newElems = driver.findElements(By.cssSelector(".level0.parent"));
            for(WebElement e: newElems){
                if(e.getText().equals("SALE")){
                    e.click();
                    break;
                }
            }



        }
}


