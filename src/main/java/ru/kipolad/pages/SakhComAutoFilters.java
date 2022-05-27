/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SakhComAutoFilters {
    private final SelenideElement carBrandFilter = $(By.xpath("//span[@data-select2-id='1']"));
    private final SelenideElement carModelFilter = $(By.xpath("//span[@data-select2-id='3']"));
    private final SelenideElement carYearFromFilter = $(By.xpath("//span[@id='select2-year_s-container']"));
    private final SelenideElement carYearBeforeFilter = $(By.xpath("//span[@id='select2-year_e-container']"));
    private final SelenideElement findButton = $(By.id("sale-filter-submit"));

    private final ElementsCollection carBrandList = $$(By.xpath("//ul[@id='select2-id_f-brand_id-results']//li"));
    private final ElementsCollection carModelsList = $$(By.xpath("//ul[@id='select2-id_f-model_id-results']//li"));
    private final ElementsCollection carYearFromList = $$(By.xpath("//ul[@id='select2-year_s-results']//li"));
    private final ElementsCollection carYearBeforeList = $$(By.xpath("//ul[@id='select2-year_e-results']//li"));
    private final ElementsCollection autoTitles = $$(By.xpath("//div[@class='sale-title desktop']//a[@class='sale-link']"));

    public SakhComAutoFilters clickToCarBrandFilter() {
        carBrandFilter.click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters clickToCarModelFilter() {
        carModelFilter.hover().click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters clickToCarYearFromFilter() {
        carYearFromFilter.click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters clickToCarYearBeforeFilter() {
        carYearBeforeFilter.click();
        return page(SakhComAutoFilters.class);
    }

    public void clickFindButton() {
        findButton.click();
    }

    public SakhComAutoFilters chooseCarBrand(String brand) {
        carBrandList.findBy(text(brand)).click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters chooseCarModel(String model) {
        carModelsList.findBy(text(model)).click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters chooseCarYearFrom(String yearFrom) {
        carYearFromList.findBy(text(yearFrom)).click();
        return page(SakhComAutoFilters.class);
    }

    public SakhComAutoFilters chooseCarYearBefore(String yearBefore) {
        carYearBeforeList.findBy(text(yearBefore)).click();
        return page(SakhComAutoFilters.class);
    }

    public void checkTheCorrectTitlesFromListOfCars(String filter) {
        boolean result = true;
        for (SelenideElement element : autoTitles) {
            if (!element.has(text(filter))) result = false;
        }
        assertTrue(result, "Not all titles contain text: " + filter);
    }

    public void checkTheCorrectTitlesFromListOfCars(String firstFilter, String secondFilter) {
        assertAll(
                () -> checkTheCorrectTitlesFromListOfCars(firstFilter),
                () -> checkTheCorrectTitlesFromListOfCars(secondFilter)
        );
    }

    public void checkTheCorrectTitlesWithAnyFilterAndYearsFromAndBefore(String firstFilter, String yearFrom, String yearBefore) {
        assertAll(
                () -> checkTheCorrectTitlesFromListOfCars(firstFilter),
                () -> assertTrue(isRightFilterForCarYears(yearFrom, yearBefore),
                        "Not all cars are between " + yearFrom + " and " + yearBefore)
        );
    }

    private boolean isRightFilterForCarYears(String yearFrom, String yearBefore) {
        int yearFromInt = Integer.parseInt(yearFrom);
        int yearBeforeInt = Integer.parseInt(yearBefore);
        boolean isRightYear = false;
        for (SelenideElement element : autoTitles) {
            isRightYear = false;
            for (int i = yearFromInt; i <= yearBeforeInt; i++) {
                if (element.getText().contains(Integer.toString(i))) {
                    isRightYear = true;
                    break;
                }
            }
            if (!isRightYear) break;
        }
        return isRightYear;
    }
}
