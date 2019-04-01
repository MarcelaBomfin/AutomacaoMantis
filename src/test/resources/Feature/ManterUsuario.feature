@login @editar @excluir @perfil @usuario
Feature: Atualizar e excluir os usuarios
   
 Background:
   		  Given o usuario abriu a pagina do mantis
	      And usuario logou no mantis
				And acessar Gerenciar no menu
   	    And acessar menu Gerenciar Usuarios

@teste
Scenario Outline: Editar usuario
   And selecionar o Nome de Usuario
   When atualizar o "<editarNivelAcesso>"
   Then o sistema atualizou o usuario
 
 	Examples:
	 | editarNivelAcesso |
	 | desenvolvedor     |
 
@teste
Scenario: Redefinir a senha
	  And seleciono o Usuario
    When seleciono para redefinir a senha
    Then o sistema orienta sobre a redefinicao

@teste
Scenario: Representar Usuario
	  And selecionar o Usuario para representar
    When seleciono para representar o usuario
    Then o sistema solicita a confirmacao
 		
@teste
Scenario: Excluir usuario
   When selecionar o usuario para excluir
   Then confirmar a exclusao do usuario
   And o sistema exibe a mensagem confirmando
	
