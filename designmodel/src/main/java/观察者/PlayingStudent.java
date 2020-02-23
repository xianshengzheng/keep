package 观察者;

import java.util.Date;

/**
 * @author Eric
 * @Title: WatchingNBAListener
 * @date 2019/8/29 14:18
 * @Description: TODO
 */
public class PlayingStudent {

    public PlayingStudent() {
        System.out.println("打游戏中。。。");
    }

    public void stopPlayingGame(Date date){
        System.out.println(date+": 关闭游戏");
    }
}
