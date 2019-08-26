import com.wxg.study.util.JavaNIOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaNIOTest {

    final Logger logger = LoggerFactory.getLogger(JavaNIOTest.class);

    @Test
    public void test02GetResource() {
        String path = JavaNIOUtils.getResourcePath("logback.xml");
        System.out.println(path);
    }

    @Test
    public void test001() {
        logger.info("first , init , 输出日志");
    }
}
