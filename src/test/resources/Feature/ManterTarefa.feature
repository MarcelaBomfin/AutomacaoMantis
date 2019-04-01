@criar_tarefas @mantis @administrator
Feature: Criar tarefas do Mantis
 
   		Background:
   				Given o administrador acessou o Mantis
	   			And usuario fez o login
 			      
   @teste  
	 Scenario Outline: Criar uma nova tarefa no Mantis
 			And acessar no Menu Criar Tarefa
 			And escolho o "<projeto>"
 			And confirmo a selecao do projeto
 			When preencher os tipos "<Categoria>","<Resumo>","<Descricao>"
 		  Then a tarefa foi criada
     
  Examples:
  | projeto                 | Categoria                    | Resumo                   | Descricao                                         |
  | Porjeto de Teste Mantis | [Todos os Projetos] General  | Teste criação de tarefa automatizado |Projeto criado para o desafio do mapa de carreiras |
	
	
	@teste
	Scenario Outline: Editar uma nova tarefa no Mantis pelo estado
			And seleciono no Menu Ver Tarefa
      And seleciono a tarefa para atualizar 
      When alterar o campo "<Estado>"
      Then a tarefa foi atualizada

	Examples:
	| Estado     |
	| confirmado |

	@teste
	Scenario Outline: Adicionar o usuario a tarefa
			And seleciono Ver Tarefa
      And seleciono a tarefa para atribuir usuario
      And seleciono para atualizar a tarefa
      When editar o campo "<atribuirA>"
      Then o usuario foi atribuido a tarefa
 
 	Examples:
 	|atribuirA        |
 	|atribuir.usuario |
 	
@teste
Scenario Outline: Adicionar marcador a tarefa
	And seleciontar tarefa marcador
	When seleciono qual "<nomeMarcadorTarefa>"
	Then aplico o marcador a tarefa
	And valido a aplicacao do marcador no historico

Examples:
|nomeMarcadorTarefa|
|Projeto Desafio Mantis|

	@teste
	Scenario Outline: Fechar tarefa do Mantis com a resolucao corrigido
			And seleciono Ver Tarefa no menu
      And seleciono a tarefa para fechar
      When selecio o botao de fechar
      And altero o campos "<adicionarAnotacao>"
      Then concluo o fechamento da terefa
     
   Examples:
   | adicionarAnotacao             |
   | teste de fechamento de tarefa |
 
