@categoria @projeto
Feature: Manter as categorias cadastradas para os projetos

  Background: 
    Given abriu a pagina do Mantis
    And fez o login no Mantis
    And seleciono para Gerenciar no menu
    And seleciono para Gerenciar os Projetos

  @teste
  Scenario Outline: Adicionar a categoria
    And informo o "<nomeDaCategoria>"
    When adiciono a categoria
    Then confirmo a criacao na lista

    Examples: 
      | nomeDaCategoria              |
      | Categoria de teste do Mantis |

  @teste
  Scenario Outline: Adicionar e alterar a categoria
    And preencho o nome da "<categoria>"
    When seleciono para alterar a categoria
    And edito o campo "<atribuidoA>"
    Then atualizo a categoria

    Examples: 
      | categoria                                | atribuidoA    |
      | teste de adicionar e alterar a categoria | administrator |

  @teste
  Scenario: Adicionar a categoria sem informar o titulo
    When seleciono para adicionar a categoria
    Then o sistema exibe a mensagem de campo vazio

  @teste
  Scenario: Excluir a categoria
    When seleciono a categoria para excluir
    And confirmar para excluir
    Then visualizo a mensagem de confirmacao

  @teste
  Scenario Outline: Alterar a categoria
    When seleciono alterar a categoria
    And seleciono para alterar "<selecionarAtribuidoA>"
    Then confirmo a edicao da categoria

    Examples: 
      | selecionarAtribuidoA |
      | administrator        |
