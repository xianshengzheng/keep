package 适配器;

/**
 * @author Eric
 * @Title: TFCardImplement
 * @date 2019/8/23 9:44
 * @Description: TODO
 */
public class TFCardImplement implements TFCard {

    @Override
    public void TFread() {
        System.out.println("读取TFcard");
    }
}
