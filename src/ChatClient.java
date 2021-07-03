import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.alibaba.fastjson.JSONObject;
/**
 * ͨ����
 * @author zhaoqk
 *
 * 2020��8��10�� ����5:07:31
 */
public class ChatClient extends Thread{
	
    //����һ��Socket����
    Socket socket = null;
    public ChatClient() {
    	
    }
    public ChatClient(String host, int port) {
        try {
            //��Ҫ��������IP��ַ�Ͷ˿ںţ����ܻ����ȷ��Socket����
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   

    @Override
    public void run() {
        super.run();
        try {
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            String temp = "";
            while ((len = s.read(buf)) != -1) {
            	String data = new String(buf, 0, len);
            	temp += data;
            	if(len < 1024){
            		parseData(temp);
            		temp="";
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void parseData(String data){
    	if(data.equals("")){
    		return;
    	}
    	data = StringUtils.getURLDecoderString(data);
    	JSONObject json = null;
    	for(int i=0;i<10;i++){
    		try{
        		json = JSONObject.parseObject(data);
        		break;
    		}catch (Exception e) {
    			System.out.println("��������" + data);
    			data = data.substring(data.indexOf("}") + 1);
    		}
    	}
		if(json.getInteger("type") == 0){//���ӳɹ�
			System.out.println("[���ӳɹ�]");
		}else if(json.getInteger("type") == 1){//������Ϣ
			Main.receivePrivateMessages(json.toJSONString());
		}else if(json.getInteger("type") == 2){//Ⱥ����Ϣ
			Main.receiveGroupMessages(json.toJSONString());
		}else if(json.getInteger("type") == 3){//�¼���Ϣ
			Main.receiveEventMessages(json.toJSONString());
		}else if(json.getInteger("type") == 4){//��ѯ����
			Main.selectResult(json.toJSONString());
		}
		
    }
    
    
    //д����
    public void sendMsg(String msg){
        OutputStream os= null;
        try {
            os= socket.getOutputStream();
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
