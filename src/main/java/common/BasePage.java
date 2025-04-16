package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePUI;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    // Tuan theo quy tac cua tinh dong goi
    // Ham static co the truy cap truc tiep tu pham vi class
    public static BasePage getBasePage(){
        return new BasePage();
    }

    public void openURL(WebDriver driver, String url){
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    public void back(WebDriver driver){
        driver.navigate().back();
    }

    public void forward(WebDriver driver){
        driver.navigate().forward();
    }

    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String textValue){
        waitAlertPresence(driver).sendKeys(textValue);
    }

    public String getWindowHandle(WebDriver driver){
        return driver.getWindowHandle();
    }

    public void switchToWindowByID(WebDriver driver, String windowID){
        for(String window: getWindowHandles(driver)){
            if(!window.equals(windowID)){
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String windowTitle){
        for(String runWindow: getWindowHandles(driver)){
            driver.switchTo().window(runWindow);
            if(driver.getTitle().equals(windowTitle)){
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentID){
        for(String runWindow: getWindowHandles(driver)){
            if(!runWindow.equals(parentID)){
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }


    public Set<String> getWindowHandles(WebDriver driver){
        return driver.getWindowHandles();
    }

    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... value){
        return driver.findElement(getByLocator(castParameter(locator, value)));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... value){
        return driver.findElements(getByLocator(castParameter(locator,value)));
    }


    private String castParameter(String locator, String... restParameter){
        return String.format(locator, (Object[]) restParameter);
    }

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public By getByLocator(String locator){
        By by;
        if(locator.toUpperCase().startsWith("ID=")){
            by = By.id(locator.substring(3));
        }else if(locator.toUpperCase().startsWith("CLASS=")){
            by = By.className(locator.substring(6));
        }else if(locator.toUpperCase().startsWith("CSS=")){
            by = By.cssSelector(locator.substring(4));
        }else if(locator.toUpperCase().startsWith("XPATH=")){
            by = By.xpath(locator.substring(6));
        }else if(locator.toUpperCase().startsWith("NAME=")){
            by = By.name(locator.substring(5));
        }else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }
    public void clickToElement(WebDriver driver, String locator, String... value){
        getElement(driver,castParameter(locator,value)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String textValue){
        getElement(driver,locator).sendKeys(textValue);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String textValue, String... value){
        getElement(driver,castParameter(locator,value)).sendKeys(textValue);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textValue){
        new Select(getElement(driver,locator)).selectByVisibleText(textValue);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textValue, String... value){
        new Select(getElement(driver,castParameter(locator, value))).selectByVisibleText(textValue);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();
    }

    public Boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String itemTextExpected){
        clickToElement(driver, parentXpath);
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for(WebElement item: allItems){
            if(item.getText().trim().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(WebDriver driver, String parentXpath, String childXpath,String itemTextExpected){
        getElement(driver, parentXpath).clear();
        sendKeyToElement(driver,parentXpath,itemTextExpected);
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for(WebElement item: allItems){
            if(item.getText().trim().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElement(driver,locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... value){
        return getElement(driver,castParameter(locator, value)).getAttribute(attributeName);
    }

    public Dimension getElementSize(WebDriver driver, String locator){
        return getElement(driver,locator).getSize();
    }

    public Dimension getElementSize(WebDriver driver, String locator, String... value){
        return getElement(driver,castParameter(locator, value)).getSize();
    }


    public void clearElementText(WebDriver driver, String locator){
        getElement(driver,locator).clear();
    }

    public void clearElementText(WebDriver driver, String locator, String... value){
        getElement(driver,castParameter(locator, value)).clear();
    }

    public String getElementText(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... value){
        return getElement(driver,castParameter(locator, value)).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName){
        return getElement(driver,locator).getCssValue(propertyName);
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName, String... value){
        return getElement(driver,castParameter(locator, value)).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize(WebDriver driver, String locator){
        return getListElement(driver,locator).size();
    }

    public int getListElementSize(WebDriver driver, String locator, String... value){
        return getListElement(driver,castParameter(locator, value)).size();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator){
        if(!getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... value){
        if(!getElement(driver,locator, value).isSelected()){
            getElement(driver,locator, value).click();
        }
    }

    public void unCheckTheCheckbox(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void unCheckTheCheckbox(WebDriver driver, String locator, String... value){
        if(getElement(driver,locator, value).isSelected()){
            getElement(driver,locator, value).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getElement(driver, locator).isDisplayed();
    }
    public boolean isElementDisplayed(WebDriver driver, String locator, String... value){
        return getElement(driver, locator, value).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String locator){
        return getElement(driver, locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String ...value){
        return getElement(driver, locator, value).isSelected();
    }

    public void switchToFrameOrIFrame(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver,locator));

    }
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator){
        new Actions(driver).clickAndHold(getElement(driver,sourceLocator)).moveToElement(getElement(driver,targetLocator)).release().perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getElement(driver,locator), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... value){
        new Actions(driver).sendKeys(getElement(driver,locator, value), key).perform();
    }

    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator, String... value) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator, value));
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... value){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, value))));
    }

    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... value){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, value))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... value){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator, value))));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator, String... value){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.presenceOfElementLocated(getByLocator(castParameter(locator, value))));
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... value){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).
                until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,value))));
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut){
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }


    public boolean isElementUndisplayed(WebDriver driver, String locator){
        System.out.println("Start time = " + new Date());
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElement(driver, locator);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
        if(elements.size() == 0){
            System.out.println("Element NOT in DOM");
            System.out.println("End time = " + new Date());
            return true;
        }else if (elements.size() > 0 && !elements.get(0).isDisplayed()){
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time = " + new Date());
            return true;
        }else {
            System.out.println("Element in DOM and visible");
            return false;
        }
    }



    public boolean waitAllLoadingIconInvisible(WebDriver driver, String locator) {
        return waitForListElementInvisible(driver, locator);
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        sleepInSeconds(3);
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        // Get directory of upload file folder
        String filePath = GlobalConstants.UPLOAD_PATH;

        String fullFileName = "";
        // Iterate through each file name
        for(String file: fileNames){
            fullFileName += filePath + file + "\n"; // output: filename1 + "\n" + filename2 + "\n" + filename3 + "\n"
        }

        // Cắt ký tự xuống dòng (\n) ở 2 đầu chuỗi đi
        fullFileName = fullFileName.trim(); // output: filename1 + "\n" + filename2 + "\n" + filename3

        // Send key
        getElement(driver, BasePUI.ADD_FILE_BUTTON).sendKeys(fullFileName);
    }
}
