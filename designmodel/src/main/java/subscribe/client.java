package subscribe;

import java.util.Date;

/**
 * @author Eric
 * @Title: client
 * @date 2019/8/29 14:17
 * @Description: TODO
 */
public class client {
    public static void main(String args[]) {
        //创建一个尽职尽责的放哨者
        Notifier goodNotifier = new GoodNotifier();
        //创建一个玩游戏的同学，开始玩游戏
        PlayingStudent playingGameListener = new PlayingStudent();
        //创建一个看电视的同学，开始看电视
        WatchingStudent watchingTVListener = new WatchingStudent();
        //玩游戏的同学告诉放哨的同学，老师来了告诉一下
        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());
        //看电视的同学告诉放哨的同学，老师来了告诉一下
        goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());
        try {
            //一点时间后
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//老师出现，放哨的人通知所有要帮忙的同学:老师来了
        goodNotifier.notifyX();
    }

}
