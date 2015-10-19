package util;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/19
 * Time: 19:54
 */
public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JsonFactory jsonFactory = objectMapper.getJsonFactory();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static String writeObjectToJsonWithJF(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(out, JsonEncoding.UTF8);
        jsonGenerator.writeObject(obj);
        return new String(out.toByteArray(), "UTF-8");
    }

    public static String writeObjectToJson(Object jsonObject) {
        try {
            return objectMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            logger.warn("Json序列化失败", e);
            return StringUtils.EMPTY;
        }
    }


    public static String writeObjectToJson(Object result, String callback) {
        StringBuilderWriter sw = new StringBuilderWriter();
        JsonGenerator jg = null;
        try {
            jg = jsonFactory.createJsonGenerator(sw);
            jg.writeStartObject();
            jg.writeBooleanField("ret", true);
            jg.writeObjectField("data", result);
            jg.writeEndObject();
        } catch (IOException e) {
            logger.warn("generateData exception", e);
        } finally {
            Closer.close(jg);
        }
        if (StringUtils.isNotBlank(callback)) {
            StringBuilder sb = new StringBuilder();
            sb.append(callback).append("(").append(sw.toString()).append(")");
            return sb.toString();
        }
        return sw.toString();
    }


}
