package co.com.choucair.utestChallenge.tasks;

import co.com.choucair.utestChallenge.userinterface.SecondStepPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

public class FullStep2 implements Task {

    private final String cityName;
    private final String zipCode;
    private final String countryName;

    public FullStep2(String cityName, String zipCode, String countryName) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.countryName = countryName;
    }

    public static FullStep2 complete(String cityName, String zipCode, String countryName) {
        return Tasks.instrumented(FullStep2.class, cityName, zipCode, countryName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(cityName).into(SecondStepPage.INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN).into(SecondStepPage.INPUT_CITY),
                Hit.the(Keys.ENTER).into(SecondStepPage.INPUT_CITY),
                Enter.theValue(zipCode).into(SecondStepPage.INPUT_ZIP),
                Click.on(SecondStepPage.DIV_COUNTRY),
                Enter.theValue(countryName).into(SecondStepPage.INPUT_COUNTRY),
                Click.on(SecondStepPage.BUTTON_SUBMIT)
        );
    }
}
