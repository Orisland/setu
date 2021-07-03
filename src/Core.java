import com.alibaba.fastjson.JSONObject;

/**
 * ���Ĳ�����
 * @author zhaoqk
 *
 * 2020��8��10�� ����5:07:20
 */
public class Core {
	
	
	/**
	 * ����˽����Ϣ
	 * @param selfQQ	���QQ
	 * @param fromQQ	����QQ
	 * @param msg		���͵�����
	 * @param random	������Ϣ��
	 * @param req		������Ϣ��
	 */
	public static void sendPrivateMessages(long selfQQ,long fromQQ,String msg,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 101);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		System.out.println(json.toJSONString());
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ����˽��Json��Ϣ
	 * @param selfQQ	���QQ
	 * @param fromQQ	����QQ
	 * @param msg		���͵�Json����
	 * @param random	������Ϣ��
	 * @param req		������Ϣ��
	 */
	public static void sendPrivateMessagesJson(long selfQQ,long fromQQ,String msg,long random,int req){
		JSONObject json = new JSONObject();
		json.put("type", 102);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ����˽��ͼ����Ϣ
	 * @param selfQQ
	 * @param fromQQ
	 * @param msg
	 * @param random
	 * @param req
	 */
	public static void sendPrivateMessagesPicText(long selfQQ,long fromQQ,String msg,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 103);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ���������֤�¼�
	 * @param selfQQ	���QQ
	 * @param fromQQ	����QQ
	 * @param seq		���󸽴���seq
	 * @param status	�Ƿ�ͬ�� 1ͬ�� 2�ܾ�
	 */
	public static void handlePrivateEvent(long selfQQ,long fromQQ,long seq,int status){
		JSONObject json = new JSONObject();
		json.put("type", 104);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("seq", seq);
		json.put("status", status);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * QQ����
	 * @param selfQQ	���QQ
	 * @param fromQQ	����QQ
	 */
	public static void callpPraise(long selfQQ,long fromQQ,long number){
		JSONObject json = new JSONObject();
		json.put("type", 105);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("number", number);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ���ͺ��Ѻ��
	 * @param selfQQ	���QQ
	 * @param fromQQ	�Է�QQ
	 * @param number	�������
	 * @param balance	������ ��
	 * @param msg		ף����
	 * @param payPwd	֧������
	 */
	public static void pushRedPacket(long selfQQ,long fromQQ,long number,long balance,String msg,String payPwd){
		JSONObject json = new JSONObject();
		json.put("type", 106);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("number", number);
		json.put("balance", balance);
		json.put("payPwd", payPwd);
		json.put("msg", msg);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ȡ�����б�
	 * @param selfQQ
	 */
	public static void friendsList(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 107);
		json.put("selfQQ", selfQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ����˽����Ϣ
	 * @param selfQQ
	 * @param fromQQ
	 * @param random
	 * @param req
	 * @param time
	 */
	public static void withdrawPrivateMessages(long selfQQ,long fromQQ,long random,long req,long time){
		JSONObject json = new JSONObject();
		json.put("type", 108);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("random", random);
		json.put("req", req);
		json.put("time", time);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ѯ������Ϣ
	 * @param selfQQ
	 * @param fromQQ
	 */
	public static void selectFriendsInfo(long selfQQ,long fromQQ){
		JSONObject json = new JSONObject();
		json.put("type", 109);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	
	
	
	
	
	/**
	 * ����Ⱥ����Ϣ
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param msg		���͵�����
	 * @param anonymous	�Ƿ����� 0�� 1��
	 */
	public static void sendGroupMessages(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 201);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("msg", msg);
		json.put("anonymous", anonymous);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ����Ⱥ����Ϣ
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param msg		���͵�Json����
	 * @param anonymous	�Ƿ����� 0�� 1��
	 */
	public static void sendGroupMessagesJson(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 202);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("anonymous", anonymous);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ����Ⱥͼ����Ϣ
	 * @param selfQQ
	 * @param fromGroup
	 * @param msg
	 * @param anonymous
	 */
	public static void sendGroupMessagesPicText(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 203);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("msg", msg);
		json.put("anonymous", anonymous);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ����Ⱥ��֤�¼�
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param fromQQ	������QQ
	 * @param seq		���󸽴���seq
	 * @param status	11ͬ�� 12�ܾ�  14����
	 * @param fromType	3ĳ�������Ⱥ 1�ұ��������Ⱥ
	 */
	public static void handleGroupEvent(long selfQQ,long fromGroup,long fromQQ,long seq,int status,int fromType){
		JSONObject json = new JSONObject();
		json.put("type", 204);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("seq", seq);
		json.put("status", status);
		json.put("fromType", fromType);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ����Ⱥ��Ƭ
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param fromQQ	�Է�QQ
	 * @param cardName	Ⱥ��Ƭ
	 */
	public static void setGroupCardName(long selfQQ,long fromGroup,long fromQQ,String cardName){
		JSONObject json = new JSONObject();
		json.put("type", 205);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("cardName", cardName);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ɾ��Ⱥ��Ա
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param fromQQ	�Է�QQ
	 * @param refuse	�ܾ���Ⱥ���� 0�� 1��
	 */
	public static void delGroupMember(long selfQQ,long fromGroup,long fromQQ,int refuse){
		JSONObject json = new JSONObject();
		json.put("type", 206);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("refuse", refuse);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * Ⱥ����
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param fromQQ	�Է�QQ
	 * @param second	ʱ�� ��
	 */
	public static void prohibitSpeak(long selfQQ,long fromGroup,long fromQQ,int second){
		JSONObject json = new JSONObject();
		json.put("type", 207);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("second", second);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ����Ⱥ��Ϣ
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param random	��Ϣ������random
	 * @param req		��Ϣ������req
	 */
	public static void withdrawGroupMessages(long selfQQ,long fromGroup,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 208);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("random", random);
		json.put("req", req);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ����Ⱥ��ʱ��Ϣ
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param fromQQ	�Է�QQ
	 * @param msg		���͵�����
	 * @param random	������Ϣ��
	 * @param seq		������Ϣ��
	 */
	public static void sendGroupTempMessages(long selfQQ,long fromGroup,long fromQQ,String msg,long random,long seq){
		JSONObject json = new JSONObject();
		json.put("type", 209);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("seq", seq);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ����Ⱥ�ĺ��
	 * @param selfQQ	���QQ
	 * @param fromGroup	Ⱥ��
	 * @param number	�������
	 * @param balance	������  ��
	 * @param msg		ף����
	 * @param payPwd	֧������
	 */
	public static void pushRedPacketGroup(long selfQQ,long fromGroup,long number,long balance,String msg,String payPwd){
		JSONObject json = new JSONObject();
		json.put("type", 210);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("number", number);
		json.put("balance", balance);
		json.put("payPwd", payPwd);
		json.put("msg", msg);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * ȫԱ����
	 * @param selfQQ
	 * @param fromGroup
	 * @param isOpen 0�ر� 1����
	 */
	public static void prohibitSpeakAll(long selfQQ,long fromGroup,long isOpen){
		JSONObject json = new JSONObject();
		json.put("type", 211);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("isOpen", isOpen);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ȡȺ�б�
	 * @param selfQQ
	 */
	public static void groupList(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 212);
		json.put("selfQQ", selfQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ѯȺ��Ϣ
	 * @param selfQQ
	 * @param fromGroup
	 */
	public static void selectGroupInfo(long selfQQ,long fromGroup){
		JSONObject json = new JSONObject();
		json.put("type", 213);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ѯȺ��Ƭ
	 * @param selfQQ
	 * @param fromGroup
	 * @param fromQQ
	 */
	public static void selectGroupCard(long selfQQ,long fromGroup,long fromQQ){
		JSONObject json = new JSONObject();
		json.put("type", 214);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * �����־
	 * @param msg		��־����
	 * @param fontColor	������ɫ
	 * @param bgColor	������ɫ
	 */
	public static void outputLog(String log,int fontColor,int bgColor){
		JSONObject json = new JSONObject();
		json.put("type", 301);
		json.put("log", log);
		json.put("fontColor", fontColor);
		json.put("bgColor", bgColor);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ѯ�������Ŀ¼
	 */
	public static void selectPluginPath(){
		JSONObject json = new JSONObject();
		json.put("type", 302);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * �ϴ�ͼƬ
	 * @param selfQQ	���QQ
	 * @param msgType	��Ϣ����  1����ͼƬ 2Ⱥ��ͼƬ
	 * @param fromGroup	�ϴ�����ͼƬʱΪ����QQ �ϴ�ȺͼƬʱΪȺ��
	 * @param flash		�Ƿ����� 0�� 1��
	 * @param pic		ͼƬBase64
	 */
	public static void uploadPic(long selfQQ,int msgType,long fromQQ,int flash,String pic){
		JSONObject json = new JSONObject();
		json.put("type", 303);
		json.put("selfQQ", selfQQ);
		json.put("msgType", msgType);
		json.put("fromQQ", fromQQ);
		json.put("flash", flash);
		json.put("pic", pic);
		Main.clientTest.sendMsg(json.toJSONString());
	}

	
	/**
	 * �ϴ����� ͬ������
	 * @param selfQQ	���QQ
	 * @param msgType	��Ϣ����  1�������� 2Ⱥ������
	 * @param fromQQ	�ϴ���������ʱΪ����QQ �ϴ�Ⱥ����ʱΪȺ��
	 * @param path		����·��
	 */
	public static void uploadAudioSync(long selfQQ,int msgType,long fromQQ,String path){
		JSONObject json = new JSONObject();
		json.put("type", 304);
		json.put("selfQQ", selfQQ);
		json.put("msgType", msgType);
		json.put("fromQQ", fromQQ);
		json.put("path", path);
		long t = StringUtils.getNum();
		json.put("t", t);
		json.put("sync", true);
		StringUtils.queue.put(t, json);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ȡ������Skey
	 * @param selfQQ
	 */
	public static void getSkey(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 305);
		json.put("selfQQ", selfQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ȡ������Pskey
	 * @param selfQQ
	 * @param field		��		tenpay.com;openmobile.qq.com;docs.qq.com;connect.qq.com;qzone.qq.com;
	 * 	vip.qq.com;gamecenter.qq.com;qun.qq.com;game.qq.com;qqweb.qq.com;ti.qq.com;office.qq.com;mail.qq.com;mma.qq.com��
	 */
	public static void getPskey(long selfQQ,String field){
		JSONObject json = new JSONObject();
		json.put("type", 306);
		json.put("selfQQ", selfQQ);
		json.put("field", field);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ȡ������Clientkey
	 * @param selfQQ
	 */
	public static void getClientkey(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 307);
		json.put("selfQQ", selfQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * ��ѯQQ�ǳ�
	 * @param selfQQ
	 * @param fromQQ
	 */
	public static void selectNickName(long selfQQ,long fromQQ){
		JSONObject json = new JSONObject();
		json.put("type", 308);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	/**
	 * �������
	 */
	public static void restart(){
		JSONObject json = new JSONObject();
		json.put("type", 309);
		Main.clientTest.sendMsg(json.toJSONString());
	}
	
	

}
