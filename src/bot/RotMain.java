package bot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pic.pic;
import pic.Getpic;

import java.util.concurrent.TimeUnit;

import pic.pack;
import pic.tiqu;
import pic.*;


/**
 * ��Ҫ��
 * @author zhaoqk
 *
 * 2020��8��10�� ����5:07:37
 */
public class RotMain {
	public static long qq = 0l;
	public static boolean flag = false;
	public static boolean done = false;
	public static boolean hello = true;
	public static boolean key = false;
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
			long selfQQ = json.getLong("selfQQ");//���QQ
			long fromQQ = json.getLong("fromQQ");//�Է�QQ
			long random = json.getLong("random");//������Ϣ��
			long req = json.getLong("req");//������Ϣ��
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
				if (msg.equals("�ر�setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu�ѹرա�", random, req);
				}else if (msg.equals("����setu") && fromQQ == qq){
					done = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
				}else if (msg.equals("����ͼƬ") && fromQQ == qq){
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "������Ϊ����ģʽ��ע����ܿ�ͼ���뾡��ѡ���׼ɬͼ��", random, req);
				}else if (msg.equals("��׼ͼƬ") && fromQQ == qq) {
					flag = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "������Ϊ��׼ģʽ��", random, req);
				}else if (msg.equals("����setu")){
					System.out.println(msg);
					if (key == false){
						qq = fromQQ;
						Core.sendPrivateMessages(selfQQ, fromQQ, qq + "������Ϊ����Ա��", random, req);
						key = true;
					}else {
						Core.sendPrivateMessages(selfQQ, fromQQ, "����Ա�ﵽ���ޣ�", random, req);
						return;
					}
				}else if (msg.equals("�ر�ͬ�����") && fromQQ == qq){
					hello = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "�Զ�ͬ������ѹرա�", random, req);
				}else if (msg.equals("����ͬ�����") && fromQQ == qq){
					hello = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "�Զ�ͬ�������������", random, req);
				}
				//=======================================================================================
				if (done == true){
					return;
				}
				else if (done == false){
					if (flag == false){
						if(msg.equals("setu��")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
						}else if (msg.equals("setu") || msg.equals("ɫͼ") || msg.equals("ɬͼ") || msg.equals("����") || msg.equals("����") || msg.equals("����") || msg.equals("����ɫ") || msg.equals("����ɬ")){
							new pack().packpic(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("ɬͼ��") == 0 || msg.indexOf("ɫͼ��") == 0 || msg.indexOf("setu��") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "ɬͼ��" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}else if (msg.indexOf("��ɬͼ") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "ɬͼ��" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}
					}
					else if (flag == true){
						if(msg.equals("setu��")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
						}else if (msg.equals("setu")){
							new pack().packimg(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("ɬͼ��") == 0){
							new pack().packimgs(selfQQ,fromQQ,msg,req,random);
						}
					}
				}

			}else if (msgType == 141){
				if (done == false){
					if (flag == false){
						if(msg.equals("setu��")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
						}else if (msg.equals("setu") || msg.equals("ɫͼ") || msg.equals("ɬͼ") || msg.equals("����") || msg.equals("����") || msg.equals("����") || msg.equals("����ɫ") || msg.equals("����ɬ")){
							new pack().packpic(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("ɬͼ��") == 0 || msg.indexOf("ɫͼ��") == 0 || msg.indexOf("setu��") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "ɬͼ��" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}
					}
					else if (flag == true){
						if(msg.equals("setu��")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
						}else if (msg.equals("setu")){
							new pack().packimg(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("ɬͼ��") == 0){
							new pack().packimgs(selfQQ,fromQQ,msg,req,random);
						}
					}
				}else if (done == true){
					return;
				}else if (msg.equals("�ر�setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu�ѹرա�", random, req);
				}else if (msg.equals("����setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu��������", random, req);
				}else if (msg.equals("����ͼƬ") && fromQQ == qq){
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "������Ϊ����ģʽ��ע����ܿ�ͼ���뾡��ѡ���׼ɬͼ��", random, req);
				}else if (msg.equals("��׼ͼƬ") && fromQQ == qq) {
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "������Ϊ��׼ģʽ��", random, req);
				}else if (msg.equals("����setu")){
					if (key == false){
						qq = fromQQ;
						Core.sendPrivateMessages(selfQQ, fromQQ, qq + "������Ϊ����Ա��", random, req);
						key = true;
					}else {
						Core.sendPrivateMessages(selfQQ, fromQQ, "����Ա�ﵽ���ޣ�", random, req);
						return;
					}
				}else if (msg.equals("�ر�ͬ�����") && fromQQ == qq){
					hello = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "�Զ�ͬ������ѹرա�", random, req);
				}else if (msg.equals("����ͬ�����") && fromQQ == qq){
					hello = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "�Զ�ͬ�������������", random, req);
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
			long selfQQ = json.getLong("selfQQ");//���QQ
			long fromGroup = json.getLong("fromGroup");//Ⱥ��
			long fromQQ = json.getLong("fromQQ");//�Է�QQ
			String msg = json.getString("msg");//��Ϣ����
			//������д��һЩ����ָ��
			/**
			 * setu
			 */
			if (done == false){
				if (flag == false){
					if (msg.equals("setu") || msg.equals("ɫͼ") || msg.equals("ɬͼ") || msg.equals("����") || msg.equals("����") || msg.equals("����") || msg.equals("����ɫ") || msg.equals("����ɬ")){
						new pack().packpic(selfQQ, fromGroup);
					}else if (msg.indexOf("ɬͼ��") == 0 || msg.indexOf("ɫͼ��") == 0 || msg.indexOf("setu��") == 0){
						new pack().pcakpics(selfQQ,fromGroup,msg);
					}else if (msg.indexOf("��ȡ") == 0){	//ͼƬ̫����ȡ��
//						new tiqu(msg).catchpic(selfQQ,fromGroup);
					}else if (msg.equals("cosͼ")){	//���۾�����
						new pack().cospackpic(selfQQ, fromGroup);
					}
				}
				else if (flag == true){
					if (msg.equals("setu") || msg.equals("ɫͼ") || msg.equals("ɬͼ") || msg.equals("����") || msg.equals("����") || msg.equals("����") || msg.equals("����ɫ") || msg.equals("����ɬ")){
						new pack().packimg(selfQQ, fromGroup);
					}else if (msg.indexOf("ɬͼ��") == 0 || msg.indexOf("ɫͼ��") == 0 || msg.indexOf("setu��") == 0){
						new pack().packimgs(selfQQ,fromGroup,msg);
					}
				}
			}
			else if (done == true){
				System.out.println("����ѹر�");
				return;
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
				//Core.handleGroupEvent(selfQQ, fromGroup, triggerQQ, seq, 11, 3);
			}else if(msgType == 105){//�����Ϊ����
				if (hello = true){
					Core.handlePrivateEvent(selfQQ, triggerQQ, seq, 1);
				}else {
					return;
				}
			}else if(msgType == 19){//���º���
//				Core.sendPrivateMessages(selfQQ, triggerQQ, "���", 0, 0);
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
