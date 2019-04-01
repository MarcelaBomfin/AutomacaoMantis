@minha_visao @tarefas @bugs
Feature: Acessar a tarefa por minha visão

  Background: 
    Given o administrador está logado no mantis
    And o usuario fez o login
    And seleciono no Menu Minha Visão

  @teste
  Scenario Outline: Adicionar anotacao na tarefa pela minha visão
    When seleciono a tarefa
    And preencho a "<Anotacao>"
    Then concluo a inclusão da anotacao

    Examples: 
      | Anotacao                                               |
      | teste de incluir a anotacao na tarefa pela minha visao |

  @teste
  Scenario Outline: Mover a tarefa de projeto pelo filtro Relatados por mim
    And selecionei a tarefa para mover
    And seleciono para mover de projeto
    And altero a tarefa em "<moverTarefasPara>"
    Then concluo a mudança de projeto

    Examples: 
      | moverTarefasPara                    |
      | Projeto Vincula Campo Personalizado |
