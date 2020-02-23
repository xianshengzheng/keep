package 动态代理;

/**
 * @author Eric
 * @Title: Client
 * @date 2019/8/3 16:48
 * @Description: TODO
 */
public class Client {

    public static void main(String args[]){
        ITeacherDao teachDao = new TeacherDao();
        MetricsCollectorProxy metricsCollectorProxy = new MetricsCollectorProxy();
        ITeacherDao proxyFactory = (ITeacherDao) metricsCollectorProxy.createProxy(teachDao);

        proxyFactory.teach();
    }
}
