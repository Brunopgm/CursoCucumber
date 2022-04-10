package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/features/",
		glue = "br.ce.wcaquino.steps",
		tags ="@funcionais",
		plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE
)
public class RunnerFuncionaisTeste {
	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("bruno.pgm@outlook.com");
		driver.findElement(By.name("senha")).sendKeys("123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
