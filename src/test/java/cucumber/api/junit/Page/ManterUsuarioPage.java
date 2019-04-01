package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ManterUsuarioPage extends PaginaInicialPage {

	public ManterUsuarioPage(WebDriver driver) {
		super(driver);
	}

	// elementos comuns
	By elementoComumGerenciar = (By.xpath("//*[contains(@class, 'menu-icon fa fa-gears')]"));
	By elementoComumGerenciarUsuarios = (By.xpath("//a[contains(@href, '/manage_user_page.php')]"));

	// elementos cenario de edicao
	By editarUsuarios = (By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=66')]"));
	By atualizarButtonUsuario = (By.xpath("//input[@value='Atualizar Usuário']"));

	// excluir perfil
	By selecionarPerfil = (By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=66')]"));
	By excluirPerfil = (By.xpath("//input[@value='Apagar Usuário']"));
	By confirmarExclusao = (By.xpath("//input[@value='Apagar Conta']"));

	// redefinir a senha
	By usuarioRedefinicaoSenha = (By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=66')]"));
	By redefinirSenhaButton = (By.xpath("//input[@value='Redefinir Senha']"));

	// representar o usuario
	By selecionarUsuarioRepresentar = (By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=66')]"));
	By representarUsuarioButton = (By.xpath("//input[@value='Representar Usuário']"));
	// By cliqueAquiProsseguir = (By.xpath("//*[contains(., 'Clique aqui para
	// prosseguir')]"));
	By cliqueAquiProsseguir = (By.xpath("//a[contains(@href, 'my_view_page.php')]"));

	// metodos comuns
	public void menuGerenciar() {
		WebElement menuGerenciarField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumGerenciar)));
		menuGerenciarField.click();
	}

	public void menuGerenciarUsuarios() {
		WebElement menuGerenciarUsuarioField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(elementoComumGerenciarUsuarios)));
		menuGerenciarUsuarioField.click();
	}

	public void editarUsuario() {
		WebElement editarUsuarioField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(editarUsuarios)));
		editarUsuarioField.click();
	}

	public void alterarNivelDeAcesso(String editarNivelAcesso) {
		Select dropdown = new Select(driver.findElement(By.id("edit-access-level")));
		dropdown.selectByVisibleText(editarNivelAcesso);
	}

	public void validarAlteracaoNivel() {
		WebElement atualizarButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarButtonUsuario)));
		atualizarButton.click();
	}

	// excluir usuario
	public void selecionarPerfilExclusao() {
		WebElement selecionarPerfilField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarPerfil)));
		selecionarPerfilField.click();
	}

	public void excluirPerfilButton() {
		WebElement excluirButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(excluirPerfil)));
		excluirButton.click();
	}

	public void confirmarAexclusao() {
		WebElement confirmaExclusaoButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(confirmarExclusao)));
		confirmaExclusaoButton.click();
	}

	// redefinir a senha
	public void selecionarPerfilRedefinir() {
		WebElement redefinirSenhaField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(usuarioRedefinicaoSenha)));
		redefinirSenhaField.click();
	}

	public void redefinirAsenha() {
		WebElement buttonRedefinirSenha = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(redefinirSenhaButton)));
		buttonRedefinirSenha.click();
	}

	// representar usuario
	public void usuarioParaRepresentar() {
		WebElement representarUsuarioField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarUsuarioRepresentar)));
		representarUsuarioField.click();
	}

	public void representarUsuarioPerfil() {
		WebElement buttonRepresentarUsuario = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(representarUsuarioButton)));
		buttonRepresentarUsuario.click();
	}

	public void confirmarRepresentar() {
		WebElement confirmaRepresentarUsuario = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(cliqueAquiProsseguir)));
		confirmaRepresentarUsuario.click();
	}
}
