@unitarios
Feature: Aprender Cucumber
	Como um aluno
	Eu quero aprender a utilizar Cucumber
	Pra que eu possa automatizar crit�rios de aceita��o


Scenario: Deve executar especificacao
	Given que eu criei um arquivo corretamente
	When executa-lo 
	Then a especifica��o deve finalizar com sucesso
	
Scenario: Deve incrementar contador
	Given que o valor do contador e 15
	When eu incrementar em 3
	Then o valor do contador sera 18
		