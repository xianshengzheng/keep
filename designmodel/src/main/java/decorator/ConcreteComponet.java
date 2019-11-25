package decorator;

/**
 * @author Eric
 * @Title: ConcreateComponet
 * @date 2019/8/28 15:21
 * @Description: TODO
 */
public class ConcreteComponet extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
