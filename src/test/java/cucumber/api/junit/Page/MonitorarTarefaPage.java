package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MonitorarTarefaPage extends PaginaInicialPage {

	public MonitorarTarefaPage(WebDriver driver) {
		super(driver);

	}

	By comumVerTarefa = (By.xpath("//a[contains(@href, 'view_all_bug_page.php')]"));
	By tarefaMonitorada = (By.xpath("//a[contains(@href, 'view.php?id=27')]"));
	By monitorarButton = (By.xpath("//input[@value='Monitorar']"));

	// alterar o relator
	By selectTarefaAtualizar = (By.xpath("//a[contains(@href, 'view.php?id=27')]"));
	By atualizarTarefaButton = (By.xpath("//input[@value='Atualizar']"));
	By alterarRelator = (By.xpath("//a[contains(@href, '#reporter_edit')]"));
	By selecionarRelator = By.id("reporter_id");
	By atualizarButtonRelator = (By.xpath("//input[@value='Atualizar Informação']"));

	// parar monitoramento
	By tarefaMonitoramento = (By.xpath("//a[contains(@href, 'view.php?id=27')]"));
	By pararMonitoramentoButton = (By.xpath("//input[@value='Parar de Monitorar']"));

	// pesquisar usuario monitorado por
	By linkMonitoradoPor = By.id("user_monitor_filter");
	By visualizarTarefaPesquisada = (By.xpath("//*[contains(., '1 - 1 / 1')]"));
	By aplicarFiltroButton = (By.xpath("//input[@value='Aplicar Filtro']"));

	// redefinir filtro
	By redefinirFiltroButton = (By.xpath("//*[@id='filter-queries-form']/select]"));  
	By checarFiltroTodos = (By.xpath("//*[contains(., '1 - 16 / 16')]"));

	public void selecionarVerTarefas() {
		WebElement menuVerTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumVerTarefa)));
		menuVerTarefa.click();
	}

	public void selecionaTarefa() {
		WebElement selecionarTarefaLista = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaMonitorada)));
		selecionarTarefaLista.click();
	}

	public void selecionarMonitoramentoButton() {
		WebElement botaoMonitorar = wait.until(ExpectedConditions.visibilityOf(driver.findElement(monitorarButton)));
		botaoMonitorar.click();
	}

	public void retornarVerTarefas() {
		WebElement returnVerTarefas = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumVerTarefa)));
		returnVerTarefas.click();
	}

	// Alterar o relator

	public void selecioneiTarefa() {
		WebElement selecioneiAtarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selectTarefaAtualizar)));
		selecioneiAtarefa.click();
	}

	public void atualizarAtarefa() {
		WebElement atualizarTarefa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarTarefaButton)));
		atualizarTarefa.click();
	}

	public void alterarLink() {
		WebElement alterarLink = wait.until(ExpectedConditions.visibilityOf(driver.findElement(alterarRelator)));
		alterarLink.click();
	}

	public void alteroOrelator(String alteraRelator) {
		WebElement relatorTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarRelator)));
		relatorTarefa.click();
	}

	public void atualizarRelator() {
		WebElement finalizarAtualizacao = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(atualizarButtonRelator)));
		finalizarAtualizacao.click();
	}

	// parar de monitorar tarefa
	public void entrarMenuVerTarefa() {
		WebElement menuVerTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumVerTarefa)));
		menuVerTarefa.click();
	}

	public void clicoTarefaPararMonitorar() {
		WebElement tarefaPararMonitorar = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(tarefaMonitoramento)));
		tarefaPararMonitorar.click();
	}

	public void clicoPararMonitorar() {
		WebElement monitoramentoPararButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(pararMonitoramentoButton)));
		monitoramentoPararButton.click();
	}

	// pesquisar o usuario monitorando
	public void visualizoTarefas() {
		WebElement visualizoTarefasMenu = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(comumVerTarefa)));
		visualizoTarefasMenu.click();
	}

	public void clicaLinkMonitoradoPor() {
		WebElement linkSelecionaUsuario = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(linkMonitoradoPor)));
		linkSelecionaUsuario.click();
	}

	public void selectUsuario(String usuarioMonitoradoPor) {
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='user_monitor_filter_target']/select")));
		dropdown.selectByVisibleText(usuarioMonitoradoPor);
	}

	public void aplicarOfiltro() {
		WebElement aplicarFiltroPesquisa = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(aplicarFiltroButton)));
		aplicarFiltroPesquisa.click();
	}

	public void confirmarTarefa() {
		WebElement confirmarTarefas = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(visualizarTarefaPesquisada)));
		confirmarTarefas.getText();
	}

	// redefinir filtro
	public void verTarefasRedefinicao() {
		WebElement verTarefa = wait.until(ExpectedConditions.visibilityOf(driver.findElement(comumVerTarefa)));
		verTarefa.click();
	}

	public void redefinirFiltro(String redefinirFiltro) {
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='filter-queries-form']/select")));
		dropdown.selectByVisibleText(redefinirFiltro);
	}

	public void checarFiltrolimpo() {
		WebElement checarFiltro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(checarFiltroTodos)));
		checarFiltro.getText();
	}
}
