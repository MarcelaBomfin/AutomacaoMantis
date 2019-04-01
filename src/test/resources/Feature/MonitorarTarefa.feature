 @monitorar @tarefa 
 Feature: Monitorar as tarefas 
 			
 	Background:
 					Given acessou o Mantis
 					And logou no sistema
 	
 	@teste		
  Scenario: Iniciar o monitoramento da tarefa
  	And acessou Ver tarefas
    When cliquei no numero da tarefa
    Then iniciou o Monitoramento
    And retornar ver tarefas

	@teste
	Scenario Outline: alterar o relator da tarefa
		And acessou Ver tarefas
		And selecionei a tarefa
    And selecionei para atualizar a tarefa
    When altero o campo "<alteraRelator>"
    Then adiciono o usuario
  
  Examples:
  | alteraRelator |
  | administrator|
  
  @teste
  Scenario: Parar de monitorar a tarefa
  	And acessou Ver tarefas menu
    And clico no numero da tarefa
    When parei o Monitoramento
    Then retornar ver tarefas menu
  
  @teste
  Scenario Outline: Pesquisar por quem está monitorando a tarefa
  	And clico para Ver tarefas 
    And clico na opção Monitorado Por
    And seleciono o "<usuarioMonitoradoPor>"
    When aplico o filtro
    Then o sistema retorna a tarefa monitorada

 Examples:
 |usuarioMonitoradoPor|
 |administrator       |
  
  @teste
  Scenario Outline: Redefinir o filtro de pesquisa
  	And Ver Tarefas de redefinicao
  	When seleciono para "<redefinirFiltro>"
  	Then o sistema limpa os filtros 

  Examples:
  |redefinirFiltro|
  |[Redefinir Filtro]|
  