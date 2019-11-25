package Base;

/**
 * @author Eric
 * @Title: Synchronized
 * @date 2019/9/2 12:56
 * @Description: TODO
 */
public class Synchronized {
    public static void main(String args[]){
        TestSynchronized test1 = new TestSynchronized();
        TestSynchronized test2= new TestSynchronized();
        new Thread(()->{
//            test1.Test();
            test1.test();
        }).start();

//        test2.Test();
        test2.test();
    }
}

class TestSynchronized{
    public void test(){
        synchronized (TestSynchronized.class){
            System.out.println("aa");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test1(){
        synchronized (this){
            System.out.println("aa");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}