import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.InputStream;

public class TaskTest {
    private WebDriver webDriver;
    WebElement element;

    @Before
    public void driver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://savkk.github.io/selenium-practice/");
        Thread.sleep(2000);
    }


    public void click() {
        element = webDriver.findElement(By.xpath("//*[@id=\"back\"]/a"));
        element.click();
    }

    public void firstTask() throws InterruptedException {
        element = webDriver.findElement(By.xpath("//*[@id=\"button\"]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"first\"]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"content\"]/input"));
        element.click();
        Thread.sleep(2000);
        String firstTask = webDriver.findElement(By.xpath("//*[@id=\"back\"]/a")).getText();
        Assert.assertTrue(firstTask.contains("Great! Return to menu"));
        click();
    }

    public void secondTask() throws InterruptedException {
        element = webDriver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"two\"]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"go\"]"));
        element.click();
        Thread.sleep(2000);
        String secondTask = webDriver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertTrue(secondTask.contains("two"));
        element = webDriver.findElement(By.xpath("//*[@id=\"content\"]/label[5]/span"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"radio_go\"]"));
        element.click();
        Thread.sleep(2000);
        secondTask = webDriver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertTrue(secondTask.contains("two"));
        click();
    }

    public void thirdTask() throws InterruptedException {
        element = webDriver.findElement(By.xpath("//*[@id=\"select\"]"));
        element.click();
        Select content = new Select(webDriver.findElement(By.name("hero")));
        content.selectByVisibleText("Alan Mathison Turing");
        content = new Select(webDriver.findElement(By.name("languages")));
        content.selectByVisibleText("Java");
        content.selectByIndex(1);
        element = webDriver.findElement(By.xpath("//*[@id=\"go\"]"));
        element.click();
        Thread.sleep(2000);
        String thirdTask = webDriver.findElement(By.xpath(" //*[@id=\"content\"]/label[2]")).getText();
        Assert.assertTrue(thirdTask.contains("Alan Mathison Turing"));
        thirdTask = webDriver.findElement(By.xpath("//*[@id=\"content\"]/label[4]")).getText();
        Assert.assertTrue(thirdTask.contains("Java, Python"));
        click();
    }

    public void fourthTask() throws InterruptedException {
        element = webDriver.findElement(By.xpath("//*[@id=\"form\"]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[1]/input"));
        element.sendKeys("jkhkh");
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[2]/input"));
        element.sendKeys("dvf");
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[3]/input"));
        element.sendKeys("ok@kl.ru");
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[4]/input[2]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[5]/input"));
        element.sendKeys("jkhkhghghgh");
        InputStream in = TaskTest.class.getResourceAsStream("/poems/Frost.txt");
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[6]/input"));
        File file = new File("src/test/resources/file/cat.jpg");
        element.sendKeys(file.getAbsolutePath());
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[7]"));
        element.click();
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/div[7]/textarea"));
        element.sendKeys("khfkshk");
        element = webDriver.findElement(By.xpath("//*[@id=\"testform\"]/input"));
        element.click();
        Thread.sleep(2000);
        String fourthTask = webDriver.findElement(By.xpath("//*[@id=\"back\"]/a")).getText();
        Assert.assertTrue(fourthTask.contains("Great! Return to menu"));
        click();
    }

    @Test
    public void test1() throws InterruptedException {
        firstTask();
    }

    @Test
    public void test2() throws InterruptedException {
        secondTask();
    }

    @Test
    public void test3() throws InterruptedException {
        thirdTask();

    }

    @Test
    public void test4() throws InterruptedException {
        fourthTask();
    }


    @After
    public void close() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
