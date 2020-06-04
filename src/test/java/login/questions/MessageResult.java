package login.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageResult implements Question<String> {
    private Target resultTarget;
    private int items;

    public MessageResult(Target target) {
        this.resultTarget = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(this.resultTarget)
                .viewedBy(actor).asString();
    }

    public static MessageResult of(Target target) {
        return new MessageResult(target);
    }
}
