package pic;

import bot.Core;

public class tiqu {
    String msg;
    String url="https://pixiv.cat/";
    public tiqu(String msg){
        this.msg = msg;
    }

    public void catchpic(long selfQQ, long fromGroup){
        System.out.println(msg);
        String id = msg.substring(2);
        System.out.println(id);
        url = "https://pixiv.cat/" + id + ".jpg";
        System.out.println(url);
        url = "[netpic:"+ url + "]";
        String pack = "提取结果:\r" + url;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
    }
}
