@gerenciar_projeto @mantis @administrator
Feature: Gerenciar projetos do Mantis
 
 Background:
   			Given o usuario efetuou login 
	      And usuario fizer o login
 
 @teste
 Scenario Outline: Criar um novo projeto no Mantis
		And acessar Gerenciar no Menu
    And acessar Gerenciar Projetos
    And acessar Criar novo Projeto
    When preencher os campos "<nomeDoProjeto>","<Estado>","<Visibilidade>","<Descricao>"
    Then o projeto foi criado
    
  Examples:
    |NomeDoProjeto                | Estado          | Visibilidade | Descricao                                        |
   	|Projeto de Teste do Mantis	  | desenvolvimento | publico      |Projeto criado para o desafio do mapa de carreiras|
   	#|Projeto de Teste do Mantis 1	| release         | privado      |Projeto criado para o desafio do mapa de carreiras|
    #|Projeto de Teste do Mantis 2 | estavel         | publico      |Projeto criado para o desafio do mapa de carreiras|
    #|Projeto de Teste do Mantis	3 | obsoleto        | privado      |Projeto criado para o desafio do mapa de carreiras|

Scenario Outline: Editar projeto
	 And acessar Gerenciar
   And acessar a aba Gerenciar Projetos
   And selecionar o Projeto
   When atualizar os campos necessarios
   Then o sistema atualizou o projeto
   
Scenario Outline: Excluir projeto
	 And acessar Gerenciar
   And acessar a aba Gerenciar Projetos
   When selecionar o projeto
   When seleciono apagar o projeto
   Then confirmar a exclusão do projeto