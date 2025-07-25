package pim.automation.framework;

/************************************************
TC 02 - Updating BSA PIE record which is in  "BSA PIE Pending UseCase Approval" Workflow.
Description - This approves BSA PIE Pending UseCase Approval the record
************************************************/
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common_functions.BaseTest;
import common_functions.Utils;
import pages.DigitalAsset;
import pages.HomePage;
import pages.Login_Page;
import pages.SearchPage2;
import pages.SummaryPage;

public class TC_005_BSAPIE_Pending_UseCase_Approval extends BaseTest {
	public ExtentTest test;

	@Test(groups = {"BSAPIEowner" })
	public void BSAPIEOwner() throws InterruptedException, IOException {
		String className = this.getClass().getSimpleName();
		System.out.println(className);
		test = BaseTest.extentreport.createTest(className);
		test.assignAuthor(System.getProperty("user.name")).assignCategory("Regression").assignDevice(System.getenv("COMPUTERNAME"));

		homePage = new HomePage(driver);
		Login_Page loginPage = new Login_Page(driver);
		SearchPage2 searchPage = new SearchPage2(driver);
		SummaryPage summaryPage = new SummaryPage(driver);
		DigitalAsset digitalssetPage = new DigitalAsset(driver);

		utils.waitForElement(() -> homePage.sellablematerialtabelement(), "clickable");
		test.pass("Home Page is displayed");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		utils.waitForElement(() -> homePage.BSAPIEUsecaseApprovalTab(), "visible");

		/**********************************
		 * Enter the Material ID which has all the attributes completed
		 **********************************/
		homePage.clickSearch_Products_Button().click();
		Thread.sleep(5000);

		utils.waitForElement(() -> searchPage.getgrid(), "clickable");

		String Materialdata = Login_Page.getProperty("BSAPendingUsecaseApproval_Matid");
		searchPage.searchthingdomain_Input_Mat_Id().click();
		searchPage.searchthingdomain_Input_Mat_Id().clear();
		searchPage.searchthingdomain_Input_Mat_Id().sendKeys(Materialdata);
		test.pass("Material id " + Materialdata + " is searched in Search thing domain");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		searchPage.searchthingdomain_Input_Mat_Id().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		/**************************************************
		 * --------- Get Row count------- *
		 ********************************************************/
		Actions actions = new Actions(driver);
		WebElement rowsredefined = driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_search-thing_']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-discovery-component-']")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchDiscoveryGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entityGrid")).getShadowRoot()
				.findElement(By.cssSelector("#pebbleGridContainer > pebble-grid")).getShadowRoot()
				.findElement(By.cssSelector("#grid"));

		utils.waitForElement(() -> searchPage.getgrid(), "clickable");

		List<WebElement> arrrowsdefined = rowsredefined.getShadowRoot().findElements(By.cssSelector(
				"#lit-grid > div > div.ag-root-wrapper-body.ag-layout-normal.ag-focus-managed > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-body-viewport.ag-layout-normal.ag-row-no-animation > div.ag-center-cols-clipper > div > div > div"));

		System.out.println("Total rows after clicking on Pending Usecase Approval - BSA PIE Inprogress status -- " + arrrowsdefined.size());
		test.pass("Rows after after clicking on Pending Usecase Approval - BSA PIE Inprogress status appeared");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		assertTrue("There should be results after applying filters with Inprogress status", arrrowsdefined.size() > 0);

		WebElement RowByRow = arrrowsdefined.get(0);
		String SellableMaterialDescription = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialdescription']")).getText();
		String matid = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialid']")).getText();
		System.out.println("Material ID -- " + matid + " Material Description --" + SellableMaterialDescription);

		/*************************************************
		 * --------- Click on the materialid from the result------- *
		 ************************************************/
		WebElement matidElement = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialid']"));
		actions.moveToElement(RowByRow).build().perform();
		Thread.sleep(2000);
		matidElement.click();
		Thread.sleep(3000);
		utils.waitForElement(() -> summaryPage.Things_INeedToFix(), "visible");
		test.pass("Material ID -- " + matid + " Material Description --" + SellableMaterialDescription + " is selected for completion");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());

		/*************************************************
		 * --------- Verify workflow tab Hireacrhy. ------- *
		 ************************************************/
		try {
		    // Try to locate all workflow steps
		    List<WebElement> steps = driver.findElement(By.cssSelector("#app")).getShadowRoot()
		        .findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
		        .findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']")).getShadowRoot()
		        .findElement(By.cssSelector("[id^='app-entity-manage-component-rs']")).getShadowRoot()
		        .findElement(By.cssSelector("#entityManageSidebar")).getShadowRoot()
		        .findElement(By.cssSelector("#sidebarTabs")).getShadowRoot()
		        .findElement(By.cssSelector("[id^='rock-workflow-panel-component-rs']")).getShadowRoot()
		        .findElement(By.cssSelector(".base-grid-structure > .base-grid-structure-child-2 > #workflows-content > #accordion0 > [slot='accordion-content'] > .workflow-content > #workflowStepper_bsapieusecaseapproval_workflowDefinition")).findElements(By.cssSelector("pebble-step"));

		    if (steps == null || steps.isEmpty()) {
		        throw new AssertionError("❌ No workflow steps found — 'pebble-step' elements are missing.");
		    }

		    String expectedTitle = "Pending Usecase Approval - BSA PIE";
		    WebElement activeStep = null;

		    System.out.println("**********Listing all workflow steps:**********");
		    for (int i = 0; i < steps.size(); i++) {
		        WebElement step = steps.get(i);
		        SearchContext stepShadow = step.getShadowRoot();
		        String actualTitle = stepShadow.findElement(By.cssSelector("#label > #connectedBadge > #step-heading > #textWrapper > #step-title > span")).getAttribute("title");

		        boolean isActive = step.getAttribute("class") != null && step.getAttribute("class").contains("iron-selected");
		        System.out.println((i + 1) + ": " + actualTitle + (isActive ? " (🟢 Active)" : ""));

		        if (isActive && actualTitle.equals(expectedTitle)) {
		            activeStep = step;
		        }
		    }

		    if (activeStep == null) {
		        throw new AssertionError("❌ Expected active step '" + expectedTitle + "' not found.");
		    }

		    System.out.println("As Expected active workflow step is: " + expectedTitle);
		    test.pass("As Expected active workflow step is: " + expectedTitle);
		    test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());

		    // Approve the record
		    WebElement commentBox = digitalssetPage.Pending_Use_Case_Approval_Commentinputbox();
		    WebElement approveBtn = digitalssetPage.Pending_Use_Case_Approval_Approve_btn();

		    if (commentBox == null || approveBtn == null || !approveBtn.isDisplayed()) {
		        throw new AssertionError("❌ Approval UI elements not found. Cannot proceed with approval.");
		    }

		    commentBox.sendKeys("Approving the record");
		    Thread.sleep(2000);

		    test.pass("Approving the record");
		    test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		    approveBtn.click();
		    Thread.sleep(5000);

		    /*************************************************
		     * --------- Wait for the banner to appear --------
		     ************************************************/
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		    Function<WebDriver, WebElement> getBannerElement = drv -> {
		        try {
		            return drv.findElement(By.cssSelector("#app")).getShadowRoot()
		                    .findElement(By.cssSelector("[id^='rs']")).getShadowRoot()
		                    .findElement(By.cssSelector("#pebbleAppToast > pebble-echo-html")).getShadowRoot()
		                    .findElement(By.cssSelector("#bind-html"));
		        } catch (Exception e) {
		            return null;
		        }
		    };

		    WebElement banner = wait1.until(drv -> {
		        WebElement el = getBannerElement.apply(drv);
		        return (el != null && el.isDisplayed()) ? el : null;
		    });

		    String bannerText = banner.getText();
		    System.out.println("✅ Banner appeared with the text : " + bannerText);
		    Thread.sleep(3000);

		    /*************************************************
		     * --------- Check Workflow to be completed -------
		     ************************************************/
		    List<WebElement> allSteps = driver.findElement(By.cssSelector("#app")).getShadowRoot()
		            .findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
		            .findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']")).getShadowRoot()
		            .findElement(By.cssSelector("[id^='app-entity-manage-component-rs']")).getShadowRoot()
		            .findElement(By.cssSelector("#entityManageSidebar")).getShadowRoot()
		            .findElement(By.cssSelector("#sidebarTabs")).getShadowRoot()
		            .findElement(By.cssSelector("[id^='rock-workflow-panel-component-rs']")).getShadowRoot()
		            .findElements(By.cssSelector("pebble-step"));

		    List<WebElement> visibleSteps = allSteps.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
		    int visibleCount = visibleSteps.size();
		    System.out.println("✅ Workflow that appeared after approval are : " + visibleCount);

		    Assert.assertEquals(visibleCount, 0, "❌ Expected no workflows, but found: " + visibleCount);
		    test.pass("Record moved to Approved state");
		    test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());

		} catch (Exception e) {
		    test.fail("❌ Workflow approval test failed: " + e.getMessage());
		    test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		    Assert.fail("There are no approval workflow to approve ");
		}
	}
}