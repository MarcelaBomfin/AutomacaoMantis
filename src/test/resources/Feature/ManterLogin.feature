@login_invalido @usuario_incorreto 
Feature: Autenticar o usuario com o login incorreto e recuperar o usuario

	Background:
			   Given o usuario abriu a pagina do Mantis
         
	@teste
  Scenario Outline: Informar o usuario incorreto
    When autenticou o login com "<usuarioInvalido>", "<senhaInvalida>"
    Then o sistema exibiu a mensagem de usuario incorreto
    
    Examples:
      | usuarioInvalido  | senhaInvalida |
      | usuario.invalido | 123456        |
  
  @teste
  Scenario Outline: Efetuar o Login e deslogar com sucesso
    When digitar o "<usuario>", "<senha>"
    And acesso a aba de administrador
    Then clico para deslogar do sistema
    And o sistem direciona para a pagina de login
    
    Examples:
      | usuario       |  senha       |
      | administrator | bomfin030788 |
  
  @teste
  Scenario Outline: Recuperar a senha
    When digitou o "<usuarioForgot>"
    And selecinou a opcao de perdeu a senha
    And informou o campo "<emailRecupera>"
    Then enviou a solicitacao de recuperacao
    And o sistema voltou pra pagina inicial

    Examples: 
      | usuarioForgot | emailRecupera  |
      | administrator | root@localhost | 
   
