@marcador @projeto 
Feature: Manter os marcadores cadastradas para os projetos

		Background:
				Given o usuario esta logado como administrador
				And o usuario efetuou o login
				And seleciono para Gerenciar
				And seleciono para Gerenciar os Marcadores
  
	@teste
  Scenario Outline: Criar o marcador
    When informo o "<nomeDoMarcador>","<descricaoDoMarcador>"
		Then confirmo a criacao do marcador
	
	Examples:
	| nomeDoMarcador     | descricaoDoMarcador          |
	| Criacao do Marcador| Teste de criacao do marcador |
	
	@teste
	Scenario Outline: Editar o marcador
		And seleciono o marcador
		When seleciono para atualizar o marcador
		And atualizo o "<criadorDoMarcador>"
		Then seleciono para concluir a atualizacao
		
	Examples:
	|criadorDoMarcador |
	|ana.barbosa       |


 @teste
	Scenario: Visualizar Tarefas relacionadas ao marcador
		And seleciono o marcador original
		When seleciono para visualizar as tarefas
		Then confirmo a visualizacao das tarefas relacionadas
	
	@teste
	Scenario: Excluir marcador
  	And seleciono o marcador para excluir
  	When seleciono para excluir
  	Then confirmo a exclusao
  	And valido a exclusao do marcador
  	
 
		
