package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;


import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features="classpath:Folder",
		glue="Test",
		tags="",
		plugin= {"pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/file.json",
				
				
		},
		publish=true,
		dryRun=false

		)

public class runner_class {
	
	
	
}
