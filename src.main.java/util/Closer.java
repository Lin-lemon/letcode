package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/19
 * Time: 20:14
 */
public class Closer {

    private static final Logger log = LoggerFactory.getLogger(Closer.class);

    public static void close(Closeable... cs) {
        if (cs == null) {
            return;
        }
        for (Closeable c : cs) {
            if (c != null) {
                try {
                    c.close();
                } catch (Throwable e) {
                    log.warn("资源关闭时出错:" + c.getClass().getName(), e);
                }
            }
        }
    }
}
