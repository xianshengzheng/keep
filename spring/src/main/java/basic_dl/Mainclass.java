package basic_dl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhenghao
 */
public class Mainclass {
    public static void main(String[] args) throws Exception {
        ApplicationContext factory = new ClassPathXmlApplicationContext("basic_dl/Application.xml");
        Person person = factory.getBean(Person.class);
        System.out.println(person);
    }

}
