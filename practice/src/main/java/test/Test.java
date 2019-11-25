package test;

/**
 * @author Eric
 * @Title: Test
 * @date 2019/9/3 15:53
 * @Description: TODO
 */
public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public void fun(Test test){
        test = new Test("lisi");
        System.out.println(test);

    }

    public static void main(String args[]){
        Test test = new Test("1");
        test.fun(test);
        System.out.println(test);
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }
}
