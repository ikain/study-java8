package com.kai.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by FengKai on 2018/6/26.
 */
public class CallBackModel {

    private static Map<String, CallBackService> serviceMap = new Hashtable<>();
    private static Map<String, String> classPathMap = new Hashtable<>();

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 提前实例化存入
        serviceMap.put("A", new AClass());
        serviceMap.put("B", new BClass());

        serviceMap.get("A").invoke();
        serviceMap.get("B").invoke();

        // 根据反射实例化对象
        classPathMap.put("A", "com.kai.model.AClass");
        classPathMap.put("B", "com.kai.model.BClass");

        CallBackService service = (CallBackService) Class.forName(classPathMap.get("A")).newInstance();
        service.invoke();
        service = (CallBackService) Class.forName(classPathMap.get("B")).newInstance();
        service.invoke();
    }


}

interface CallBackService {
    void invoke();
}

class AClass implements CallBackService {

    @Override
    public void invoke() {
        System.out.println("implements A class");
    }
}

class BClass implements CallBackService {

    @Override
    public void invoke() {
        System.out.println("implements B class");
    }
}
