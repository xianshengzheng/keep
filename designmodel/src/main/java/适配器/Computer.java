package 适配器;

import 适配器.SDCard.SDCard;

/**
 * @author Eric
 * @Title: Computer
 * @date 2019/8/23 9:39
 * @Description: TODO
 */
public class Computer {
    SDCard sdCard;

    public Computer(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    public void read(){
        sdCard.readSD();
    }
}
