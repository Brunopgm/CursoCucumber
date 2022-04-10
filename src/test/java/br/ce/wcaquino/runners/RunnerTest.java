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
		tags ="@unitarios",
		plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE
)
public class RunnerTest {
	
}
