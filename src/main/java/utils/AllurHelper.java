package utils;

import io.qameta.allure.Allure;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.logging.Logger;

public class AllurHelper {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AllurHelper.class);

    public static void logToAllure(String contName, String value){
        Allure.addAttachment(contName, value);
        log.info(contName);
        log.info(value);
    }
}
