import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAmbiente {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bbrito\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
	}
}
