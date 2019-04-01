@gerar_token @revogar_token @minha_conta
Feature: Gerar e revogar o token para teste de API
  
  Background:
  		Given o usuario administrador esta logado no mantis
  		And seleciono o Administrator no cabecalho
      And seleciono no Menu Minha Conta
      And seleciono a aba Tokens API
 
  @teste
  Scenario Outline: Criar o token para teste de API
  	And preencho "<nomeDoToken>"
  	When seleciono para criar o token
  	Then o sistema conclui a criacao do token
  	And retornar para Token Api
    
  Examples:
  | nomeDoToken             |
  | Token para Teste de API |
  
  @teste
  Scenario: Revogar o token
  	When seleciono para revogar o token
  	Then o sistema conclui a revogacao do token 
  	And retorno para a tela de tokens