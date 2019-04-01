@tarefa @pegajosa @marcar @desmarcar @pesquisa
Feature: Verificar as terfas pegajosas
  
  	Background:
  	     Given o administrador abriu a pagina do mantis
  	     And efetuou o login com sucesso
  	     And acessou Ver tarefas no menu
	
	@teste
  Scenario: Marcar a tarefa como pegajosa
    When selecionei o numero da tarefa
    Then marquei a tarefa como pegajosa
    
  @teste
  Scenario: Desmarcar a tarefa como pegajosa
    When selecionei o numero da tarefa
    Then desmarquei a tarefa como pegajosa
    