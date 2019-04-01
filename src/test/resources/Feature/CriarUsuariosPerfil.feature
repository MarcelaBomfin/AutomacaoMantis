@login @cadastrar @perfil @usuario
Feature: Cadastrar os perfis de usuarios
   
 Background:
   			Given o usuario acessou a pagina de login 
	      And usuario realizar o login
				
@teste
Scenario Outline: Criar varios usuarios
	 And acessar Gerenciar
   And acessar a aba Gerenciar
	 And acessar Criar nova Conta
   When preencher os campos "<nomeUsuario>","<nomeVerdadeiro>","<email>","<nivelDeAcesso>"
   Then o sistema ira criar os usuarios
  
  Examples:
  | nomeUsuario    | nomeVerdadeiro |    email             | nivelDeAcesso |
  | maria.barbosa  | Maria Barbosa  | maria@teste.com.br   | gerente       |
	| marcela.ramos  | Marcela Ramos  | marcela@teste.com.br | atualizador   |
	| pedro.lacerda  | Pedro Lacerda  | pedro@teste.com.br   | relator       |
	| joao.silva     | Joao Silva     | joao@teste.com.br  	 | visualizador  |
	| ana.queiroz    | Ana Queiroz    | queiroz@teste.com.br | desenvolvedor |
	
	