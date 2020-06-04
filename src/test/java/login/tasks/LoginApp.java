package login.tasks;

import io.appium.java_client.android.nativekey.AndroidKey;
import login.action.Press;
import login.ui.LoginForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Base64;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LoginApp implements Task {
    private String username;
    private String password;
    protected LoginApp(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static LoginApp Login(String username, String password) {
        return instrumented(LoginApp.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginForm.LOGIN_BTN, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LoginForm.LOGIN_BTN),
                WaitUntil.the(LoginForm.EMAIL_FIELD, isClickable()),
                Click.on(LoginForm.EMAIL_FIELD),
                Enter.theValue(username).into(LoginForm.EMAIL_FIELD),
                Press.key(AndroidKey.SPACE),
                Click.on(LoginForm.FIRST_ELE)
        );
        for (char ch: password.toCharArray()) {
            switch (ch) {
                case '0':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_0)
                    );
                    break;
                case '1':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_1)
                    );
                    break;
                case '2':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_2)
                    );
                    break;
                case '3':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_3)
                    );
                    break;
                case '4':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_4)
                    );
                    break;
                case '5':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_5)
                    );
                    break;
                case '6':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_6)
                    );
                    break;
                case '7':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_7)
                    );
                    break;
                case '8':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_8)
                    );
                    break;
                case '9':
                    actor.attemptsTo(
                            Press.key(AndroidKey.DIGIT_9)
                    );
                    break;
                default:
                    break;
            }
        }
    }
}
