package cucumber.api.junit.StepDefinitions;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.ManterCategoriasPage;
import cucumber.api.junit.Types.Usuario;

public class ManterCategoriasStepDefinitions {

	WebDriver driver;
	ManterCategoriasPage manterCategoriasPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public ManterCategoriasStepDefinitions(SharedClass sharedClass){
	        this.sharedClass = sharedClass;
	        this.driver = sharedClass.getDriver();
	        this.manterCategoriasPage = new ManterCategoriasPage(driver);
	        this.loginPage = new LoginPage(driver);
	    }

	@Given("^abriu a pagina do Mantis$")
	public void abriu_a_pagina_do_Mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();

	}

	@Given("^fez o login no Mantis$")
	public void fez_o_login_no_Mantis() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^seleciono para Gerenciar no menu$")
	public void seleciono_para_Gerenciar_no_menu() {
		manterCategoriasPage.gerenciarMenu();
	}

	@Given("^seleciono para Gerenciar os Projetos$")
	public void seleciono_para_Gerenciar_os_Projetos() {
		manterCategoriasPage.abaGerenciarProjetos();
	}

	@Given("^informo o \"([^\"]*)\"$")
	public void informo_o_nome_da_categoria(String nomeDaCategoria) {
		manterCategoriasPage.preencherNomeCategoria(nomeDaCategoria);
	}

	@When("^adiciono a categoria$")
	public void adiciono_a_categoria() {
		manterCategoriasPage.categoriaButton();
	}

	@Then("^confirmo a criacao na lista$")
	public void confirmo_a_criacao_na_lista() {

		// String URL = driver.getCurrentUrl();
		// Assert.assertEquals(URL,
		// "https://mantis.marcela.base2.com.br/manage_proj_page.php");
	}

	// adicionar ou alterar categoria
	@Given("^preencho o nome da \"([^\"]*)\"$")
	public void preencho_o_nome_da_categoria(String categoria) {
		manterCategoriasPage.informarNomeCategoria(categoria);
	}

	@When("^seleciono para alterar a categoria$")
	public void seleciono_para_alterar_a_categoria() {
		manterCategoriasPage.buttonAdicionarAlterar();
	}

	@When("^edito o campo \"([^\"]*)\"$")
	public void edito_a(String atribuidoA) {
		manterCategoriasPage.selecionarAtribuir(atribuidoA);
	}

	@Then("^atualizo a categoria$")
	public void atualizo_a_categoria() {
		manterCategoriasPage.atualizarCategoriaButton();
	}

	// categoria vazio
	@When("^seleciono para adicionar a categoria$")
	public void seleciono_para_adicionar_a_categoria() {
		manterCategoriasPage.adicionarCategoriaVazio();
	}

	@Then("^o sistema exibe a mensagem de campo vazio$")
	public void o_sistema_exibe_a_mensagem_de_campo_vazio() {
		manterCategoriasPage.validarMensagemTela();
	}

	// excluir a categoria
	@When("^seleciono a categoria para excluir$")
	public void seleciono_a_categoria_para_excluir() {
		manterCategoriasPage.excluirCategoriaSelecionar();
	}

	@When("^confirmar para excluir$")
	public void confirmar_para_excluir() {
		manterCategoriasPage.confirmarExclusao();
	}

	@Then("^visualizo a mensagem de confirmacao$")
	public void visualizo_a_mensagem_de_confirmacao() {
		manterCategoriasPage.visualizarMensagemSucesso();
	}

	// alterar a categoria
	@When("^seleciono alterar a categoria$")
	public void seleciono_alterar_a_categoria() {
		manterCategoriasPage.alterarCategoriaButton();
	}

	@When("^seleciono para alterar \"([^\"]*)\"$")
	public void seleciono_para_alterar(String atribuidoA) {
		manterCategoriasPage.alterarAtribuirA(atribuidoA);
	}

	@Then("^confirmo a edicao da categoria$")
	public void confirmo_a_edicao_da_categoria() {
		manterCategoriasPage.alterarButtonCategoria();
	}
}
