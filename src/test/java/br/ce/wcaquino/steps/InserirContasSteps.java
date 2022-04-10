package br.ce.wcaquino.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InserirContasSteps {
	private WebDriver driver;
	
	@Given("que estou acessando a aplicacao")
	public void que_estou_acessando_a_aplicacao() {
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
	}

	@When("informo o usuario {string}")
	public void informo_o_usuario(String arg1) {
	    driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("a senha {string}")
	public void a_senha(String arg1) {
		driver.findElement(By.name("senha")).sendKeys(arg1);
	}

	@When("seleciono entrar")
	public void seleciono_entrar() {
	     driver.findElement(By.tagName("button")).click();
	}

	@Then("visualizo a pagina inicial")
	public void visualizo_a_pagina_inicial() {
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, Bruno!", texto);
	}

	@When("seleciono Contas")
	public void seleciono_contas() {
	    driver.findElement(By.linkText("Contas")).click();
	}

	@When("seleciono Adicionar")
	public void seleciono_adicionar() {
	    driver.findElement(By.linkText("Adicionar")).click();
	}
	
	@When("informo a conta {string}")
	public void informo_a_conta(String arg1) {
	    driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@When("seleciono Salvar")
	public void seleciono_salvar() {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("a conta e inserida com sucesso")
	public void a_conta_e_inserida_com_sucesso() {
		 String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		 Assert.assertEquals("Conta adicionada com sucesso!", texto);  
	}


	@Then("sou notificado que o nome da conta e obrigatorio")
	public void sou_notificado_que_o_nome_da_conta_e_obrigatorio() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Informe o nome da conta", texto);
	}

	@Then("sou notificado que ja existe uma conta com esse nome")
	public void sou_notificado_que_ja_existe_uma_conta_com_esse_nome() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("J� existe uma conta com esse nome!", texto);
	}
	
	
	@Then("recebo a mensagem {string}")
	public void recebo_a_mensagem(String string) {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	    Assert.assertEquals(string, texto);
	}
	
	
	
	//** O After é executado na ordem decrescente e o before na ordem crescente
	@After(order = 1, value= "@funcionais") // Será executado primeiro
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+ cenario.getId() +".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
//	Hook - Tradu��o "gancho". � um c�digo que ser� executado antes ou depois do cen�rio
	@After (order = 0, value= "@funcionais") // Será executado depois
	public void fecharBrowser() {
		driver.quit();
	}

}
