package pic;

import java.util.Arrays;

public class pic {
    private long pid;        //��Ʒid
    private int p;          //��p
    private int uid;        //����uid
    private String title;   //��Ʒ����
    private String author;  //����
    private String url;     //ͼƬ��ַ
    private boolean r18;    //R18
    private int width;      //��
    private int height;     //��
    private String[] tags;  //��Ʒ��ǩ
    public String base64;  //base64ת��

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    private String real;

    public long getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isR18() {
        return r18;
    }

    public void setR18(boolean r18) {
        this.r18 = r18;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "pic{" +
                "pid=" + pid +
                ", p=" + p +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", r18=" + r18 +
                ", width=" + width +
                ", height=" + height +
                ", tags=" + Arrays.toString(tags) +
                ", base64='" + base64 + '\'' +
                ", real='" + real + '\'' +
                '}';
    }
}
