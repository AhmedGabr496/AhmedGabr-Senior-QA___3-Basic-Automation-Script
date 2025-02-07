package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static void doScroll(WebDriver driver, int heightPixel) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + heightPixel + ")");
    }

    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        return (JSONObject) obj;
    }

    public static int generateRandomNumber(int min, int max) {

        return (int) Math.round(Math.random() * (max - min) + min);
    }


}
