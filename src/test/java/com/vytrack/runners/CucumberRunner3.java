package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber3.json",
                "html:target/cucumber-report.html",
                "timeline:target/timeline-report"
        },
        features = {
                "src/test/resources/features/Login.feature"
        },
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "",
        publish = true
)
public class CucumberRunner3 {
}
