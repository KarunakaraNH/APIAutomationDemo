package resources;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    public static void main(String[] args) {
        String reportOutputDirectory = "target/cucumber-html-report";
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        Configuration configuration = new Configuration(new File(reportOutputDirectory), "Cucumber API Test Automation");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
