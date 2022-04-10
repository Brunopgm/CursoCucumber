@funcionais
Feature: Cadastro de contas

Como um usuário
Eu quero cadastrar contas 
Pra poder distribuir meu dinheiro de forma mais organizada


Background: 
	Given que estou acessando a aplicacao
	When informo o usuario "bruno.pgm@outlook.com"
	And a senha "123"
	And seleciono entrar
	Then visualizo a pagina inicial
	When seleciono Contas
	And seleciono Adicionar
	

Scenario Outline: 
	When informo a conta "<conta>"
	And seleciono Salvar
	Then recebo a mensagem "<mensagem>"
	

Examples: 
	| conta               | mensagem                     			 	|
	| Conta de teste    	| Conta adicionada com sucesso!				|
	|								   	  | Informe o nome da conta           	|
	| Conta mesmo nome		| Já existe uma conta com esse nome! 	|



