
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;



public class SliderTest extends TestCase {

  @Test
    public void moveSliderTest() throws InterruptedException {
        driver.get("http://demoqa.com/slider/");
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.moveSlider(4);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        String str =js.executeScript("return document.getElementById('amount1').value").toString();
        System.out.println(str);
        Assert.assertEquals(str,Integer.toString(sliderPage.getQuantity()));




    }
}
