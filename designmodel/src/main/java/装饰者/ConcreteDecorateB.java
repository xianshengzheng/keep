package 装饰者;

/**
 * @author Eric
 * @Title: ConcreteDecorate
 * @date 2019/8/28 15:28
 * @Description: TODO
 */
public class ConcreteDecorateB extends Decorate {

    @Override
    public void operation() {
        super.operation();
        addBehavior();
        System.out.println("具体装饰B的操作");
    }

    public void addBehavior(){
        System.out.println("装饰B的方法");
    }

}
