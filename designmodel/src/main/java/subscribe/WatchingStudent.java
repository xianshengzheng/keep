package subscribe;

import java.util.Date;

/**
 * @author Eric
 * @Title: WatchingNBAListener
 * @date 2019/8/29 14:18
 * @Description: TODO
 */
public class WatchingStudent {

    public WatchingStudent() {
        System.out.println("看电视中。。。");
    }

    public void stopWatchingTV(Date date){
        System.out.println(date+"： 关闭电视");
    }
}
