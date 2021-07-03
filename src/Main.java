import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * ��Ҫ��
 * @author zhaoqk
 *
 * 2020��8��10�� ����5:07:37
 */
public class Main {
	public static long selfQQ=0;
	public static long fromQQ=0;
	public static long random=0;
	public static long req=0;
	public static long fromGroup=0;
	
	/**
	 * ������
	 * 1.�������Ҫ���¼�����û����ô�죿
	 * �������ǲɼ���һЩ���õ��������Ҫ�����¼� ���� ���Ѹ���ǩ��  
	 * 	     �����������Ŀ �û����˺ŵĺ��Ѹ�һ��ǩ�� �ͻ��յ���ǩ������Ϣ ����msgType�ǶԶ���Ȼ������Ӹ��жϾ����ˡ�
	 * 2.�������Ҫ��API����Core��û����ô�죿
	 * �������߱������Կ�������������TcpAPI��Դ��Ȼ���ո�ʽ����һ��APIȻ����Core��Ҳ����һ����Ӧ�ľͿ�����
	 *    ����㲻�߱������Կ����������Ⱥ742830386���ҷ�ӳ����Ҫ��API �һ��ڸ���ʱһ�����
	 * 3.��Ĳ�����շѻ���ԴΪ��ʲô��
	 * �����������������˵�ܼ򵥣�����������һ���Լ�����Ȼ��Խ��Խ�������ǾͿ�Դ���һ����
	 *    ��Դ����Ϊ�ҵ�ά��ʱ�䲻������Ҫ�Ŀ������޷��������ƣ������ҿ���ͷ ���� ���鷢��^_^
	 */
	
	static ChatClient clientTest;
	
	public static void main(String[] args) {
		clientTest = new ChatClient("127.0.0.1", 8404);
	    clientTest.start();
	} 

	/**
	 * �յ�������Ϣ���¼�
	 * @param data
	 */
	public static void receivePrivateMessages(String data){
		System.out.println("[�յ�������Ϣ]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			selfQQ = json.getLong("selfQQ");//���QQ
			fromQQ = json.getLong("fromQQ");//�Է�QQ
			random = json.getLong("random");//������Ϣ��
			req = json.getLong("req");//������Ϣ��
			String msg = json.getString("msg");//��Ϣ����
			long msgType = json.getLong("msgType");//��Ϣ����
			//long msgType2 = json.getInteger("msgType2");//��Ϣ����
			if(msgType == 141){//���ں���Ϣ
				
			}else if(msgType == 87){//����������Ⱥ
				
			}else if(msgType == 528){//�����Ϊ����
				
			}else if(msgType == 529){//�����ļ���Ϣ
				
			}else if(msgType == 208){//����������Ϣ
				req = 0L;
				random = 0L;
				Core.sendPrivateMessages(selfQQ, fromQQ, msg, random, req);
			}else if(msgType == 87){//����������Ⱥ
				
			}else if(msgType == 166){//��ͨ������Ϣ
				if(msg.equals("����")){
					Core.callpPraise(selfQQ,fromQQ,10);
					Core.sendPrivateMessages(selfQQ, fromQQ, "���޳ɹ�  +10", random, req);
				}
			}
		}catch (Exception e) {
			System.out.println("[���������쳣]");
		}
		
		//������ͳɹ�  "msgType":141,"msgType2":134,"msgTempType":129
		//87	����������Ⱥ
		//528	�����Ϊ����
		//166	�յ����Ѻ��
	}
	/**
	 * �յ�Ⱥ����Ϣ
	 * @param data
	 */
	public static void receiveGroupMessages(String data){
		System.out.println("[�յ�Ⱥ����Ϣ]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			selfQQ = json.getLong("selfQQ");//���QQ
			fromGroup = json.getLong("fromGroup");//Ⱥ��
			fromQQ = json.getLong("fromQQ");//�Է�QQ
			String msg = json.getString("msg");//��Ϣ����
			//������д��һЩ����ָ��
			if(msg.indexOf("����Ƭ") == 0){//Ĭ�ϸ��Լ��� ��  ����Ƭ404
				String cardName = msg.substring(msg.indexOf("����Ƭ") + 3);//ȡ���ұߵ���Ƭ
				Core.setGroupCardName(selfQQ, fromGroup, fromQQ, cardName);
			}
		}catch (Exception e) {
			System.out.println("[Ⱥ�������쳣]");
		}
		
		
		//134	�ϴ�Ⱥ�ļ�
		
	}
	
	/**
	 * �յ��¼���Ϣ
	 * @param data
	 */
	public static void receiveEventMessages(String data){
		System.out.println("[�յ��¼���Ϣ]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			long selfQQ = json.getLong("selfQQ");//���QQ
			long fromGroup = json.getLong("fromGroup");//Ⱥ��
			int msgType = json.getInteger("msgType");//����
			long triggerQQ = json.getLong("triggerQQ");//�Է�QQ
			//String triggerQQName = json.getString("triggerQQName");//�Է��ǳ�
			long seq = json.getLongValue("seq");//������
			
			//32��ʾQQ����
			//17��ʾ���Ѹ����ǳ�
			//25��ʾ���������Ⱥ��
			if(msgType == 3){//Ⱥ��֤�¼� ������Ⱥ
				Core.handleGroupEvent(selfQQ, fromGroup, triggerQQ, seq, 11, 3);
			}else if(msgType == 20){//�����Ϊ����
				Core.handlePrivateEvent(selfQQ, triggerQQ, seq, 1);
			}else if(msgType == 19){//���º���
				Core.sendPrivateMessages(selfQQ, triggerQQ, "���", 0, 0);
			}else if(msgType == 23){
				Core.callpPraise(selfQQ,triggerQQ,10);
			}
		}catch (Exception e) {
			System.out.println("[�¼������쳣]");
		}
		
	}
	
	/**
	 * �յ���ѯ����
	 * @param data
	 */
	public static void selectResult(String data){
		System.out.println("[�յ���ѯ����]" + data);
		JSONObject json = JSONObject.parseObject(data);
		//long selfQQ = json.getInteger("selfQQ");//���QQ
		int msgType = json.getInteger("msgType");//����
		if(msgType == 107){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[�����б���]" + list.size());
		}else if(msgType == 109){
			JSONObject userInfo = json.getJSONObject("info");
			System.out.println("[������Ϣ����]" + JSONObject.toJSONString(userInfo));
		}else if(msgType == 212){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[Ⱥ���б���]" + list.size());
		}else if(msgType == 213){
			JSONObject groupInfo = json.getJSONObject("info");
			System.out.println("[Ⱥ����Ϣ����]" + JSONObject.toJSONString(groupInfo));
		}else if(msgType == 214){
			String cardName = json.getString("cardName");
			System.out.println("[��ѯȺ��Ƭ����]" + cardName);
		}else if(msgType == 302){
			String path = json.getString("path");
			System.out.println("[���·������]" + path);
		}else if(msgType == 303){
			String picCode = json.getString("picCode");
			System.out.println("[�ϴ�ͼƬ����]" + picCode);
		}else if(msgType == 304){
			String audioCode = json.getString("audioCode");
			System.out.println("[�ϴ���������]" + audioCode);
			//�����첽
			long t = json.getLongValue("t");
			JSONObject jsonRes = StringUtils.queue.get(t);
			if(jsonRes.getBooleanValue("sync")){//ͬ������
				long selfQQ = jsonRes.getLongValue("selfQQ");
				long fromQQ = jsonRes.getLongValue("fromQQ");
				if(jsonRes.getIntValue("msgType") == 1){//����
					Core.sendPrivateMessages(selfQQ, fromQQ, audioCode, 0, 0);
				}else{//Ⱥ��
					Core.sendGroupMessages(selfQQ, fromQQ, audioCode, 0);
				}
			}
		}else if(msgType == 305){
			String skey = json.getString("skey");
			System.out.println("[��ȡskey����]" + skey);
		}else if(msgType == 306){
			String pskey = json.getString("pskey");
			System.out.println("[��ȡpskey����]" + pskey);
		}else if(msgType == 307){
			String clientkey = json.getString("clientkey");
			System.out.println("[��ȡclientkey����]" + clientkey);
		}else if(msgType == 308){
			String nickName = json.getString("nickName");
			System.out.println("[��ȡnickName����]" + nickName);
		}
		
		
	}
}
