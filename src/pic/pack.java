package pic;

import bot.Core;

public class pack {
    static int COOLTIME=8;
    public void packimg(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"���ڷ���Կ��~",0);
        pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getUrl() + "]";
        String picPid = "ͼƬid��"+pic.getPid();
        String picurl = "ͼƬurl��"+pic.getUrl();
        String picwriter = "���ߣ�"+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"�������~",0);
    }

    public void packimg(long selfQQ, long fromGroup,long req, long ram){
        Core.sendPrivateMessages(selfQQ,fromGroup,"���ڷ���Կ��~",ram,req);
        pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getUrl() + "]";
        String picPid = "ͼƬid��"+pic.getPid();
        String picurl = "ͼƬurl��"+pic.getUrl();
        String picwriter = "���ߣ�"+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"�������~",ram,req);
    }

    public void packimgs(long selfQQ, long fromGroup, String msg) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("ɬͼ��") + 3));
        if (num >5){
            Core.sendGroupMessages(selfQQ,fromGroup,"̰�ģ�ֻ����һ��ͼ~",0);
            num=1;
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"����!"+num+"��setu��Ҫ��ʱ��~",0);
        Core.sendGroupMessages(selfQQ,fromGroup,"������ɽ��ʤ���Ƚ��ķ�sp��⣬��ͼ����߿ɴ�100%~",0);

        for (int i=0; i<num; i++){
            pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getUrl() + "]";
            String picPid = "ͼƬid��"+pic.getPid();
            String picurl = "ͼƬurl��"+pic.getUrl();
            String picwriter = "���ߣ�"+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "��"+y+"��setu����~"+"\n"+pack;
            Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
            Thread.sleep(COOLTIME *1000);
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"setu�ѷ�����ɣ���ʾ������������~",0);
    }

    public void packimgs(long selfQQ, long fromGroup, String msg,long req, long ram) throws InterruptedException{

        int num = Integer.parseInt(msg.substring(msg.indexOf("ɬͼ��") + 3));
        if (num >5){
            Core.sendPrivateMessages(selfQQ,fromGroup,"̰�ģ�ֻ����һ��ͼ~",ram,req);
            num=1;
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"����!"+num+"��setu��Ҫ��ʱ��~",ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"������ɽ��ʤ���Ƚ��ķ�sp��⣬��ͼ����߿ɴ�100%~",ram,req);

        for (int i=0; i<num; i++){
            pic pic = Getpic.doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true", "",selfQQ,fromGroup);
            String url = "[netpic:"+ pic.getUrl() + "]";
            String picPid = "ͼƬid��"+pic.getPid();
            String picurl = "ͼƬurl��"+pic.getUrl();
            String picwriter = "���ߣ�"+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "��"+y+"��setu����~"+"\n"+pack;
            Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,req,ram);
            Thread.sleep(COOLTIME *1000);
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"setu�ѷ�����ɣ���ʾ������������~",req,ram);
    }

    /**
     * ģ���棬�µĻ�ȡ��ʽ
     * @param selfQQ
     * @param fromGroup
     */
    public void packpic(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"���ڷ���Կ��~",0);
        pic pic = new Getpic().Catchpic();
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getReal() + "]";
        System.out.println(url);
        String picPid = "ͼƬid��"+pic.getPid();
        String picurl = "ͼƬurl��"+pic.getUrl();
        String picwriter = "���ߣ�"+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"�������~",0);
    }

    public void cospackpic(long selfQQ, long fromGroup){
        Core.sendGroupMessages(selfQQ,fromGroup,"���ڷ���Կ��~",0);
        pic pic = new Getpic().cosCatchpic();
        String url = "[netpic:"+ pic.getReal() + "]";
        String picPid = "���⣺"+pic.getTitle();
        String pack = url+"\n"+picPid;
        Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
        Core.sendGroupMessages(selfQQ,fromGroup,"�������~",0);
    }

    public void packpic(long selfQQ, long fromGroup,long req, long ram){
        Core.sendPrivateMessages(selfQQ,fromGroup,"���ڷ���Կ��~",ram,req);
        pic pic = new Getpic().Catchpic();
        System.out.println(pic.getUrl());
        String url = "[netpic:"+ pic.getReal() + "]";
        System.out.println(url);
        String picPid = "ͼƬid��"+pic.getPid();
        String picurl = "ͼƬurl��"+pic.getUrl();
        String picwriter = "���ߣ�"+pic.getAuthor();
        String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
        Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,ram,req);
    }

    public void pcakpics(long selfQQ, long fromGroup, String msg) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("ɬͼ��") + 3));
        if (num >5){
            Core.sendGroupMessages(selfQQ,fromGroup,"̰�ģ�ֻ����һ��ͼ~",0);
            num=1;
        }
        Core.sendGroupMessages(selfQQ,fromGroup,"����!"+num+"��setu��Ҫ��ʱ��~",0);
        Core.sendGroupMessages(selfQQ,fromGroup,"������ɽ��ʤ���Ƚ��ķ�sp��⣬��ͼ����߿ɴ�100%~",0);

        for (int i=0; i<num; i++){
            pic pic = new Getpic().Catchpic();
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getReal() + "]";
            System.out.println(url);
            String picPid = "ͼƬid��"+pic.getPid();
            String picurl = "ͼƬurl��"+pic.getUrl();
            String picwriter = "���ߣ�"+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "��"+y+"��setu����~"+"\n"+pack;
            Core.sendGroupMessagesPicText(selfQQ, fromGroup, pack,0);
            Thread.sleep(COOLTIME *1000);
        }
    }

    public void pcakpics(long selfQQ, long fromGroup, String msg,long req, long ram) throws InterruptedException {
        int num = Integer.parseInt(msg.substring(msg.indexOf("ɬͼ��") + 3));
        if (num >5){
            Core.sendPrivateMessages(selfQQ,fromGroup,"̰�ģ�ֻ����һ��ͼ~",ram,req);
            num=1;
        }
        Core.sendPrivateMessages(selfQQ,fromGroup,"����!"+num+"��setu��Ҫ��ʱ��~",ram,req);
        Core.sendPrivateMessages(selfQQ,fromGroup,"������ɽ��ʤ���Ƚ��ķ�sp��⣬��ͼ����߿ɴ�100%~",ram,req);

        for (int i=0; i<num; i++){
            pic pic = new Getpic().Newpic();
            System.out.println(pic.getUrl());
            String url = "[netpic:"+ pic.getReal() + "]";
            System.out.println(url);
            String picPid = "ͼƬid��"+pic.getPid();
            String picurl = "ͼƬurl��"+pic.getUrl();
            String picwriter = "���ߣ�"+pic.getAuthor();
            String pack = url+"\n"+picPid+"\n"+picwriter+"\n"+picurl;
            int y = i+1;
            pack = "��"+y+"��setu����~"+"\n"+pack;
            Core.sendPrivateMessagesPicText(selfQQ, fromGroup, pack,req,ram);
            Thread.sleep(COOLTIME *1000);
        }
    }
}

