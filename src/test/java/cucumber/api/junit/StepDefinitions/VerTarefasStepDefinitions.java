package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.VerTarefasPage;
import cucumber.api.junit.Types.Usuario;

public class VerTarefasStepDefinitions {

	WebDriver driver;
	VerTarefasPage verTarefasPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public VerTarefasStepDefinitions(SharedClass sharedClass){
	        this.sharedClass = sharedClass;
	        this.driver = sharedClass.getDriver();
	        this.verTarefasPage = new VerTarefasPage(driver);
	        this.loginPage = new LoginPage(driver);
	    }
	
	@Given("^carregou a pagina do Mantis$")
	public void carregou_a_pagina_do_Mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^realizar o login$")
	public void realizar_o_login() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessei Ver Tarefas$")
	public void acesseiVerTarefas() {
		verTarefasPage.selecionarMenuVerTarefas();
	}

	// tarefa apagar
	@When("^seleciono a tarefa a ser apagada$")
	public void seleciono_a_tarefa_a_ser_apagada() {
		verTarefasPage.selecionarTarefaExcluir();
	}

	@When("^seleciono para apagar a tarefa$")
	public void seleciono_para_apagar_a_tarefa() {
		verTarefasPage.buttonApagarTarefa();
	}

	@When("^o sistema confirma para apagar a tarefa$")
	public void o_sistema_confirma_para_apagar_a_tarefa() {
		verTarefasPage.confirmaApagarTarefa();
	}

	@Then("^a tarefa foi excluida$")
	public void a_tarefa_foi_excluida() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view_all_bug_page.php");
	}

	// clonar a tarefa
	@Given("^seleciono a tarefa a ser clonada$")
	public void seleciono_a_tarefa_a_ser_clonada() {
		verTarefasPage.selecionarTarefaClonar();
	}

	@When("^seleciono para Cria clone$")
	public void seleciono_para_Cria_clone() {
		verTarefasPage.criarCloneTarefa();
	}

	@When("^preencho o campo \"([^\"]*)\" da tarefa$")
	public void preencho_o_campo_da_tarefa(String Resumo) {
		verTarefasPage.preencherCampoDescricao(Resumo);
	}

	@Then("^salvo a tarefa clone$")
	public void salvo_a_tarefa_clone() {
		verTarefasPage.concluirCriacaoClone();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/bug_report.php?posted=1");
	}

	// enviar lembrete
	@Given("^tarefa de enviar lembrete$")
	public void tarefa_de_enviar_lembrete()  {
		verTarefasPage.selecionarTarefaLembrete();
	}

	@When("^seleciono para Enviar lembrete$")
	public void seleciono_para_Enviar_lembrete() {
		verTarefasPage.enviarLembreteTarefa();
	}

	@When("^informar o \"([^\"]*)\",\"([^\"]*)\"$")
	public void seleciono_o(String usuarioRecebe, String textoLembrete) {
		verTarefasPage.informarOusuario(usuarioRecebe);
		verTarefasPage.ecrevoMensagemLembrete(textoLembrete);
	}

	@When("^seleciono para Enviar$")
	public void seleciono_para_Enviar()  {
		verTarefasPage.enviarLembrete();
	}

	@Then("^o sistema conclui o envio do lembrete$")
	public void o_sistema_conclui_o_envio_do_lembrete() {
		verTarefasPage.visualizoMensagemEnvioSucesso();
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/bug_reminder.php");
	}
	
	//pesquisar tarefa
	@Given("^filtro pelos campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void filtro_pelos_campos(String Relator, String atribuidoA, String Prioridade)  {
		verTarefasPage.selecionarRelator(Relator);
		verTarefasPage.selecionarAtribuidoA(atribuidoA);
		verTarefasPage.selecionarPrioridade(Prioridade);
	}

	@When("^realizo a pesquisa$")
	public void realizo_a_pesquisa()  {
		verTarefasPage.clicoParaPesquisar();
	}

	@Then("^o sistma retornou os registros$")
	public void o_sistma_retornou_os_registros()  {
	    verTarefasPage.validarPesquisa();
	    
	    String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/view_all_bug_page.php");
	}
	
	//salvar o filtro
	@Given("^salvo a pesquisa com os filtros \"([^\"]*)\",\"([^\"]*)\"$")
	public void salvo_a_pesquisa_com_os_filtros(String relator, String atribuidoA)  {
		verTarefasPage.informarRelator(relator);
		verTarefasPage.informarAtribuir(atribuidoA);
	}

	@When("^clico para salvar o filtro$")
	public void clico_para_salvar_o_filtro() {
		verTarefasPage.salvarFitroSucesso();
	}

	@When("^preencho o \"([^\"]*)\"$")
	public void preencho_o(String nomeDoFiltro)  {
		verTarefasPage.informarNomeDoFiltro(nomeDoFiltro);
	}

	@Then("^o sistema salva o filtro$")
	public void o_sistema_salva_o_filtro()  {
		verTarefasPage.salvarFitroDefinitivo();
	}
	
	//pesquisa com filtro salvo
	@When("^seleciono o \"([^\"]*)\" que foi salvo$")
	public void seleciono_o_que_foi_salvo(String nomeDoFiltro) {
	    verTarefasPage.selecionarNomeFiltro(nomeDoFiltro);
	}

	@Then("^o sistema realiza o filtro$")
	public void o_sistema_realiza_o_filtro() {
		verTarefasPage.validarRetornoFiltro();
	}
	
	//imprimir tarefas
	@When("^seleciono para imprimir tarefas$")
	public void seleciono_para_imprimir_tarefas() {
		verTarefasPage.imprimirTarefas();
	}
   	@Then("^o sistema retorna as tarefas$")
   	public void o_sistema_retorna_as_tarefas() {
   		
   		String URL = driver.getCurrentUrl();
   		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/print_all_bug_page.php");
   	}	
}
