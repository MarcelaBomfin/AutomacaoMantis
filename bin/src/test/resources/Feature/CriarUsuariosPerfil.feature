@login @cadastrar @perfil @usuario
Feature: Cadastrar os perfis de usuarios
   
 Background:
   			Given o usuario acessou a pagina de login 
	      And usuario realizar o login

@test
Scenario Outline: Criar varios usuarios
	 And acessar Gerenciar
   #And preecher o campo senha
   And acessar a aba Gerenciar Usuarios
   And acessar Criar nova Conta
   When preencher os campos "<nomeUsuario>","<nomeVerdadeiro>","<email>","<nivelDeAcesso>"
   Then o sistema ira criar os usuarios
  
  Examples:
  | nomeUsuario    | nomeVerdadeiro |    email            | nivelDeAcesso   |
  | renata.souza   | Renata Souza   | renata@teste.com.br |	visualizador    |
  | marcelo.silva  | Marcelo Silva  |	marcelo@teste.com.br| relator         | 
  | maria.campolina| Maria Campolina|	maria@teste.com.br  | atualizador     |
  | roberto.machado| Roberto Machado| roberto@teste.com.br| desenvolvedor   |
  | ana.barbosa    | Ana Barbosa    | ana@teste.com.br  	| gerente         |
  | douglas.moraes | Douglas Moraes | douglas@teste.com.br| administrador   |
 
Scenario: Editar usuario
	 And acessar Gerenciar
   And acessar a aba Gerenciar Usuarios
   And selecionar o Nome de Usuario
   And atualizar os campos necessarios
   When atualizar o usuario
   Then o sistema atualizou o usuario
   
Scenario: Excluir usuario
	 And acessar Gerenciar
   And acessar a aba Gerenciar Usuarios
   When selecionar o usuario
   Then confirmar a exclusão do usuario

Scenario: Excluir usuario
	 And acessar Gerenciar
   And acessar a aba Gerenciar Usuarios
   When selecionar o usuario
   Then confirmar a exclusão do usuario


   