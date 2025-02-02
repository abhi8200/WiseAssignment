import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WiseLiveAutomation {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

	
	  @Test(priority = 1) public void loginAsTutor() {
	  driver.get("https://staging-web.wise.live");
	  
	  // Click on Login
	  //driver.findElement(By.xpath("//button[contains(text(),'Login')]" )).click();
	  driver.findElement(By.xpath("//button[contains(text(),'Already have an account? Login')]")).click();

	  driver.findElement( By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]/span[1]")).click();
	  // Enter phone number WebElement phoneInput =
	  WebElement s = driver.findElement(By.xpath("//input[@placeholder='Phone number']"));
	  s.sendKeys("+911111100000");
	  
	  // Click OTP button
	  driver.findElement(By.xpath("//span[normalize-space()='Get OTP']")).click();
	  
	  // Enter OTP 
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("0");
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("0");
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")).sendKeys("0");
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/input[1]")).sendKeys("0");

	  
	  
	  // Click Verify
	  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]/span[1]" )).click();
	  
	  // Assert institute name WebElement instituteName =
	  WebElement w= driver.findElement(By.xpath("(//div[@class='name text--24 font-weight--600 ml-3'])[1]"));
	  
	  String actualText = w.getText();
	  String expectedText= "Testing Institute";
	  Assert.assertTrue(actualText.contains(expectedText),"Matching text"); }//"Testing Institute"
	  
	  @Test(priority = 2) public void navigateToClassroom() {
	  driver.findElement(By.xpath("//div[normalize-space()='Group course']")).click() ;
	  Alert alert = driver.switchTo(). alert();
	  alert.dismiss();
	  driver.findElement(By.xpath("//a[normalize-space()='Classroom for Automated testing']")).click();
	  WebElement classroomHeader = driver.findElement(By.xpath("//div[@class='text--24 font-weight--600']"));
	  Assert.assertTrue(classroomHeader.isDisplayed(),"Classroom open successfully"); }
	  
	  @Test(priority = 3) public void scheduleSession() {
	  driver.findElement(By.xpath("//a[normalize-space()='Live Sessions']")).click();
	  driver.findElement(By.xpath("//span[normalize-space()='Schedule Sessions']")).click();
	  
	  // Click 'Add session'
	  driver.findElement(By.xpath("//span[normalize-space()='Add session']")).click();
	  
	  // Select time (assuming there's a time picker, modify accordingly)
	  driver.findElement(By.xpath("//input[@id='input-691']")).sendKeys("10:00");
	  
	  // Click 'Create'
	  driver.findElement(By.xpath("//button[contains(@class,'v-btn v-btn--has-bg theme--light v-size--default medium primary-bg')]")).click(); }
	  
	  @Test(priority = 4) public void assertSession() { 
		  WebElement sessionCard =driver.findElement(By.xpath("//div[@id='679fa0fc8bc474b08de1f449']//div[@class='text--18 font-weight--600 mb-2'][normalize-space()='Live session']"));
	  Assert.assertTrue(sessionCard.isDisplayed(),"Session card is shown on timeline");
	  
	  // Assert session details WebElement instructorName =
	  WebElement instructorName = driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@id='app']/div[@class='v-application--wrap']/main[@id='app-main']/div[@class='v-main__wrap']/div[@id='main-scrollable-parent']/div[@class='my-1 mx-2 ma-sm-6']/div[@class='mt-0 overview-page']/div/div[@class='live-course-overview']/div/div/div[@class='d-flex align-start mb-14 mb-sm-0 justify-space-between']/div/div[@class='timeline js-track']/div[@id='679fa0fc8bc474b08de1f449']/div[@class='heading py-10 px-4 px-sm-6']/div[1]"));
	  WebElement sessionTime =driver.findElement(By.xpath("//div[normalize-space()='10:00 PM']"));
	  Assert.assertTrue(instructorName.isDisplayed(),"Instructor name is matched"); 
	  Assert.assertTrue(sessionTime.isDisplayed(),"Session time is incorrect"); }
	  
	  @AfterClass public void teardown() { driver.quit(); }
	 
}
