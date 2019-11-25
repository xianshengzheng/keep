package adaptor;

import adaptor.SDCard.SDCard;

/**
 * @author Eric
 * @Title: Adaptor
 * @date 2019/8/23 9:45
 * @Description: TODO
 */
//以对象（聚合）的方式实现适配器
public class AdaptorObject implements SDCard {
    private TFCard tfCard;
    public AdaptorObject(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void readSD() {
        tfCard.TFread();
    }
}
