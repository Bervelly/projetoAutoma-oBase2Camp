package com.base2Desafio.tests;

import com.base2Desafio.bases.TestBase;
import com.base2Desafio.pages.*;
import com.base2Desafio.utils.DriverUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTests extends TestBase {
    //Objects
    HomePage homePage;
    ReportIssuePage reportIssuePage;
    ViewIssuesPage viewIssuesPage;

    //Tests
    @Test
    public void createReport() {

        //Selecionando a opção de criar ocorrência
        homePage = new HomePage();
        homePage.clickReportIssue();
        String summary = "Treinamento base"+ RandomStringUtils.randomNumeric(2);

        //Preenchendo campos de criar ocorrência
        reportIssuePage = new ReportIssuePage();
        reportIssuePage.clickCategory();
        reportIssuePage.selectCategoryOptions("[All Projects] a");
        reportIssuePage.clickReproducibility();
        reportIssuePage.selectReproducibilityOptions("always");
        reportIssuePage.clickSeverity();
        reportIssuePage.selectSeverityOptions("feature");
        reportIssuePage.clickSelectAssign();
        reportIssuePage.chooseAssign("bervelly.nobrega");
        reportIssuePage.fillSummary(summary);
        reportIssuePage.fillDescription("descrevendo o teste");
        reportIssuePage.clickReport();

        // Verificando ocorrências criadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.selectFilter();
        viewIssuesPage.fieldFillSearch(summary);
        Assert.assertEquals(summary, DriverUtils.DRIVER.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")).getText());


    }

    @Test
    public void invalidCreateReport() {

        homePage = new HomePage();
        homePage.clickReportIssue();
        reportIssuePage = new ReportIssuePage();
        reportIssuePage.clickCategory();
        reportIssuePage.selectCategoryOptions("[All Projects] a");
        reportIssuePage.clickReproducibility();
        reportIssuePage.selectReproducibilityOptions("always");
        reportIssuePage.clickSeverity();
        reportIssuePage.selectSeverityOptions("feature");
        reportIssuePage.clickSelectAssign();
        reportIssuePage.chooseAssign("bervelly.nobrega");
        reportIssuePage.fillDescription("descrevendo o teste");
        reportIssuePage.clickReport();
        Assert.assertEquals("APPLICATION ERROR #11",DriverUtils.DRIVER.findElement(By.className("form-title")).getText());

    }

    @Test
    public void editReport() {
        String summary = "Treinamento base"+ RandomStringUtils.randomNumeric(2);

        // Editar ocorrências
        viewIssuesPage = new ViewIssuesPage();
        homePage = new HomePage();
        homePage.clickViewIssues();
        viewIssuesPage.editReport();
        DriverUtils.DRIVER.findElement(By.name("summary")).clear();
        viewIssuesPage.editNewSummary(summary);
        viewIssuesPage.clickEdit();

        // Verificando ocorrências editadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.selectFilter();
        viewIssuesPage.fieldFillSearch(summary);
        Assert.assertEquals(summary, DriverUtils.DRIVER.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")).getText());
    }

    @Test
    public void deleteReport() {

        // Excluir ocorrências
        viewIssuesPage = new ViewIssuesPage();
        homePage = new HomePage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.clickDelete();
        viewIssuesPage.clickSelectDelete("Delete");
        viewIssuesPage.selectOk();
        viewIssuesPage.clickDeleteIssue();

    }

    @Test
    public void resolveReport() {

        // Resolver ocorrência
        viewIssuesPage = new ViewIssuesPage();
        homePage = new HomePage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.clickDelete();
        viewIssuesPage.checkResolve("Resolve");
        viewIssuesPage.selectOk();
        viewIssuesPage.selectChooseResolve("not fixable");
        viewIssuesPage.buttonResolveIssue();

    }
}
