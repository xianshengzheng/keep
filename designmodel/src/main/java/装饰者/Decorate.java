package 装饰者;

/**
 * @author Eric
 * @Title: Decorate
 * @date 2019/8/28 15:22
 * @Description: TODO
 */
public abstract class Decorate extends Component {
    private Component component;
    public  void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
