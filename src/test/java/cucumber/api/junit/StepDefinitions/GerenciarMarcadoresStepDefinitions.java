package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.GerenciarMarcadoresPage;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Types.Usuario;

public class GerenciarMarcadoresStepDefinitions {

	WebDriver driver;
	GerenciarMarcadoresPage gerenciarMarcadoressPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
	public GerenciarMarcadoresStepDefinitions(SharedClass sharedClass) {
		 this.sharedClass = sharedClass;
	     this.driver = sharedClass.getDriver();
	     this.gerenciarMarcadoressPage = new GerenciarMarcadoresPage(driver);
	     this.loginPage = new LoginPage(driver);
	}


	@Given("^o usuario esta logado como administrador$")
	public void o_usuario_esta_logado_como_administrador() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^o usuario efetuou o login$")
	public void o_usuario_efetuou_o_login() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^seleciono para Gerenciar$")
	public void seleciono_para_Gerenciar() {
		gerenciarMarcadoressPage.selecionarGerenciar();
	}

	@Given("^seleciono para Gerenciar os Marcadores$")
	public void seleciono_para_Gerenciar_os_Marcadores() {
		gerenciarMarcadoressPage.selecionarGerenciarMarcadoresMenu();
	}

	@When("^informo o \"([^\"]*)\",\"([^\"]*)\"$")
	public void informo_o(String nomeDoMarcador, String descricaoDoMarcador) {
		gerenciarMarcadoressPage.preencherNomedoMarcador(nomeDoMarcador);
		gerenciarMarcadoressPage.preencherDescricaoDoMarcador(descricaoDoMarcador);
	}

	@Then("^confirmo a criacao do marcador$")
	public void confirmo_a_criacao_do_marcador() {
		gerenciarMarcadoressPage.criarGerenciarMarcador();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_tags_page.php");
	}

//editar marcador
	@Given("^seleciono o marcador$")
	public void seleciono_o_marcador() {
		gerenciarMarcadoressPage.selecionarMarcadorCriado();
	}

	@When("^seleciono para atualizar o marcador$")
	public void seleciono_para_atualizar_o_marcador() {
		gerenciarMarcadoressPage.buttonAtualizarMarcador();
	}

	@When("^atualizo o \"([^\"]*)\"$")
	public void atualizo_a(String criadorDoMarcador) {
		gerenciarMarcadoressPage.alterarCriadorMarcador(criadorDoMarcador);
	}

	@When("^seleciono para concluir a atualizacao$")
	public void seleciono_para_concluir_a_atualizacao() {
		gerenciarMarcadoressPage.concluirAtualizacao();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/tag_view_page.php?tag_id=12");
	}

//excluir marcador
	@Given("^seleciono o marcador para excluir$")
	public void seleciono_o_marcador_para_excluir() {
		gerenciarMarcadoressPage.selecionarMarcadorExcluir();
	}

	@When("^seleciono para excluir$")
	public void seleciono_para_excluir() {
		gerenciarMarcadoressPage.botaoExcluir();
	}

	@Then("^confirmo a exclusao$")
	public void confirmo_a_exclusao() {
		gerenciarMarcadoressPage.confirmarExclusao();
	}

	@Then("^valido a exclusao do marcador$")
	public void valido_a_exclusao_do_marcador() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_tags_page.php");
	}

//visualizar tarefas
	@Given("^seleciono o marcador original$")
	public void seleciono_o_marcador_original() {
		gerenciarMarcadoressPage.selecionarMarcadorTarefas();
	}

	@When("^seleciono para visualizar as tarefas$")
	public void seleciono_para_visualizar_as_tarefas() {
		gerenciarMarcadoressPage.selecionarTarefasRelacionadas();
	}

	@Then("^confirmo a visualizacao das tarefas relacionadas$")
	public void confirmo_a_visualizacao_das_tarefas_relacionadas() {
		gerenciarMarcadoressPage.validarListaTarefas();

	}

}
