import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;

public class tool {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\bottest\\main\\279\\setu_0096.js"));
        String line = null;
        String rs = "";
        while ((line = br.readLine()) != null) {
            rs += line;
        }
        if (br != null) {
            br.close();
        }
        rs = rs.substring(10);
        rs = rs.substring(0,rs.length()-1);
        JSONArray pics = JSON.parseArray(rs);
//        for (int j = 0; j < 50;j++){
//            for (int i = 100*j; i<(100 * (j+1) > 3889 ? 3899-100 * (j+1) : 100 * (j+1)); i++){
//                System.out.println(pics.getJSONObject(100*j));
//            }
//        }
        JSONArray array1 = new JSONArray();
        JSONArray array2 = new JSONArray();
        int flag = 0;
        int flag1 = 0;
        int j=0;
        for (int i =0; i<pics.size(); i++) {
            if (i%10 == 0 && i != 0){
                System.out.println(array1);
                array1.add(pics.getJSONObject(i));
                array2.add(array1);
                array1.clear();
                flag++;
            }else if (i == pics.size()-1){
                array1.add(pics.getJSONObject(i));
                array2.add(array1);
                System.out.println(array2);
                array1.clear();
                flag++;
            }else {
                array1.add(pics.getJSONObject(i));
            }
        }
        File file = new File("E:\\bottest\\main\\279\\test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //2：准备输出流
        Writer out = new FileWriter(file);
        out.write(array2.toJSONString());
        out.close();
    }

}
