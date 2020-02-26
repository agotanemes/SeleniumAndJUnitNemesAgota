import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMadisonJUnit {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Is before class");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("Is after class");
    }
    //before test
    @Before
    public  void beforeTest(){
        System.out.println("Is before test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agotanemes\\IdeaProjects\\TestingIntro\\drivers\\chromedriver.exe");
        driver=  new ChromeDriver();
        driver.get("http://qa2.dev.evozon.com/");
    }
    //HomePage tests
    //title
    @Test
    public void correctTitle(){
        String title =driver.getTitle();
        assertEquals("Madison Island",title);

    }
    //correct url
    @Test
    public void correctUrl(){
        String url= driver.getCurrentUrl();
        assertEquals("http://qa2.dev.evozon.com/",url);
    }
    //Logo is displayed
    @Test
    public void displayedLogo(){
        //old value
        //WebElement logo = driver.findElement(By.cssSelector("#header > div > a"));
        //new value
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        boolean logodisplayed=logo.isDisplayed();
        assertEquals(logodisplayed,true);
    }
    //click logo
    @Test
    public void clickLogo(){
        //old value
        //WebElement logo = driver.findElement(By.cssSelector("#header > div > a"));
        //new value
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        logo.click();
    }
    //is Homepage
    @Test
    public void isHomePage(){
        //old value
        //WebElement home= driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.std > div.widget.widget-new-products > div.widget-title > h2"));
        //new value
        WebElement newProducts= driver.findElement(By.cssSelector(".widget-title"));
        boolean isHomePage=newProducts.isDisplayed();
        assertEquals(isHomePage,true);
    }
    //navigate to different page+back+forward+refresh
    @Test
    public void oppperationOnPage(){
        //old value
        //WebElement man = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        //new value
        WebElement man = driver.findElement(By.cssSelector(".nav-2"));
        man.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    //Account tests
    //dropdown appears
    @Test
    public void isDisplayedAccountDropdown(){
        //old value
       // WebElement account= driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        //new value
        WebElement account= driver.findElement(By.cssSelector(".skip-account"));
        //or .account-cart-wrapper>a
        account.click();
        //old value
        //WebElement accountdropdown=driver.findElement(By.cssSelector("#header-account > div > ul > li.first"));
        //new value
        WebElement accountDropdown=driver.findElement(By.cssSelector(".skip-content.skip-active"));
        boolean isdisplayed=accountDropdown.isDisplayed();
        assertEquals(isdisplayed,true);
    }
    //Make sure the account option has the correct text “account”
    @Test
    public void isDisplayedAccountText(){
        //old value
        //WebElement account= driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        //new value
        WebElement account= driver.findElement(By.cssSelector(".skip-account"));
        String accountText=account.getText();
        assertEquals(accountText,"ACCOUNT");
    }
    //Make sure the account option has the correct text “ my account”
    @Test
    public void isDisplayedMyAccountOnAccountList(){
        //old value
        //WebElement account= driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        WebElement account= driver.findElement(By.cssSelector(".skip-account"));
        account.click();
        //old value
       //List<WebElement> accountList= driver.findElements(By.cssSelector("#header-account li"));
       //new value
        List<WebElement> accountList= driver.findElements(By.cssSelector("#header-account li"));
       boolean ok=false;
      for(WebElement accountElem:accountList){
          if(accountElem.getText().equals("My Account")){
              ok=true;
          }
      }
      assertEquals(ok,true);

    }
    //Language Tests
    @Test
    public void languageList(){
        List<WebElement> languageList= driver.findElements(By.cssSelector("#select-language"));
        for(WebElement language:languageList){
            System.out.println(language.getText());
        }
    }
    @Test
    public void countLanguages(){
        Select languageOption = new Select(driver.findElement(By.cssSelector("#select-language")));
        List<WebElement> languageList = languageOption.getOptions();

        assertEquals(languageList.size(),3);
    }
    @Test
    //de intrebat?????????
    public void changeLanguageOpToNextOp(){
        //languages
       List<WebElement> languageList=driver.findElements(By.cssSelector("#select-language>option"));
       //selected elem
        WebElement selectedLanguage=driver.findElement(By.cssSelector("option[selected='selected']"));
        for (int i=0;i<languageList.size();i++){
            if(languageList.get(i).getText().equals(selectedLanguage.getText())){
                int poz=i+1;
                languageList.get(poz).click();
                break;
            }

        }



            }
    @Test
    public void search(){
        WebDriverWait wait =new WebDriverWait(driver,10);
        WebElement search=driver.findElement(By.cssSelector("#search"));
        search.clear();
        search.sendKeys("women");
        //old value
        //WebElement seachbutton=driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        //new value
        WebElement seachbutton=driver.findElement(By.cssSelector(".search-button"));
        seachbutton.click();
        //old value
        //WebElement text=driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1"));
        //new value
        WebElement text=driver.findElement(By.cssSelector(".page-title>h1"));
        //wait.until(ExpectedConditions.textToBePresentInElement(text,"Search results for 'women'"));
        wait.until(ExpectedConditions.visibilityOf(text));
        assertEquals(text.getText(),"SEARCH RESULTS FOR 'WOMEN'");
        assertTrue(text.getText().toLowerCase().contains("women"));
    }
    @Test
    public void newProducts(){
        List<WebElement> newElems = driver.findElements(By.cssSelector(".item.last"));
        System.out.println("Number of new products:"+ newElems.size());
        assertEquals(newElems.size(),5);
        for(WebElement e: newElems){
            System.out.println(e.getText());
        }
    }
    @Test
    public void navigation(){
        List<WebElement> newElems = driver.findElements(By.cssSelector(".level0.parent"));
        for(WebElement e: newElems){
            if(e.getText().equals("SALE")){
                e.click();
                break;
            }
        }
        String url= driver.getCurrentUrl();
        assertTrue(url.contains("/sale.html"));
    }
    @Test
    public void checkout(){
        //old value
        //WebElement category= driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a"));
        //new value
        //Go to a product Category
        //1)choose women cathegory
        List<WebElement> allCathegories = driver.findElements(By.cssSelector(".nav-primary>li"));
        for(WebElement category:allCathegories){
            if(category.getText().equals("WOMEN")){
                category.click();
                break;
            }
        }
        //old value
        //WebElement subcategory=driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(1) > a > img"));
        //subcategory.click();
        //new value
        //2)click on New Arrivals subcathegory
        List<WebElement> allSubcathegories=driver.findElements(By.cssSelector(".catblocks>li"));
        for(WebElement subcategory:allSubcathegories){
            if(subcategory.getText().equals("NEW ARRIVALS")){
                subcategory.click();
                break;
            }
        }
        /*old steps-----------------------------------------------------------------------
        //add a product to chart
        WebElement addToChart=driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(4) > div > div.actions > button"));

        addToChart.click();
        //search
        search();
        //add to chart
        WebElement addToChartButton=driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > button"));
        //click button
        addToChartButton.click();

         old steps end-------------------------------------------------------------------*/
        /*all products with Add to Chart button
        //List<WebElement> products=driver.findElements(By.cssSelector(".item.last .button[title='Add to Cart]"));
        //products.get(0).click();*/
        //3) select the button text for the first product
        WebElement firstProduc=driver.findElement(By.cssSelector(".item.last:first-child a.button"));
        String text=firstProduc.getAttribute("title");
        firstProduc.click();
        if(text.equals("View Details")){
            List<WebElement> colorList=driver.findElements(By.cssSelector("#configurable_swatch_color>li"));
            colorList.get(0).click();
            List<WebElement> sizeList=driver.findElements(By.cssSelector("#configurable_swatch_size>li"));
            boolean notAvailable=false;
            int i=0;
            while(notAvailable==false && i<sizeList.size()){
                if(sizeList.get(i).getAttribute("class").contains("not-available")){
                    i++;
                }
                else
                    notAvailable=true;

            }
            //click on first available size
            sizeList.get(i).click();
            WebElement addToCartBtn=driver.findElement(By.cssSelector(".add-to-cart-buttons>button"));
            addToCartBtn.click();

        }

       // }





    }


    //after test
    @After
    public void after() {
        System.out.println("Is after test");
        driver.quit();
    }
}
