package br.ce.wcaquino.steps;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AprenderCucumberSteps {
	@Given("que eu criei um arquivo corretamente")
	public void que_eu_criei_um_arquivo_corretamente() {
	    System.out.println("Teste");
	}

	@When("executa-lo")
	public void executa_lo() {
		 System.out.println("Teste");
	}

	@Then("a especifica��o deve finalizar com sucesso")
	public void a_especifica_o_deve_finalizar_com_sucesso() {
		System.out.println("Teste");
	}
	
	
//	Contador 
	private int contador = 0;
	@Given("que o valor do contador e {int}")
	public void que_o_valor_do_contador(Integer int1) {
		contador = int1;
	}

	@When("eu incrementar em {int}")
	public void eu_incrementar_em(Integer int2) {
	    contador = contador + int2;
	}

	@Then("o valor do contador sera {int}")
	public void o_valor_do_contador_ser(Integer totalEsperado) {
//	    Assert.assert(totalEsperado, contador);
		Assert.assertTrue(contador == totalEsperado);
	}
}






