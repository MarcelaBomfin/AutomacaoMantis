package cucumber.api.junit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MinhaVisaoPage extends PaginaInicialPage {

	public MinhaVisaoPage(WebDriver driver) {
		super(driver);
	}

	By minhaVisao = (By.xpath("//*[@class=\"menu-icon fa fa-dashboard\"]"));
	By escreverAnotacao = By.id("bugnote_text");
	By anotacaoButton = (By.xpath("//input[@value='Adicionar Anotação']"));

	// mover tarefa
	By selecionarTarefa = (By.xpath("//a[contains(@href, 'view.php?id=31')]"));
	By buttonMoverTarefa = (By.xpath("//input[@value='Mover']"));
	By moverTarefas = (By.xpath("//input[@value='Mover Tarefas']"));

	
	public void selecionarMinhaVisao() {
		WebElement minhaVisaoField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(minhaVisao)));
		minhaVisaoField.click();
	}

	public void selecionarAtarefa() {
		WebElement tarefaFiltroField = wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefa)));
		tarefaFiltroField.click();
	}

	public void escreverAnotacao(String Anotacao) {
		WebElement adicionarAnotacaoField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(escreverAnotacao)));
		adicionarAnotacaoField.sendKeys(Anotacao);
	}

	public void concluirAnotacaoButton() {
		WebElement adicionarAnotacaoField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(anotacaoButton)));
		adicionarAnotacaoField.click();
	}

	// mover tarefa
	public void tarefaMover() {
		WebElement selecionarTarefaMoverField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(selecionarTarefa)));
		selecionarTarefaMoverField.click();
	}

	public void moverTarefaProjeto() {
		WebElement moverButtonField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(buttonMoverTarefa)));
		moverButtonField.click();
	}

	public void alterarProjetoTarefa(String moverTarefasPara) {
		Select dropdown = new Select(driver.findElement(
				By.xpath("//*[@id='action-group-div']/form/div/div[2]/div[1]/div/table/tbody/tr[1]/td/select")));
		dropdown.selectByVisibleText(moverTarefasPara);
	}

	public void moverButton() {
		WebElement moverTarefasButtonField = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(moverTarefas)));
		moverTarefasButtonField.click();
	}

}
