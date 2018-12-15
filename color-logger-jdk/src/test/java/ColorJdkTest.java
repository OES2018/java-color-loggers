import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ColorJdkTest extends ColorBaseTest {
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log-jdk");

    static {
        System.out.println("===============================");
        System.out.println("====== Color logger - jdk =====");
        System.out.println("===============================");
    }

    private void selectLoggingConfigFile(String configFileName) {
        try (InputStream ins = new FileInputStream(getTargetDir() + configFileName)) {
            java.util.logging.LogManager.getLogManager().readConfiguration(ins);
        } catch (@SuppressWarnings("unused") IOException e) {
            logger.severe("Error loading custom logging configuration " + configFileName);
        }
    }

    private void doTheLogging(String configFileName) {
        selectLoggingConfigFile(configFileName);

        System.out.println();
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

	@Test
    public void colorLoggingJdkTest() {
        doTheLogging("logJdkNormal.properties");
        doTheLogging("logJdkColorEsc.properties");
        doTheLogging("logJdkColorJansi.properties");
        System.out.println();
    }
}
