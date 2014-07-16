/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.junit.Assert.assertTrue;
import it.xsemantics.tests.swtbot.XsemanticsSwtbotTestBase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsImportExamplesProjectWizardTests extends
		XsemanticsSwtbotTestBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		// bot.sleep(2000);
		disableBuildAutomatically();
		cleanWorkspace();
		enableBuildAutomatically();
		waitForAutoBuild();
	}

	@Test
	public void canCreateExampleFJProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker("Xsemantics FJ Example",
				"it.xsemantics.example.fj");
		createExampleProjects("Xsemantics FJ (with cached type system) Example",
				"it.xsemantics.example.fjcached");
		waitForAutoBuild();
		
		// if we don't clean this project the fjcached project
		// presents an error in the xsemantics file...
		cleanProject("it.xsemantics.example.fj");
		
		waitForAutoBuildAndAssertNoErrors();
	}

	@Test
	public void canCreateExampleExpressionsProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker(
				"Xsemantics Expressions Example",
				"it.xsemantics.example.expressions");
	}

	@Test
	public void canCreateExampleLambdaProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker(
				"Xsemantics Lambda Example", "it.xsemantics.example.lambda");
	}

	protected void createExampleProjectsAndAssertNoErrorMarker(
			String projectType, String mainProjectId) throws CoreException {
		createExampleProjects(projectType, mainProjectId);

		waitForAutoBuildAndAssertNoErrors();
	}

	protected void createExampleProjects(String projectType,
			String mainProjectId) {
		bot.menu("File").menu("New").menu("Other...").click();

		SWTBotShell shell = bot.shell("New");
		shell.activate();
		bot.tree().expandNode("Xsemantics", "Examples", projectType).select();
		bot.button("Next >").click();

		bot.button("Finish").click();

		// creation of a project might require some time
		bot.waitUntil(shellCloses(shell), SHELL_TIMEOUT);
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId));
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId
				+ ".tests"));
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId
				+ ".ui"));
	}
}
