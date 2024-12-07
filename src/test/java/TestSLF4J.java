import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestSLF4J {
    private static Logger logger = LoggerFactory.getLogger(TestSLF4J.class);

    @Test
    public void testTrace(){
        logger.trace("another trace");
    }

    @Test
    public void testDebug(){
        logger.debug("Debugging process...");
    }

    @Test
    public void testError(){
        logger.error("Danger error!");
    }

    @Test
    public void testInfo(){
        logger.info("Interesting info");
    }

    @Test
    public void testWarning(){
        logger.warn("Warning!!!");
    }
}
