package cucumber.api.junit.StepDefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.TarefaPegajosaPage;
import cucumber.api.junit.Types.Usuario;

public class TarefaPegajosaStepDefinitions {

	WebDriver driver;
	TarefaPegajosaPage tarefaPegajosaPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public TarefaPegajosaStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.tarefaPegajosaPage = new TarefaPegajosaPage(driver);
        this.loginPage = new LoginPage(driver);
    }

	@Given("^o administrador abriu a pagina do mantis$")
	public void o_administrador_abriu_a_pagina_do_mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^efetuou o login com sucesso$")
	public void efetuou_o_login_com_sucesso() {
		System.out.println(driver.getPageSource());
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessou Ver tarefas no menu$")
	public void acessou_Ver_tarefas_no_menu() {
		tarefaPegajosaPage.selecionarVerTarefasNoMenu();
	}

	@Given("^selecionei o numero da tarefa$")
	public void selecionei_o_numero_da_tarefa() {
		tarefaPegajosaPage.selecionarTarefaPegajosa();
	}

	@When("^marquei a tarefa como pegajosa$")
	public void marquei_a_tarefa_como_pegajosa() {
		tarefaPegajosaPage.macarTarefa();
	}

	@When("^desmarquei a tarefa como pegajosa$")
	public void desmarquei_a_tarefa_como_pegajosa() {
		tarefaPegajosaPage.desmarcarTarefaButton();
	}

}
