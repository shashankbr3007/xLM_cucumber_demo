package com.xlm.cucumberdemo.TestController;

import cucumber.api.cli.Main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TestController {

    @RequestMapping(value = "/trigger", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public Map triggerTests(String[] testCases) {

        new Thread(() -> {

            String[] args = new String[]{"-g", "com.xlm.cucumberdemo.stepdefinitions",
                    "./src/main/resources/features/demoQA.feature",
                    "--plugin", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:Reports/report.html"};
            try {
                Main.run(args, Thread.currentThread().getContextClassLoader());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        Map<String, String> map = new HashMap<>();
        map.put("Message", "Execution Started, please check \"http://localhost:8181/dashboard\" for latest Reports");
        map.put("Test Cases being executed", String.valueOf(testCases.length));
        map.put("Date", String.valueOf(System.currentTimeMillis()));
        return map;
    }
}
