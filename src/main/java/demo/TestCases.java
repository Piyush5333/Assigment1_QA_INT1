package demo;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases 
{
    ChromeDriver driver;
        
    
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase0s1()
    {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    }

    public  void testCase01()
    {
        System.out.println("Start Test case: testCase01");
        
        driver.get("https://www.google.com");
        
        driver.findElement(By.name("q")).sendKeys("Amazon");
        
        driver.findElement(By.xpath("//div[contains(@style,'background:url')]//preceding::input[@value='Google Search'][2]")).click();
       
        if(driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed())
        {
           System.out.println("Amazon.in Found");	
        }
        
        if(driver.findElement(By.xpath("//cite[text()='https://www.amazon.com']//following::span[text()='Amazon.com']")).isDisplayed())
        {
        	System.out.println("Amazon.com found");
        }
        else
        {
        	System.out.println("Amazon.com not found");
        }	
        
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02()
    {
        System.out.println("Start Test case: testCase02");
        
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        
        java.util.List<WebElement> list =  driver.findElements(By.xpath("//a[@href]"));
        
        if(list.size()>0)
        {
        	System.out.println("Total links Present on Page : "+ list.size());
        }	
        System.out.println("end Test case: testCase02");
    }
    
 
    public  void testCase03()
    {
        System.out.println("Start Test case: testCase03");
        
        //Navigate to linkedin.com
        driver.get("https://www.linkedin.com/home");
        
        //Set Mail id
        driver.findElement(By.id("session_key")).sendKeys("piyushtest@gmail.com");
        
        //Set Password 
        driver.findElement(By.xpath("session_password")).sendKeys("test@123");
        
        //click on Sign In Button
        driver.findElement(By.xpath("//button[normalize-space(text()) = 'Sign in']")).click();
        
        //Print View Profile Count
        System.out.println("View Profile count : "+driver.findElement(By.xpath("//*[contains(text(),'viewed your profile')]")).getText());
        
        //Print Total view impression 
        System.out.println("Total view impression : "+driver.findElement(By.xpath("//span[contains(text(),'impression')]")).getText());
       
        //click on post button
        driver.findElement(By.xpath("//button[contains(@class,'share-box-feed-entry__')]")).click();
        
        //Navigate to Post Pop-window
        driver.findElement(By.xpath("//div[@aria-placeholder='Start typing or navigate to next element to use the draft with AI feature']")).sendKeys("This is my first Post");
        
        System.out.println("end Test case: testCase03");
    }

    
    public  void testCase04()
    {
        System.out.println("Start Test case: testCase04");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        java.util.List<WebElement> Premiermovieslist =  driver.findElements(By.xpath("//h2[text()='Premieres']"
        		+ "//preceding::div[contains(@class,'WidgetContainerBody')]"
        		+ "[2]/div//img"));
       
        for(WebElement movieurl : Premiermovieslist )
        {
        	System.out.println(movieurl);
        }	
        
        System.out.println("Second item name from list :" + driver.findElement(By.xpath("//h2[text()='Premieres']//following::div[2]//a[2]//h3/preceding-sibling::div[2])")).getText() );
        
        System.out.println("Language of second from Priemerelist :"+ driver.findElement(By.xpath("//h2[text()='Premieres']//following::div[2]//a[2]//h3/preceding-sibling::div[1]")).getText()); 
        
        System.out.println("end Test case: testCase04");
    }

    public void testCase07()
    {
        System.out.println("Start Test case: testCase07");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        driver.switchTo().frame("frame-top");
        
        driver.switchTo().frame("frame-left");
        
        System.out.println(driver.findElement(By.xpath("//body[normalize-space(text()) ='LEFT']")).getText());
        
        driver.switchTo().parentFrame();
        
        driver.switchTo().frame("frame-middle");
        
        System.out.println(driver.findElement(By.id("content")).getText());
        
        driver.switchTo().parentFrame();
        
        driver.switchTo().frame("frame-right");
        
       System.out.println(driver.findElement(By.xpath("//body[normalize-space(text()) ='RIGHT']")).getText());
       
       driver.switchTo().defaultContent();
       
       driver.switchTo().frame("frame-bottom");
       
       System.out.println(driver.findElement(By.xpath("//body[normalize-space(text()) ='BOTTOM']")).getText());
       
       driver.switchTo().defaultContent();
       
       System.out.println("end Test case: testCase07");      
        
    }
    
    
    public  void testCase09() throws InterruptedException
    {
        System.out.println("Start Test case: testCase09");
        
        driver.get("https://www.imdb.com/chart/top");
        
        String header = driver.findElement(By.xpath("//h1[text()='IMDb Top 250 Movies']")).getText();
       
        if(header.equals("IMDb Top 250 Movies"))
        {
        	System.out.println("System is navigated to correct site");
        }	
        
        Select dropdown = new Select(driver.findElement(By.id("sort-by-selector")));
        
        dropdown.selectByValue("USER_RATING");
         
        java.util.List<WebElement> Templist = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]//li"));
        
        LinkedList<WebElement> ratinglist = new LinkedList<WebElement>(Templist);
       
        
        System.out.print(ratinglist.getFirst().getText());
        
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(ratinglist));
        
        System.out.println("Total Count :" + ratinglist.size());  
        
        //sort based on release date
        dropdown.selectByValue("RELEASE_DATE");
        
        //sort in ascending order
        driver.findElement(By.xpath("//button[@title='Change sort by direction']")).click();
        
        Templist.clear();
        
        Templist = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]//li"));
        
        LinkedList<WebElement> releasedatelist = new LinkedList<WebElement>(Templist);
        
        //print oldest movie
        System.out.print(releasedatelist.getFirst().getText());        
        
        System.out.println();
        //Change in descending order
        driver.findElement(By.xpath("//button[@title='Change sort by direction']")).click();
        
        Templist.clear();
        
        //fetch desecnding order list
        Templist = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]//li"));
        
        releasedatelist.clear();
        
        releasedatelist = new LinkedList<WebElement>(Templist);
        
        //print latest release date movie
        System.out.print(releasedatelist.getFirst().getText());
        
        //sort the list based on User ratings
        dropdown.selectByValue("USER_RATING_COUNT");
        
        Templist.clear();
        
        Templist = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]//li"));
       
        LinkedList<WebElement> publicratinglist = new LinkedList<WebElement>(Templist);
       
        System.out.println();
        //print value based on public rating
        System.out.print(publicratinglist.getFirst().getText());
       
        System.out.println();
        
        System.out.println("end Test case: testCase09");
    }


    public  void testCase10() throws IOException
    {
        System.out.println("Start Test case: testCase10");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        
        String parentwindow = driver.getWindowHandle();
        
        driver.switchTo().frame("iframeResult");
        
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Set<String> Windowchildset = driver.getWindowHandles();
        
        for(String window :Windowchildset)
        {
        	if(!parentwindow.equalsIgnoreCase(window))
        	{
        		driver.switchTo().window(window);
        		System.out.println(driver.getCurrentUrl());
        		System.out.println(driver.getTitle());
        		
        		
        		//Convert web driver object to TakeScreenshot
        		TakesScreenshot scrShot =((TakesScreenshot)driver);
        		//Call getScreenshotAs method to create image file
        		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        		//Move image file to new destination
        		File DestFile=new File("\\selenium-starter-2\\Screenshots");
        		//Copy file at destination
        		FileUtils.copyFile(SrcFile, DestFile);
        	}	
        }	
        
        driver.switchTo().window(parentwindow);
        System.out.println("end Test case: testCase10");
    }
   
}
