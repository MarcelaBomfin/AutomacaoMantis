@login @administrator @perfil @usuario
Feature: Autenticar login com o perfil Administrador

Background:
	 Given o usuario administrador acessou a pagina de login
   
@teste
Scenario: Autenticar login no sistema Mantis com o perfil de Administrador
   When o usuario realizar o login
   Then o sistema exibira a tela inicial do Mantis

