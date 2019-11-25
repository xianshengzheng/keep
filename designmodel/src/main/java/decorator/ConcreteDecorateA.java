package decorator;

/**
 * @author Eric
 * @Title: ConcreateDecorateA
 * @date 2019/8/28 15:24
 * @Description: TODO
 */
public class ConcreteDecorateA extends Decorate {
    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "new Stats";
        System.out.println("具体装饰A的操作");
    }

}
