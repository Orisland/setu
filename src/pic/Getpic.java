package pic;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import bot.Core;
import bot.HttpUtil;
import bot.RotMain;
import pic.ipconfig;


import com.alibaba.fastjson.*;

import static pic.ipconfig.IP;

public class Getpic {
    private long selfQQ=0l;
    private long fromGroup=0l;
    
    public static pic[] doGet(int num) {
        String path = "https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true&num=";
        path = path+num;
        OutputStream out = null;
        BufferedReader br = null;
        String result = "";
        pic[] pic = new pic[num];
        JSONObject obj1 = null;
        try {
            System.out.println("准备开始");
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            System.out.println("来了来了");

            InputStream is = conn.getInputStream();
            System.out.println("获取输入流完成");
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            System.out.println("开始写入json");
            JSONObject obj = JSON.parseObject(br.readLine());
            JSONArray jsonArray = JSONArray.parseArray(obj.getString("data"));
            for (int i=0; i<pic.length; i++){
                obj1 = jsonArray.getJSONObject(i);
                pic[i] = JSONObject.parseObject(String.valueOf(obj1),pic.class);
            }

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pic;
    }

    public static pic doGet(String path, String date,long qq, long fromGroup1){
        OutputStream out = null;
        BufferedReader br = null;
        String result = "";
        pic pic = null;
        try {
            System.out.println("准备开始1");
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15*1000);
            conn.setReadTimeout(15*1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            System.out.println("来了来了2");

            InputStream is = conn.getInputStream();
            System.out.println("获取输入流完成3");
            br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            System.out.println("开始写入json4");
            JSONObject obj = JSON.parseObject(br.readLine());
            JSONArray jsonArray = JSONArray.parseArray(obj.getString("data"));
            JSONObject obj1 = jsonArray.getJSONObject(0);
            pic = JSONObject.parseObject(String.valueOf(obj1),pic.class);
            System.out.println("完成5");

            is.close();
        }
        catch (Exception e){
            Core.sendGroupMessages(qq, fromGroup1,"拉取数据超时，请重试~",0);
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
                if (br != null){
                    br.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return pic;
    }

    public pic Catchpic(){
        System.out.println("收到调用");
        Random random = new Random();
        int index;
        index = random.nextInt(96);
        String strindex = String.valueOf(index);
        if (strindex.length() == 2){
            strindex = "00" + strindex;
        }
        else {
            strindex = "000" + strindex;
        }
        System.out.println("setu库序号："+strindex);
        String str = HttpUtil.Get("http://"+IP+"/setu_"+strindex+".js","");
        str = str.substring(10);
        str = str.substring(0,str.length()-2);
        JSONArray pics = JSON.parseArray(str);
        index = random.nextInt(pics.size());
        JSONObject jsonObject = pics.getJSONObject(index);
        System.out.println("已取到json");
        pic pic = new pic();
        pic.setTitle(jsonObject.getString("title"));
        pic.setPid(jsonObject.getInteger("pid"));
        pic.setUid(jsonObject.getInteger("pid"));
        pic.setReal("http://"+IP+"/" + jsonObject.getString("path"));
        pic.setUrl(jsonObject.getString("url"));
        pic.setAuthor(jsonObject.getString("author"));
        System.out.println("封装完毕");                                                                

        return pic;
    }

    public pic Newpic(){
        System.out.println("新库收到调用");
        Random random = new Random();
        int index;
        String str = HttpUtil.Get("http://"+IP+"/setu_0096.js","");
        str = str.substring(11);
        str = str.substring(0,str.length()-2);
        JSONArray pics = JSON.parseArray(str);
        index = random.nextInt(pics.size());
        JSONObject jsonObject = pics.getJSONObject(index);
        System.out.println("已取到json");
        pic pic = new pic();
        pic.setTitle(jsonObject.getString("title"));
        pic.setPid(jsonObject.getInteger("pid"));
        pic.setUid(jsonObject.getInteger("pid"));
        pic.setReal("http://"+IP+"/" + jsonObject.getString("path"));
        pic.setUrl(jsonObject.getString("url"));
        pic.setAuthor(jsonObject.getString("author"));
        System.out.println("封装完毕");

        return pic;
    }

    public pic cosCatchpic(){
        System.out.println("收到调用");
        Random random = new Random();
        int index;
        index = random.nextInt(96);
        String strindex = String.valueOf(index);
        if (strindex.length() == 2){
            strindex = "00" + strindex;
        }
        else {
            strindex = "000" + strindex;
        }
        System.out.println("cos库序号："+strindex);
        String str = HttpUtil.Get("https://cdn.jsdelivr.net/gh/ipchi9012/cos_pics/cos_"+strindex+".js","");
        str = str.substring(10);
        str = str.substring(0,str.length()-2);
        JSONArray pics = JSON.parseArray("["+str);
        index = random.nextInt(pics.size());

        JSONObject jsonObject = pics.getJSONObject(index);
        System.out.println("已取到json");
        pic pic = new pic();
        System.out.println(jsonObject);
        pic.setTitle(jsonObject.getString("suite"));
        pic.setReal("https://cdn.jsdelivr.net/gh/ipchi9012/cos_pics/" + jsonObject.getString("path"));
        System.out.println("封装完毕");

        return pic;
    }

    public static void main(String[] args) {
        new Getpic().Catchpic();

    }


}
