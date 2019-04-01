package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.CampoPersonalizadoPage;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Types.Usuario;

public class CampoPersonalizadoStepDefinitions {

	WebDriver driver;
	CampoPersonalizadoPage campoPersonalizadoPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;

	public CampoPersonalizadoStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.campoPersonalizadoPage= new CampoPersonalizadoPage(driver);
        this.loginPage = new LoginPage(driver);
    }

	@Given("^acessou o site Mantis$")
	public void acessou_o_site_Mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^fez o login$")
	public void fez_o_login() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^seleciono o Gerenciar no Menu$")
	public void seleciono_o_Gerenciar_no_Menu() {
		campoPersonalizadoPage.gerenciarNoMenu();
	}

	@When("^seleciono no Menu Gerenciar Campos Personalizados$")
	public void selecionoNoMenuGerenciarCamposPersonalizados() {
		campoPersonalizadoPage.clicarNoMenuCampoPersonalizado();
	}

	@When("^informo o nome do \"([^\"]*)\"$")
	public void informo_o_nome_do(String campoPersonalizado) {
		campoPersonalizadoPage.preencherNomeCampo(campoPersonalizado);
	}

	@When("^seleciono para adicionar o campo$")
	public void seleciono_para_adicionar_o_campo() {
		campoPersonalizadoPage.adicionarCampoButton();
	}

	@Then("^confirmo a criacao do campo$")
	public void confirmo_a_criacao_do_campo() {
		campoPersonalizadoPage.confirmoCriacao();
	}

	// editar campo personalizado
	@When("^seleciono para alterar o campo$")
	public void seleciono_para_alterar_o_campo() {
		campoPersonalizadoPage.selecionarCampoEdicao();
	}

	@When("^seleciono o \"([^\"]*)\",\"([^\"]*)\"$")
	public void seleciono_o(String acessoDeLeitura, String acessoDeEscrita) {
		campoPersonalizadoPage.preenchoAcessoLeitura(acessoDeLeitura);
		campoPersonalizadoPage.preenchoAcessoEscrita(acessoDeEscrita);
	}

	@Then("^confirmo a edicao do campo$")
	public void confirmo_a_edicao_do_campo() {
		campoPersonalizadoPage.concluirEdicaoCampo();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_custom_field_update.php");
	}

	// vincular campo personalizado
	@Given("^seleciono a tarefa para vincular$")
	public void seleciono_a_tarefa_para_vincular() {
		campoPersonalizadoPage.selecionarTarefaVincular();
	}

	@When("^seleciono o projeto para vincular em \"([^\"]*)\"$")
	public void seleciono_o_projeto_para_vincular_em(String projetos) {
		campoPersonalizadoPage.vincularCampoProjeto();
	}

	@Then("^seleciono para vincular o campo personalizado$")
	public void seleciono_para_vincular_o_campo_personalizado() {
		campoPersonalizadoPage.vincularCampoBotao();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_custom_field_edit_page.php?field_id=2");
	}

	// excluir vinculo
	@When("^seleciono o campo personaliado para excluir$")
	public void seleciono_o_campo_personaliado_para_excluir() {
		campoPersonalizadoPage.selecionarCampoExcluir();
	}

	@When("^clico para apagar campo personalizado$")
	public void clico_para_apagar_campo_personalizado() {
		campoPersonalizadoPage.apagarCampoPersonalizado();
	}

	@When("^confirmo para excluir o campo$")
	public void confirmo_para_excluir_o_campo() {
		campoPersonalizadoPage.confirmarButton();
	}

	@Then("^visualizo a mensagem de sucesso$")
	public void visualizo_a_mensagem_de_sucesso() {
		campoPersonalizadoPage.visualizarMensagem();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://mantis.marcela.base2.com.br/manage_custom_field_delete.php");
	}
}
