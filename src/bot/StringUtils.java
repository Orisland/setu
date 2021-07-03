package bot;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringUtils {
	
	
	public static Map<Long, JSONObject> queue = new HashMap<Long, JSONObject>();
	
	public static long getNum(){
		long t = new Date().getTime();
		return t;
	}
	
	public static String getPath(){
		File file = new File("");
        String filePath;
		try {
			filePath = file.getCanonicalPath();
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "C:\\Users\\Admin\\Desktop";
	}
	
	
	public static byte[] readFile(String fileName){
		InputStream in = null;
		try {
			in = new FileInputStream(new File(fileName));
			byte[] bts = new byte[in.available()];
			in.read(bts);
			return bts;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	//URL����
	public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        	System.out.println("��������" + str);
            e.printStackTrace();
        }
        return result;
    }
	
	/**
	 * 16����ת����Ϊstring�����ַ���
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
	    if (s == null || s.equals("")) {
	        return null;
	    }
	    s = s.replace(" ", "");
	    byte[] baKeyword = new byte[s.length() / 2];
	    for (int i = 0; i < baKeyword.length; i++) {
	        try {
	            baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	        s = new String(baKeyword, "UTF-8");
	        new String();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    return s;
	}
	
	
	public static String subStr(String str,String left,String right){
		if(!str.contains(left)){
			return null;
		}
		int a = str.indexOf(left);
		int b = str.length();
		if(!isEmpty(right)){
			int c = str.indexOf(right,a + left.length() + 1);
			if(c != -1){
				b = c;
			}
		}
		return str.substring(a + left.length(), b);
	}
	
	/**
	 * �ж��ı��Ƿ�û��ֵ
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	
	
	
}
