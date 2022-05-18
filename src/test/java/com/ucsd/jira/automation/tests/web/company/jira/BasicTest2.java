package com.ucsd.jira.automation.tests.web.company.jira;

import com.pwc.core.framework.annotations.Issue;
import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import static com.pwc.logging.service.LoggerService.*;


public class BasicTest2 extends JiraTestCase {

    @Override
    public void beforeMethod() {
    }

    @Override
    public void afterMethod() {
    }

    @Issue("STORY-1235")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testBasic() {

        FEATURE("Additional testing on stable Jira site features ");
        SCENARIO("User logs in and validates switch icon links");

        GIVEN("the user logs in to the Jira dashboard");
        webElementVisible(Constants.NEW_TEST_HEADING);
        
        WHEN("the user navigates to the switch icon");
        webAction(Constants.SWITCH_DIV);

        WHEN( "the user selects the start link");
        webAction(Constants.START_LINK_DIV);

        AND( "from Atlassian homepage the user selects Jira button");
        webAction(Constants.JIRA_BUTTON);
        webAction(Constants.DASHBOARD_TAB);

        THEN("the user returns to Jira page and finds Create button");
        webElementVisible(Constants.CREATE_PROJECT_DIV);


    }

}
