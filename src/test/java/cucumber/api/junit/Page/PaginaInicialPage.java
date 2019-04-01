package cucumber.api.junit.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaInicialPage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public PaginaInicialPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);

	}

	public void AbrirMantis() {
		driver.manage().window().maximize();
		driver.get("http://mantis.marcela.base2.com.br");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
