package login.features.login;

import login.abilities.Authenticate;
import login.questions.MessageResult;
import login.tasks.LoginApp;
import login.ui.LoginForm;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class LoginAppStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser))
            .can(Objects.requireNonNull(Authenticate.LoadTestData(anna.getName())));;
    }

    @Test
    public void login_app_should_success() {

        when(anna).attemptsTo(
                LoginApp.Login(
                        anna.abilityTo(Authenticate.class).getEmail(),
                        anna.abilityTo(Authenticate.class).getPassword()
                )
        );

        then(anna).should(eventually(seeThat(MessageResult.of(LoginForm.MESSAGE), containsString("Do you want to enable quick login with biometrics?"))));

    }
}