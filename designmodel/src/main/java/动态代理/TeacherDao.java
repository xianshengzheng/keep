package 动态代理;

/**
 * @author Eric
 * @Title: TeachDao
 * @date 2019/8/3 16:32
 * @Description: TODO
 */
public class TeacherDao implements ITeacherDao{
    public void teach() {
        System.out.println("教学");
    }
}
