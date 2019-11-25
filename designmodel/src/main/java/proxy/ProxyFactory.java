package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Eric
        * @Title: ProxyFactory
        * @date 2019/8/3 16:33
        * @Description: TODO
        */
public class ProxyFactory{
    //维护一个目标对象
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始");
                Object returnVal = method.invoke(target, args);
                return returnVal;
            }
        });
    }

}
