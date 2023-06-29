package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class InformacoesUsuarioTest {
    private WebDriver driver;
    @Before
    public void setup() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","/Users/adrianasouza/Documents/IdeaProjects/Automacao/drivers/chromedriver");
        ///Users/adrianasouza ///Users/adriana    /Users/adrianasouza     /Users/adrianasouza/drivers
        //System.setProperty("webdriver.chrome.driver","C:\\Users]\\Adriana\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando pra a página do Taskit!
        driver.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario () {
        // Clicar no link que possui o texto "Sign in"
        driver.findElement(By.linkText("Sign in")).click();

        // Identificando formulario de "login"
        WebElement formularioSignInbox = driver.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com name "passwaord" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        driver.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class"me"
        driver.findElement(By.className("me")).click();

        //clicar em um link que possui o texto  "MORE DATA ABOUT YOU"
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //clicar no botão através do spath - //button[@data-target="addmoredata"]
        driver.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();


        //Identificar o popup onde esta o formulario de id Addmoredata
        WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));

        // na combo de name type escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // No campo de name "contact digitar +5511933333333
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999993");

        // Clicar no link de text "SAVE" que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é " Your contact has been added!"
        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
    }
    @After
    public void tearDown(){
        // Fechar o navegador
        driver.quit();
    }
}
