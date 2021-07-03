package pic;

import bot.Core;

public class pack {
    static int COOLTIME=8;
    public void packimg(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"正在翻车钥匙~",0);
        pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getUrl() + "]";
        String picPid = "图片id："+pic.getPid();
        String picurl = "图片url："+pic.getUrl();
        String picwriter = "作者："+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"发车完毕~",0);
    }

    public void packimg(long selfQQ, long fromGroup,long req, long ram){
        Core.sendPrivateMessages(selfQQ,fromGroup,"正在翻车钥匙~",ram,req);
        pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getUrl() + "]";
        String picPid = "图片id："+pic.getPid();
        String picurl = "图片url："+pic.getUrl();
        String picwriter = "作者："+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"发车完毕~",ram,req);
    }

    public void packimgs(long selfQQ, long fromGroup, String msg) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("涩图组") + 3));
        if (num >5){
            Core.sendGroupMessages(selfQQ,fromGroup,"贪心，只给你一张图~",0);
            num=1;
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"冲冲冲!"+num+"张setu需要点时间~",0);
        Core.sendGroupMessages(selfQQ,fromGroup,"由于南山必胜客先进的反sp检测，吞图率最高可达100%~",0);

        for (int i=0; i<num; i++){
            pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getUrl() + "]";
            String picPid = "图片id："+pic.getPid();
            String picurl = "图片url："+pic.getUrl();
            String picwriter = "作者："+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "第"+y+"张setu来了~"+"\n"+pack;
            Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
            Thread.sleep(COOLTIME *1000);
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"setu已发送完成，显示多少听天由命~",0);
    }

    public void packimgs(long selfQQ, long fromGroup, String msg,long req, long ram) throws InterruptedException{

        int num = Integer.parseInt(msg.substring(msg.indexOf("涩图组") + 3));
        if (num >5){
            Core.sendPrivateMessages(selfQQ,fromGroup,"贪心，只给你一张图~",ram,req);
            num=1;
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"冲冲冲!"+num+"张setu需要点时间~",ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"由于南山必胜客先进的反sp检测，吞图率最高可达100%~",ram,req);

        for (int i=0; i<num; i++){
            pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
            String url = "[netpic:"+ pic.getUrl() + "]";
            String picPid = "图片id："+pic.getPid();
            String picurl = "图片url："+pic.getUrl();
            String picwriter = "作者："+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "第"+y+"张setu来了~"+"\n"+pack;
            Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,req,ram);
            Thread.sleep(COOLTIME *1000);
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"setu已发送完成，显示多少听天由命~",req,ram);
    }

    /**
     * 模糊版，新的获取方式
     * @param selfQQ
     * @param fromGroup
     */
    public void packpic(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"正在翻车钥匙~",0);
        pic pic = new Getpic().Catchpic();
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getReal() + "]";
        System.out.println(url);
        String picPid = "图片id："+pic.getPid();
        String picurl = "图片url："+pic.getUrl();
        String picwriter = "作者："+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"发车完毕~",0);
    }

    public void cospackpic(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"正在翻车钥匙~",0);
        pic pic = new Getpic().cosCatchpic();
        String url = "[netpic:"+ pic.getReal() + "]";
        String picPid = "标题："+pic.getTitle();
        String pack = url+"\n"+picPid;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"发车完毕~",0);
    }

    public void packpic(long selfQQ, long fromGroup,long req, long ram){
        Core.sendPrivateMessages(selfQQ,fromGroup,"正在翻车钥匙~",ram,req);
        pic pic = new Getpic().Catchpic();
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getReal() + "]";
        System.out.println(url);
        String picPid = "图片id："+pic.getPid();
        String picurl = "图片url："+pic.getUrl();
        String picwriter = "作者："+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,ram,req);
    }

    public void pcakpics(long selfQQ, long fromGroup, String msg) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("涩图组") + 3));
        if (num >5){
            Core.sendGroupMessages(selfQQ,fromGroup,"贪心，只给你一张图~",0);
            num=1;
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"冲冲冲!"+num+"张setu需要点时间~",0);
        Core.sendGroupMessages(selfQQ,fromGroup,"由于南山必胜客先进的反sp检测，吞图率最高可达100%~",0);

        for (int i=0; i<num; i++){
            pic pic = new Getpic().Catchpic();
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getReal() + "]";
            System.out.println(url);
            String picPid = "图片id："+pic.getPid();
            String picurl = "图片url："+pic.getUrl();
            String picwriter = "作者："+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "第"+y+"张setu来了~"+"\n"+pack;
            Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
            Thread.sleep(COOLTIME *1000);
        }
    }

    public void pcakpics(long selfQQ, long fromGroup, String msg,long req, long ram) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("涩图组") + 3));
        if (num >5){
            Core.sendPrivateMessages(selfQQ,fromGroup,"贪心，只给你一张图~",ram,req);
            num=1;
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"冲冲冲!"+num+"张setu需要点时间~",ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"由于南山必胜客先进的反sp检测，吞图率最高可达100%~",ram,req);

        for (int i=0; i<num; i++){
            pic pic = new Getpic().Newpic();
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getReal() + "]";
            System.out.println(url);
            String picPid = "图片id："+pic.getPid();
            String picurl = "图片url："+pic.getUrl();
            String picwriter = "作者："+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "第"+y+"张setu来了~"+"\n"+pack;
            Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,req,ram);
            Thread.sleep(COOLTIME *1000);
        }
    }
}

