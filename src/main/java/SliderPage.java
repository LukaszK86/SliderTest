import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SliderPage {

    private int quantity;

    @FindBy(how = How.XPATH, using = "//*[@id='slider-range-max']/span")
    WebElement slider;

    @FindBy(how = How.CSS, using = "input[id='amount1']")
    WebElement valueOfSlider;


    public void moveSlider(int quantity) {
        this.quantity = quantity;
        int liczba = Integer.parseInt(valueOfSlider.getAttribute("value"));
        if (liczba!=quantity){
            if (liczba < quantity) {
                for (int i = 0; i < quantity-liczba; i++)
                    slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                for (int i = 0; i <= (liczba - quantity); i++)
                    slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void getSliderValue() throws InterruptedException {
        System.out.println(valueOfSlider.getAttribute("value"));
    }

}
