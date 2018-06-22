package com.kai;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by FengKai on 2018/5/23.
 */
public class Main23 {

    public static void main(String[] args) {
        Map<String, String> propertyMap = getEncryptPropertyMap(SysUser.class);
        System.out.println(propertyMap);
    }

    private static Map<String, String> getEncryptPropertyMap(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        Map<String, String> propertyMap = new HashMap<String, String>();
        try {
            for (Method method : methods) {
                Encrypt encryptAnnotation = method.getAnnotation(Encrypt.class);
                String setMethodName = method.getName();
                if (encryptAnnotation != null && setMethodName.startsWith("set")) {
                    String property = setMethodName.substring(3);
                    propertyMap.put(property.substring(0, 1).toLowerCase() + property.substring(1), "");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return propertyMap;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Encrypt {

    }

    class SysUser {
        private String id;
        private String name;
        private String companyId;
        private String domainId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        @Encrypt
        public String getDomainId() {
            return domainId;
        }

        @Encrypt
        public void setDomainId(String domainId) {
            this.domainId = domainId;
        }
    }
}
