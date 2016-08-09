package com.threads.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonConfigUtil {
    public static JsonConfig getJsonConfig() {
        JsonConfig jc = new JsonConfig();
        jc.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            private String format = "yyyy-MM-dd HH:mm:ss";

            @Override
            public Object processArrayValue(Object value, JsonConfig jsonConfig) {
                return null;
            }

            @Override
            public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
                if (value == null) {
                    return "";
                }
                if (value instanceof Date) {
                    String str = new SimpleDateFormat(format).format((Date) value);
                    return str;
                }
                return value;
            }

        });
        jc.registerJsonValueProcessor(java.sql.Time.class, new JsonValueProcessor() {

            @Override
            public Object processArrayValue(Object value, JsonConfig jsonConfig) {
                return value;
            }

            @Override
            public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
                try {
                    if (value == null) {
                        return "";
                    }
                    if (value instanceof java.sql.Time) {
                        Date d = (Date) ((java.sql.Time) value);
                        String str = new SimpleDateFormat("HH:mm:ss").format(d);
                        return str;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

        });
        return jc;
    }
}
