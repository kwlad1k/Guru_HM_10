package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://dropstab.com/";
        Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = 12000;
        Configuration.pollingInterval = 500;
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWindow();
    }
}
