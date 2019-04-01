@ver_tarefas @filtros
Feature: Realizar filtros na tarefas, notificar os usuarios com lembretes

  Background: 
    Given carregou a pagina do Mantis
    And realizar o login
    And acessei Ver Tarefas

  @teste
  Scenario: Apagar a tarefa
    And seleciono a tarefa a ser apagada
    When seleciono para apagar a tarefa
    And o sistema confirma para apagar a tarefa
    Then a tarefa foi excluida

  @teste
  Scenario Outline: Clonar a tarefa
    And seleciono a tarefa a ser clonada
    When seleciono para Cria clone
    And preencho o campo "<Resumo>" da tarefa
    Then salvo a tarefa clone

    Examples: 
      | Resumo                     |
      | Criação do Clone da Tarefa |

  @teste
  Scenario Outline: Enviar um lembre de tarefa a um usuario
    And tarefa de enviar lembrete
    When seleciono para Enviar lembrete
    And informar o "<usuarioRecebe>","<textoLembrete>"
    And seleciono para Enviar
    Then o sistema conclui o envio do lembrete

    Examples: 
      | usuarioRecebe    | textoLembrete                 |
      | ana.barbosa      | Lembrete para fechar a tarefa |
      | atribuir.usuario | Lembrete para apagar tarefa   |

  @teste
  Scenario Outline: Pesquisar a tarefa
    And filtro pelos campos "<Relator>","<atribuidoA>","<Prioridade>"
    When realizo a pesquisa
    Then o sistma retornou os registros

    Examples: 
      | Relator    | atribuidoA    | Prioridade |
      | [Eu mesmo] | administrator | alta       |

  @teste
  Scenario Outline: Salvar filtro de pesquisa já realizada
    And salvo a pesquisa com os filtros "<relator>","<atribuidoA>"
    When clico para salvar o filtro
    And preencho o "<nomeDoFiltro>"
    Then o sistema salva o filtro

    Examples: 
      | relator       | atribuidoA    | nomeDoFiltro       |
      | administrator | administrator | Filtro Teste Salvo |

  @teste
  Scenario Outline: Realizar a pesquisa com o filtro salvo
    When seleciono o "<nomeDoFiltro>" que foi salvo
    Then o sistema realiza o filtro

    Examples: 
      | nomeDoFiltro      |
      | Filtro Por Estado |
   
   @teste
   Scenario: Imprimir tarefas
   	When seleciono para imprimir tarefas
   	Then o sistema retorna as tarefas



