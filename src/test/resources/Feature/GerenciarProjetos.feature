@gerenciar_projeto @mantis @administrator
Feature: Gerenciar projetos do Mantis
 
 Background:
   			Given o usuario efetuou login 
	      And usuario fizer o login
 				And acessar Gerenciar no Menu
        And acessar Gerenciar Projetos
 				
 @teste
 Scenario Outline: Criar um novo projeto no Mantis
    And acessar Criar novo Projeto
    When preencher os campos a seguir "<nomeDoProjeto>","<Estado>","<Visibilidade>","<Descricao>"
    Then o projeto foi criado
    
  Examples:
  |nomeDoProjeto                             | Estado          | Visibilidade | Descricao                                          |
  |Desafio de Criacao de Projeto automatizado| desenvolvimento | privado      |Projeto criado para o desafio do mapa de carreiras  |

@teste
Scenario Outline: Editar projeto
   And selecionar o Projeto
   When atualizar os campos necessarios "<nomeProjetoEdit>","<Estado>","<Visibilidade>","<campoDescricaoEdit>"
   Then o sistema atualizou o projeto
  
  Examples:
  |nomeProjetoEdit             | Estado   | Visibilidade | campoDescricaoEdit                 |
	|Desafio do Mantis de Edicao | obsoleto |  privado     |Desafio automacao do Mantis Editado |

@teste
Scenario: Excluir projeto
   And seleciono o projeto para excluir
   When seleciono apagar o projeto
   Then o sistema exclui o projeto

@teste
Scenario Outline: Cadastrar o projeto com mesmo nome
    And acessar Criar novo Projeto menu
    When preencher os campos da tela "<nomeProjetoIgual>","<Estado>","<Visibilidade>","<Descricao>"
    And salvo o projeto igual
    Then o sistema exibe a mensagem de erro
    
  Examples:
  |nomeProjetoIgual       | Estado          | Visibilidade | Descricao                                        |
  |Projeto Desafio Mantis | desenvolvimento | privado      |Projeto criado para o desafio do mapa de carreiras|
 
@teste
Scenario Outline: Adicionar o usuario ao projeto
    And seleciono o projeto
    When marco o "<nomeUsuario>" projeto
    And escolho o "<nivelDeAcesso>" projeto
    Then adiciono o usuario ao projeto
 
   Examples:
   | nomeUsuario | nivelDeAcesso |
   | ana.barbosa | atualizador   |