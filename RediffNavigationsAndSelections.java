package jenkinstestpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffNavigationsAndSelections {

    public static void main(String[] args) throws InterruptedException {
        //Set the geckodriver path
        System.setProperty("webdriver.chrome.driver","C:\\BrowserExeFiles\\chromedriver.exe");
               
        //launch the Chrome browser
        //Interfacename refvar=new implementingclass();
        WebDriver driver=new ChromeDriver();

        //Open the rediff website
        driver.get("http://rediff.com");
       
        //Clicking 'All category' link
        driver.findElement(By.id("topallcatlink")).click();
        //creating object for WebDriverWait
        WebDriverWait wait=new WebDriverWait(driver, 50);
       
        //Waiting till page load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("href_2")));
       
        //Clicking Menswear '+' option in page
        driver.findElement(By.id("plus_minus_2")).click();
       
        //Fetching all sub-links under the Menswear '+' option
        List<WebElement> sblnk=driver.findElements(By.xpath("//*[@id='divL3_2']/span"));
       
        //Iterate all sublinks and click one by one
        for(int i=1;i<sblnk.size();i++){
            //Fetch text of links
            String lnkname=driver.findElement(By.xpath("//*[@id='divL3_2']/span["+i+"]/a")).getText();
           
            // Click the link
            driver.findElement(By.xpath("//*[@id='divL3_2']/span["+i+"]/a")).click();
           
            //waiting for page load
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("href_2")));
           
            //Fetch the page title
            String pgtitle=driver.getTitle();
            System.out.println("Page Title is : "+pgtitle);
           
            //Fetching the breadcrump from the page
            String brdcrmp=driver.findElement(By.xpath("//*[@id='productresultsWrapper']/div[1]/div[1]/div[2]/div")).getText();
            System.out.println("BreadCrump from the current page : "+brdcrmp);
           
            //Identifying sort by dropdown
            WebElement srtby_drp=driver.findElement(By.className("sortbybox"));
            //Fetching all values of dropdown to collections
            List<WebElement> sortbydrpdwn=srtby_drp.findElements(By.tagName("option"));
            //selection of dropdown option
            for(WebElement d:sortbydrpdwn){
                if (d.getText().equals("Price - Low to High")){
                    d.click();
                    System.out.println("Dropdown Option selected");
                    break;
                }
            }
           
            //Clicking option Low to high; Option[2]
            //driver.findElement(By.xpath("*[@id='productresultsWrapper']/div[1]/div[2]/div/select/Option[2]")).click();
           
            Thread.sleep(5000);
           
            //Navigate back twice
            driver.navigate().back();
            driver.navigate().back();
           
            //Clicking Menswear '+' option in page
            driver.findElement(By.id("plus_minus_2")).click();
                       
        }
       
        System.out.println("All done; Browser can be closed");
       
        //Close the browser
        driver.close();       

    }

}
