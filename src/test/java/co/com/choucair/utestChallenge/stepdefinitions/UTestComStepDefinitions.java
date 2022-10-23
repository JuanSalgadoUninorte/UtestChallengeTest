package co.com.choucair.utestChallenge.stepdefinitions;

import co.com.choucair.utestChallenge.model.DataFirstStep;
import co.com.choucair.utestChallenge.model.DataFourthStep;
import co.com.choucair.utestChallenge.model.DataSecondStep;
import co.com.choucair.utestChallenge.model.DataThirdStep;
import co.com.choucair.utestChallenge.questions.Answer;
import co.com.choucair.utestChallenge.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class UTestComStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Than Juan want to register himself on the website$")
    public void thanJuanWantToRegisterHimselfOnTheWebsite() {
        OnStage.theActorCalled("Juan").wasAbleTo(OpenUp.thePage());
    }

    @When("^He complete the first part of the registry$")
    public void heCompleteTheFirstPartOfTheRegistry(List<DataFirstStep> dataFirstStep) {
        OnStage.theActorInTheSpotlight().attemptsTo(FullStep1.complete(dataFirstStep.get(0).getFirstName(),
                dataFirstStep.get(0).getLastName(),
                dataFirstStep.get(0).getEmailAddress(),
                dataFirstStep.get(0).getBirthMonth(),
                dataFirstStep.get(0).getBirthDay(),
                dataFirstStep.get(0).getBirthYear(),
                dataFirstStep.get(0).getLanguages()));
    }

    @When("^He complete the second part$")
    public void heCompleteTheSecondPart(List<DataSecondStep> dataSecondStep) {
        OnStage.theActorInTheSpotlight().attemptsTo((FullStep2.complete(dataSecondStep.get(0).getCity(),
                dataSecondStep.get(0).getZip(),
                dataSecondStep.get(0).getCountry())));
    }

    @When("^He complete the third part$")
    public void heCompleteTheThirdPart(List<DataThirdStep> dataThirdStep) {
        OnStage.theActorInTheSpotlight().attemptsTo((FullStep3.complete(dataThirdStep.get(0).getOsComputer(),
                dataThirdStep.get(0).getVersionOSComputer(),
                dataThirdStep.get(0).getLanguageOSComputer(),
                dataThirdStep.get(0).getBrandMobile(),
                dataThirdStep.get(0).getModelMobile(),
                dataThirdStep.get(0).getOsMobile())));
    }

    @When("^He complete the fourth part$")
    public void heCompleteTheFourthPart(List<DataFourthStep> dataFourthSteps) {
        OnStage.theActorInTheSpotlight().attemptsTo((FullStep4.complete(dataFourthSteps.get(0).getPassword(),
                dataFourthSteps.get(0).getConfirmPassword())));
    }

    @Then("^He can see the welcome message on the website$")
    public void heCanSeeTheWelcomeMessageOnTheWebsite() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe()));
    }

}
