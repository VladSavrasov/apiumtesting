package helpers;

import config.Config;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class BrowserStack {


    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        return given()
                .auth().basic(config.user(), config.key())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}