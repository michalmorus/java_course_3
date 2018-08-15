package loggers;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String... args) {
        MDC.put("key", "MDC test");
        LOGGER.info("info logger");
        LOGGER.trace("info trace");
    }
}
