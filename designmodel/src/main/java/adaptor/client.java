package adaptor;

import adaptor.SDCard.AbstractSDCard;
import adaptor.SDCard.SDCard;
import adaptor.SDCard.SDCardImplement;

/**
 * @author Eric
 * @Title: client
 * @date 2019/8/23 9:42
 * @Description: TODO
 */
public class client {
    public static void main(String args[]){
        //原来的方式
        SDCard sdCard = new SDCardImplement();
        Computer computer = new Computer(sdCard);
        computer.read();

        //添加适配器以后
        TFCard tfCard = new TFCardImplement();
        SDCard sdCard1 = new AdaptorObject(tfCard);
        Computer computer1 = new Computer(sdCard1);
        computer1.read();

        AbstractSDCard sdCard2 = new AdaptorExtend(tfCard);
//        Computer computer2 = new Computer(sdCard2);
//        computer2.read();
    }
}
