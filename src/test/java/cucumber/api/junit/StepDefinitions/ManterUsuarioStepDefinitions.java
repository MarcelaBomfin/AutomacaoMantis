package cucumber.api.junit.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Enum.PerfilUsuario;
import cucumber.api.junit.Hooks.SharedClass;
import cucumber.api.junit.Page.LoginPage;
import cucumber.api.junit.Page.ManterUsuarioPage;
import cucumber.api.junit.Types.Usuario;

public class ManterUsuarioStepDefinitions {

	WebDriver driver;
	ManterUsuarioPage manterUsuarioPage;
	LoginPage loginPage;
	Usuario usuario;
	SharedClass sharedClass;
	
    public ManterUsuarioStepDefinitions(SharedClass sharedClass){
        this.sharedClass = sharedClass;
        this.driver = sharedClass.getDriver();
        this.manterUsuarioPage = new ManterUsuarioPage(driver);
        this.loginPage = new LoginPage(driver);
    }

	

	@Given("^o usuario abriu a pagina do mantis$")
	public void o_usuario_abriu_a_pagina_do_mantis() {
		usuario = new Usuario(PerfilUsuario.ADMINISTRATOR);
		loginPage.AbrirPagina();
	}

	@Given("^usuario logou no mantis$")
	public void usuario_logou_no_mantis() {
		loginPage.preencherUsuario(usuario.getUsuario());
		loginPage.clicarEntrarUsuario();
		loginPage.preencherSenha(usuario.getSenha());
		loginPage.clicarEntrarUsuario();
	}

	@Given("^acessar Gerenciar no menu$")
	public void acessar_Gerenciar_no_menu() {
		manterUsuarioPage.menuGerenciar();
	}

	@Given("^acessar menu Gerenciar Usuarios$")
	public void acessar_menu_Gerenciar_Usuarios() {
		manterUsuarioPage.menuGerenciarUsuarios();
	}

	// editar o usuario
	@Given("^selecionar o Nome de Usuario$")
	public void selecionar_o_Nome_de_Usuario() {
		manterUsuarioPage.editarUsuario();
	}

	@When("^atualizar o \"([^\"]*)\"$")
	public void atualizar_o(String editarNivelAcesso) {
		manterUsuarioPage.alterarNivelDeAcesso(editarNivelAcesso);
	}

	@Then("^o sistema atualizou o usuario$")
	public void o_sistema_atualizou_o_usuario() {
		manterUsuarioPage.validarAlteracaoNivel();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_user_update.php");

	}

	// excluir usuario
	@When("^selecionar o usuario para excluir$")
	public void selecionar_o_usuario_para_excluir() {
		manterUsuarioPage.selecionarPerfilExclusao();
	}

	@Then("^confirmar a exclusao do usuario$")
	public void confirmar_a_exclusao_do_usuario() {
		manterUsuarioPage.excluirPerfilButton();
	}

	@Then("^o sistema exibe a mensagem confirmando$")
	public void o_sistema_exibe_a_mensagem_confirmando() {
		manterUsuarioPage.confirmarAexclusao();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_user_delete.php");
	}

	// redefinir a senha
	@Given("^seleciono o Usuario$")
	public void seleciono_o_Usuario() {
		manterUsuarioPage.selecionarPerfilRedefinir();
	}

	@When("^seleciono para redefinir a senha$")
	public void seleciono_para_redefinir_a_senha() {
		manterUsuarioPage.redefinirAsenha();
	}

	@Then("^o sistema orienta sobre a redefinicao$")
	public void o_sistema_orienta_sobre_a_redefinicao() {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/manage_user_reset.php");

		// String textoElement = driver.findElement(By.xpath("//*[contains(., 'Uma
		// solicitação de confirmação foi enviada ao endereço de e-mail do usuário
		// selecionado.Através deste, o usuário será capaz de alterar sua
		// senha.')]")).getText();
		// assertEquals("texto-esperado", textoElement);
	}

	// representar usuario
	@Given("^selecionar o Usuario para representar$")
	public void selecionar_o_Usuario_para_representar() {
		manterUsuarioPage.usuarioParaRepresentar();
	}

	@When("^seleciono para representar o usuario$")
	public void seleciono_para_representar_o_usuario() {
		manterUsuarioPage.representarUsuarioPerfil();
	}

	@Then("^o sistema solicita a confirmacao$")
	public void o_sistema_solicita_a_confirmacao() {
		manterUsuarioPage.confirmarRepresentar();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://mantis.marcela.base2.com.br/my_view_page.php");
	}
}
