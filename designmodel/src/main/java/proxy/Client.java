package proxy;

/**
 * @author Eric
 * @Title: Client
 * @date 2019/8/3 16:48
 * @Description: TODO
 */
public class Client {

    public static void main(String args[]){
        ITeacherDao teachDao = new TeacherDao();

        ITeacherDao proxyFactory = (ITeacherDao) new ProxyFactory(teachDao).getProxyInstance();

        proxyFactory.teach();
    }
}
