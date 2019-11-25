package test;

/**
 * @author Eric
 * @Title: singleton
 * @date 2019/9/3 15:39
 * @Description: TODO
 */
public class Singleton {
    private Singleton() {

    }

    static class InstancHolder{
        private  static A a = new A();
    }

    public static A getInstance() {
        return InstancHolder.a;
    }
}

class A {

}