package com.base2Desafio.tests;

import com.base2Desafio.bases.PageBase;
import com.base2Desafio.bases.TestBase;
import com.base2Desafio.pages.*;
import com.base2Desafio.utils.DriverUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class MantisTests extends TestBase {
    //Objects
    private HomePage homePage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuesPage viewIssuesPage;
    private PageBase page;
    private DeletePage deletePage;
    private ResolveIssuesPage resolveIssuesPage;
    private String summaryEdited = "Treinamento base"+ RandomStringUtils.randomNumeric(2);


    @Before
    public void start(){
        homePage = new HomePage();
        page = new PageBase();
    }

    //Tests
    @Test
    public void test_createReporter() {

        //Selecionando a opção de criar ocorrência
        String summary = "Treinamento base"+ RandomStringUtils.randomNumeric(2);
        homePage.clickReportIssue();


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
        viewIssuesPage.fieldFillSearch(summary);
        viewIssuesPage.applyFilter();
        Assert.assertEquals(summary, page.getText(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")));


    }

    @Test
    public void test_invalidCreateReport() {
        // Criando ocorrência inválida
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
        Assert.assertEquals("APPLICATION ERROR #11",page.getText(By.className("form-title")));

    }

    @Test
    public void test_editReport() {


        // Editar ocorrências
        viewIssuesPage = new ViewIssuesPage();
        homePage.clickViewIssues();
        viewIssuesPage.editReport();
        DriverUtils.DRIVER.findElement(By.name("summary")).clear();
        viewIssuesPage.editNewSummary(summaryEdited);
        viewIssuesPage.clickEdit();

        // Verificando ocorrências editadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.fieldFillSearch(summaryEdited);
        viewIssuesPage.applyFilter();
        Assert.assertEquals(summaryEdited, page.getText(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")));
    }

    @Test
    public void test_deleteReport() {

        // Excluir ocorrências
        viewIssuesPage = new ViewIssuesPage();
        deletePage = new DeletePage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.applyFilter();
        viewIssuesPage.clickCheckBox();
        viewIssuesPage.clickSelectDelete("Delete");
        viewIssuesPage.selectOk();
        String name = deletePage.getName();
        deletePage.clickDeleteIssue();

        // Verificando ocorrências deletadas
        viewIssuesPage.fieldFillSearch(name);
        viewIssuesPage.applyFilter();
        Assert.assertEquals(0, viewIssuesPage.getListSize());

    }

    @Test
    public void test_resolveReport() {

        // Resolver ocorrência

        viewIssuesPage = new ViewIssuesPage();
        resolveIssuesPage = new ResolveIssuesPage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.applyFilter();
        viewIssuesPage.clickCheckBox();
        viewIssuesPage.checkResolve("Resolve");
        viewIssuesPage.selectOk();
        resolveIssuesPage.selectChooseResolve("not fixable");
        String name_resolve = resolveIssuesPage.getNameResolve();
        resolveIssuesPage.buttonResolveIssue();

        // Verificando ocorrências resolvidas
        viewIssuesPage.fieldFillSearch(name_resolve);
        viewIssuesPage.applyFilter();
        Assert.assertEquals(1, viewIssuesPage.getListSize());
        }


    }

