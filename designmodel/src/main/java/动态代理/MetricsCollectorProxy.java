package 动态代理;

import java.lang.reflect.Proxy;

public class MetricsCollectorProxy {

    public MetricsCollectorProxy() {
    }

    public Object createProxy(Object proxiedObject) {
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), proxiedObject.getClass().getInterfaces(), (proxy, method, args) -> {
            long startTimestamp = System.currentTimeMillis();
            Object returnVal = method.invoke(proxiedObject, args);
            Thread.sleep(100);
            long endTimeStamp = System.currentTimeMillis();
            System.out.println("方法执行时间:" + (endTimeStamp - startTimestamp));
            return returnVal;
        });
    }

}
