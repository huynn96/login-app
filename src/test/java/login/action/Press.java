package login.action;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Press implements Interaction {

    private static final Map<Integer, AndroidKey> KEYS_MAP = Arrays.stream(AndroidKey.values())
            .collect(Collectors.toMap(AndroidKey::getCode, key -> key));
    private final AndroidKey key;

    public Press(AndroidKey key) {
        this.key = key;
    }

    @Override
    @Step("{0} press on the key #key")
    public <T extends Actor> void performAs(T actor) {
        WebDriver facade = BrowseTheWeb.as(actor).getDriver();
        WebDriver driver = ((WebDriverFacade)facade).getProxiedDriver();
        ((AndroidDriver)driver).pressKey(new KeyEvent(key));
    }

    public static Interaction key(AndroidKey key) {
        return instrumented(Press.class, key);
    }

    public static Interaction key(int keyCode) {
        return key(KEYS_MAP.get(keyCode));
    }
}
