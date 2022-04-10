package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import br.ce.wcaquino.utils.DataUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AlugarFilmeSteps {
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Given("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer int1) {
		System.out.println("Teste");
	    filme = new Filme();
	    filme.setEstoque(int1);
	}
	@Given("que o preco de aluguel seja R${int}")
	public void queOPrecoDeAluguelSejaR$(Integer int1) {
		filme.setAluguel(int1);
	}
	
	@Given("um filme")
	public void um_filme(DataTable table) {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL:tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}
	
	@When("alugar")
	public void alugar() {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);			
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}
	@Then("o preco do aluguel sera R${int}")
	public void oPrecoDoAluguelSeraR$(Integer int1) {
		Assert.assertEquals(int1, nota.getPreco());
	}
	@Then("o estoque do filme sera {int} unidade")
	public void oEstoqueDoFilmeSeraUnidade(Integer int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}
	
	@Then("nao sera possivel por falta de estoque")
	public void nao_sera_possivel_por_falta_de_estoque() {
	    Assert.assertEquals("Filme sem estoque", erro);
	}
	
	

	@Given("^que o tipo do aluguel seja (.*)$")
	public void que_o_tipo_do_aluguel_seja_extendido(String tipo) {
		tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL:tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Then("a data de entrega sera em {int} dias")
	public void a_data_de_entrega_sera_em_dias(Integer int1) {
	    Date dataEsperada = DataUtils.obterDataDiferencaDias(int1);
	    Date dataReal = nota.getDataEntrega();
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    
	    Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Then("a pontuacao recebida sera de {int} pontos")
	public void a_pontuacao_recebida_sera_de_pontos(Integer int1) {
	    Assert.assertEquals(int1, nota.getPontuacao());
	}
}
