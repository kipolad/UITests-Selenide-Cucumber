package UITests;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.kipolad.pages.SakhComAutoFilters;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Yulya Telysheva
 */

public class CarFilterStep {
    @Given("The user is on Auto.sakh.com page")
    public void theUserIsOnAutoSakhComPage() {
        open("https://auto.sakh.com/");
    }

    @When("Click to car brand filter")
    public void clickToCarBrandFilter() {
        new SakhComAutoFilters()
                .clickToCarBrandFilter();
    }

    @And("Click to car model filter")
    public void clickToCarModelFilter() {
        new SakhComAutoFilters()
                .clickToCarModelFilter();
    }

    @And("Choose car brand {string}")
    public void chooseCarBrand(String brand) {
        new SakhComAutoFilters()
                .chooseCarBrand(brand);
    }

    @And("Choose car model {string}")
    public void chooseCarModelModel(String model) {
        new SakhComAutoFilters()
                .chooseCarModel(model);
    }

    @And("Click find")
    public void clickFind() {
        new SakhComAutoFilters()
                .clickFindButton();
    }

    @And("Click to car year from filter")
    public void clickToCarYearFromFilter() {
        new SakhComAutoFilters()
                .clickToCarYearFromFilter();
    }

    @And("Choose car year from {string}")
    public void chooseCarYearFromYearFrom(String yearFrom) {
        new SakhComAutoFilters()
                .chooseCarYearFrom(yearFrom);
    }

    @And("Click to car year before filter")
    public void clickToCarYearBeforeFilter() {
        new SakhComAutoFilters()
                .clickToCarYearBeforeFilter();
    }

    @And("Choose car year before {string}")
    public void chooseCarYearBeforeYearBefore(String yearBefore) {
        new SakhComAutoFilters()
                .chooseCarYearBefore(yearBefore);
    }

    @Then("Filters return right list of cars {string}")
    public void filtersReturnRightListOfCars(String brand) {
        new SakhComAutoFilters()
                .checkTheCorrectTitlesFromListOfCars(brand);
    }

    @Then("Filters return right list of cars {string} {string}")
    public void filtersReturnRightListOfCarsBrandModel(String brand, String model) {
        new SakhComAutoFilters()
                .checkTheCorrectTitlesFromListOfCars(brand, model);
    }

    @Then("Filters return right list of cars {string} {string} {string}")
    public void filtersReturnRightListOfCarsBrandYearFromYearBefore(String firstFilter, String yearFrom, String yearBefore) {
        new SakhComAutoFilters()
                .checkTheCorrectTitlesWithAnyFilterAndYearsFromAndBefore(firstFilter, yearFrom, yearBefore);
    }

    @After(value = "close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}
