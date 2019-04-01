package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.GerenciarProjetosPage;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Types.Usuario;

public class GerenciarProjetosStepDefinitions {

	WebDriver driver;
	GerenciarProjetosPage gerenciarProjetosPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public GerenciarProjetosStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.gerenciarProjetosPage = new GerenciarProjetosPage(driver);
        this.loginPage = new LoginPage(driver);
    }
	
	@Given("o usuario efetuou login$")
	public void oUsuarioEfetuouLogin() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("usuario fizer o login$")
	public void oUsuarioFizerOlogin() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessar Gerenciar no Menu$")
	public void acessarGerenciarNoMenu() {
		gerenciarProjetosPage.selecionarGerenciarMenu();
	}

	@Given("^acessar Gerenciar Projetos$")
	public void acessarGerenciarProjetos() {
		gerenciarProjetosPage.selecionarGerenciarProjetosAba();
	}

	@Given("^acessar Criar novo Projeto$")
	public void acessarCriarNovoProjeto() {
		gerenciarProjetosPage.selecionarBotaoNovoProjeto();
	}

	// criar projeto
	@When("^preencher os campos a seguir \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencherOsCamposAseguir(String nomeDoProjeto, String Estado, String Visibilidade,
			String campoDescricao) {
		gerenciarProjetosPage.preencherNomeDoProjeto(nomeDoProjeto);
		gerenciarProjetosPage.selecionarEstado(Estado);
		gerenciarProjetosPage.selecionarVisibilidade(Visibilidade);
		gerenciarProjetosPage.preencherCampoDescricao(campoDescricao);
	}

	@Then("^o projeto foi criado$")
	public void oProjetoFoiCriado() {
		gerenciarProjetosPage.salvarProjetoBotao();
	}

	// Editar projeto
	@Given("^selecionar o Projeto$")
	public void selecionarOprojeto() {
		gerenciarProjetosPage.selectProjetoAtualizar();
	}

	@When("^atualizar os campos necessarios \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void atualizarOsCamposNecessarios(String nomeProjetoEdit, String Estado, String Visibilidade,
			String campoDescricaoEdit) {
		gerenciarProjetosPage.editarNomeDoProjeto(nomeProjetoEdit);
		gerenciarProjetosPage.editarEstado(Estado);
		gerenciarProjetosPage.editarVisibilidade(Visibilidade);
		gerenciarProjetosPage.editarCampoDescricao(campoDescricaoEdit);
	}

	@Then("^o sistema atualizou o projeto$")
	public void oSistemaAtualizouOprojeto() {
		gerenciarProjetosPage.atualizarOprojeto();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_proj_page.php");
	}

	// excluir projeto

	@Given("^seleciono o projeto para excluir$")
	public void selecionoOprojetoParaExcluir() {
		gerenciarProjetosPage.selecionarProjetoExcluir();
	}

	@When("^seleciono apagar o projeto$")
	public void selecionarApagarOprojeto() {
		gerenciarProjetosPage.apagarProjetoBotao();
	}

	@Then("^o sistema exclui o projeto$")
	public void oSistemaExcluiOprojeto() {
		gerenciarProjetosPage.confirmaApagaProjetoBotao();
	}

	// Cadastrar Projeto igual
	@Given("^acessar Criar novo Projeto menu$")
	public void acessar_Criar_novo_Projeto_menu() {
		gerenciarProjetosPage.criarMesmoProjeto();
	}

	@When("^preencher os campos da tela \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencherOsCamposDaTela(String nomeProjetoIgual, String estadoIgual, String visibilidadeIgual,
			String campoDescricaoIgual) {
		gerenciarProjetosPage.preencherNomeProjetoIgual(nomeProjetoIgual);
		gerenciarProjetosPage.selecionarEstadoIgual(estadoIgual);
		gerenciarProjetosPage.selecionarVisibilidadeIgual(visibilidadeIgual);
		gerenciarProjetosPage.preencherCampoDescricaoIgual(campoDescricaoIgual);
	}

	@When("^salvo o projeto igual$")
	public void salvo_o_projeto_igual() {
		gerenciarProjetosPage.salvarProjetoBotaoIgual();
	}

	@Then("^o sistema exibe a mensagem de erro$")
	public void oSistemaExibeAmensagemDeErro() {
		gerenciarProjetosPage.visualizarMensagemErro();
	}

	// adicionar usuario ao projeto
	@Given("^seleciono o projeto$")
	public void seleciono_o_projeto() {
		gerenciarProjetosPage.projetoAdicionaUsuario();
	}

	@When("^marco o \"([^\"]*)\" projeto$")
	public void informo_o_nome_de_usuario_projeto(String nomeUsuario) {
		gerenciarProjetosPage.selecionarUsuarioProjeto(nomeUsuario);
	}

	@When("^escolho o \"([^\"]*)\" projeto$")
	public void seleciono_o_nivel_De_Acesso(String nivelDeAcesso) {
		gerenciarProjetosPage.selecionarNivelUsuario(nivelDeAcesso);
	}

	@Then("^adiciono o usuario ao projeto$")
	public void adiciono_o_usuario_ao_projeto() {
		gerenciarProjetosPage.concluirAdicionarUsuario();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_proj_edit_page.php?project_id=36");

	}
}
