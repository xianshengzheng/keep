package adaptor;

import adaptor.SDCard.AbstractSDCard;

/**
 * @author Eric
 * @Title: Adaptor
 * @date 2019/8/23 9:45
 * @Description: TODO
 */
//以对象（聚合）的方式实现适配器
public class AdaptorExtend extends AbstractSDCard {
    private TFCard tfCard;
    public AdaptorExtend(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void readSD() {
        tfCard.TFread();
    }
}
