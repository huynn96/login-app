package login.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {
    public static Target LOGIN_BTN = Target.the("login button")
            .locatedBy("//*[@text=\"Log in\"]");
    public static Target EMAIL_FIELD = Target.the("email field")
            .located(By.className("android.widget.EditText"));
    public static Target FIRST_ELE = Target.the("first element password")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));
    public static Target MESSAGE = Target.the("message popup")
            .located(By.id("android:id/message"));

}
