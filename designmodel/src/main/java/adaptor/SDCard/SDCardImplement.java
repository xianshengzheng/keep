package adaptor.SDCard;

/**
 * @author Eric
 * @Title: SDCardImplement
 * @date 2019/8/23 9:40
 * @Description: TODO
 */
public class SDCardImplement extends AbstractSDCard implements SDCard {
    @Override
    public void readSD() {
        System.out.println("读sd卡");
    }
}
