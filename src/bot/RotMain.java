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
 * 主要类
 * @author zhaoqk
 *
 * 2020年8月10日 下午5:07:37
 */
public class RotMain {
	public static long qq = 0l;
	public static boolean flag = false;
	public static boolean done = false;
	public static boolean hello = true;
	public static boolean key = false;
	/**
	 * 程序简介
	 * 1.如果我需要的事件下面没有怎么办？
	 * 答：作者是采集了一些常用的如果你需要其他事件 比如 好友更改签名  
	 * 	     那你就启动项目 用机器人号的好友改一下签名 就会收到改签名的消息 看看msgType是对多少然后下面加个判断就行了。
	 * 2.如果我需要的API操作Core中没有怎么办？
	 * 答：如果你具备易语言开发能力请下载TcpAPI的源码然后按照格式增加一个API然后在Core中也增加一个对应的就可以了
	 *    如果你不具备易语言开发能力请加群742830386向我反映你需要的API 我会在更新时一块加上
	 * 3.你的插件不收费还开源为了什么？
	 * 答：这个东西对于我来说很简单，本来打算做一个自己玩玩然后越做越完善于是就开源大家一起玩
	 *    开源是因为我的维护时间不多你需要的可能我无法帮你完善，所以我开个头 你们 尽情发挥^_^
	 */
	
	static ChatClient clientTest;
	
	public static void main(String[] args) {
		clientTest = new ChatClient("127.0.0.1", 8404);
	    clientTest.start();
	} 

	/**
	 * 收到好友消息与事件
	 * @param data
	 */
	public static void receivePrivateMessages(String data){
		System.out.println("[收到好友消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			long selfQQ = json.getLong("selfQQ");//框架QQ
			long fromQQ = json.getLong("fromQQ");//对方QQ
			long random = json.getLong("random");//撤回消息用
			long req = json.getLong("req");//撤回消息用
			String msg = json.getString("msg");//消息内容
			long msgType = json.getLong("msgType");//消息类型
			//long msgType2 = json.getInteger("msgType2");//消息类型
			if(msgType == 141){//公众号消息
				
			}else if(msgType == 87){//好友邀请入群
				
			}else if(msgType == 528){//申请加为好友
				
			}else if(msgType == 529){//好友文件消息
				
			}else if(msgType == 208){//好友语音消息
				req = 0L;
				random = 0L;
				Core.sendPrivateMessages(selfQQ, fromQQ, msg, random, req);
			}else if(msgType == 87){//好友邀请入群
				
			}else if(msgType == 166){//普通好友消息
				if (msg.equals("关闭setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu已关闭。", random, req);
				}else if (msg.equals("启动setu") && fromQQ == qq){
					done = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu已启动。", random, req);
				}else if (msg.equals("高清图片") && fromQQ == qq){
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "已设置为高清模式，注意可能卡图，请尽量选择标准涩图。", random, req);
				}else if (msg.equals("标准图片") && fromQQ == qq) {
					flag = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "已设置为标准模式。", random, req);
				}else if (msg.equals("管理setu")){
					System.out.println(msg);
					if (key == false){
						qq = fromQQ;
						Core.sendPrivateMessages(selfQQ, fromQQ, qq + "已设置为管理员！", random, req);
						key = true;
					}else {
						Core.sendPrivateMessages(selfQQ, fromQQ, "管理员达到上限！", random, req);
						return;
					}
				}else if (msg.equals("关闭同意好友") && fromQQ == qq){
					hello = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "自动同意好友已关闭。", random, req);
				}else if (msg.equals("启动同意好友") && fromQQ == qq){
					hello = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "自动同意好友已启动。", random, req);
				}
				//=======================================================================================
				if (done == true){
					return;
				}
				else if (done == false){
					if (flag == false){
						if(msg.equals("setu插")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu插已启动", random, req);
						}else if (msg.equals("setu") || msg.equals("色图") || msg.equals("涩图") || msg.equals("开车") || msg.equals("车车") || msg.equals("发车") || msg.equals("不够色") || msg.equals("不够涩")){
							new pack().packpic(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("涩图组") == 0 || msg.indexOf("色图组") == 0 || msg.indexOf("setu组") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "涩图组" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}else if (msg.indexOf("新涩图") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "涩图组" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}
					}
					else if (flag == true){
						if(msg.equals("setu插")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu插已启动", random, req);
						}else if (msg.equals("setu")){
							new pack().packimg(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("涩图组") == 0){
							new pack().packimgs(selfQQ,fromQQ,msg,req,random);
						}
					}
				}

			}else if (msgType == 141){
				if (done == false){
					if (flag == false){
						if(msg.equals("setu插")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu插已启动", random, req);
						}else if (msg.equals("setu") || msg.equals("色图") || msg.equals("涩图") || msg.equals("开车") || msg.equals("车车") || msg.equals("发车") || msg.equals("不够色") || msg.equals("不够涩")){
							new pack().packpic(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("涩图组") == 0 || msg.indexOf("色图组") == 0 || msg.indexOf("setu组") == 0){
							msg = msg.substring(msg.length()-1);
							msg = "涩图组" + msg;
							new pack().pcakpics(selfQQ,fromQQ,msg,req,random);
						}
					}
					else if (flag == true){
						if(msg.equals("setu插")){
							Core.sendPrivateMessages(selfQQ, fromQQ, "setu插已启动", random, req);
						}else if (msg.equals("setu")){
							new pack().packimg(selfQQ, fromQQ,req,random);
						}else if (msg.indexOf("涩图组") == 0){
							new pack().packimgs(selfQQ,fromQQ,msg,req,random);
						}
					}
				}else if (done == true){
					return;
				}else if (msg.equals("关闭setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu已关闭。", random, req);
				}else if (msg.equals("启动setu") && fromQQ == qq){
					done = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "setu已启动。", random, req);
				}else if (msg.equals("高清图片") && fromQQ == qq){
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "已设置为高清模式，注意可能卡图，请尽量选择标准涩图。", random, req);
				}else if (msg.equals("标准图片") && fromQQ == qq) {
					flag = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "已设置为标准模式。", random, req);
				}else if (msg.equals("管理setu")){
					if (key == false){
						qq = fromQQ;
						Core.sendPrivateMessages(selfQQ, fromQQ, qq + "已设置为管理员！", random, req);
						key = true;
					}else {
						Core.sendPrivateMessages(selfQQ, fromQQ, "管理员达到上限！", random, req);
						return;
					}
				}else if (msg.equals("关闭同意好友") && fromQQ == qq){
					hello = false;
					Core.sendPrivateMessages(selfQQ, fromQQ, "自动同意好友已关闭。", random, req);
				}else if (msg.equals("启动同意好友") && fromQQ == qq){
					hello = true;
					Core.sendPrivateMessages(selfQQ, fromQQ, "自动同意好友已启动。", random, req);
				}

			}
		}catch (Exception e) {
			System.out.println("[好友数据异常]");
		}
		
		//红包发送成功  "msgType":141,"msgType2":134,"msgTempType":129
		//87	好友邀请入群
		//528	申请加为好友
		//166	收到好友红包
	}
	/**
	 * 收到群聊消息
	 * @param data
	 */
	public static void receiveGroupMessages(String data){
		System.out.println("[收到群聊消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			long selfQQ = json.getLong("selfQQ");//框架QQ
			long fromGroup = json.getLong("fromGroup");//群号
			long fromQQ = json.getLong("fromQQ");//对方QQ
			String msg = json.getString("msg");//消息内容
			//这里我写了一些常用指令
			/**
			 * setu
			 */
			if (done == false){
				if (flag == false){
					if (msg.equals("setu") || msg.equals("色图") || msg.equals("涩图") || msg.equals("开车") || msg.equals("车车") || msg.equals("发车") || msg.equals("不够色") || msg.equals("不够涩")){
						new pack().packpic(selfQQ, fromGroup);
					}else if (msg.indexOf("涩图组") == 0 || msg.indexOf("色图组") == 0 || msg.indexOf("setu组") == 0){
						new pack().pcakpics(selfQQ,fromGroup,msg);
					}else if (msg.indexOf("提取") == 0){	//图片太大功能取消
//						new tiqu(msg).catchpic(selfQQ,fromGroup);
					}else if (msg.equals("cos图")){	//辣眼睛神作
						new pack().cospackpic(selfQQ, fromGroup);
					}
				}
				else if (flag == true){
					if (msg.equals("setu") || msg.equals("色图") || msg.equals("涩图") || msg.equals("开车") || msg.equals("车车") || msg.equals("发车") || msg.equals("不够色") || msg.equals("不够涩")){
						new pack().packimg(selfQQ, fromGroup);
					}else if (msg.indexOf("涩图组") == 0 || msg.indexOf("色图组") == 0 || msg.indexOf("setu组") == 0){
						new pack().packimgs(selfQQ,fromGroup,msg);
					}
				}
			}
			else if (done == true){
				System.out.println("插件已关闭");
				return;
			}

		}catch (Exception e) {
			System.out.println("[群聊数据异常]");
		}
		//134	上传群文件
	}
	
	/**
	 * 收到事件消息
	 * @param data
	 */
	public static void receiveEventMessages(String data){
		System.out.println("[收到事件消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			long selfQQ = json.getLong("selfQQ");//框架QQ
			long fromGroup = json.getLong("fromGroup");//群号
			int msgType = json.getInteger("msgType");//类型
			long triggerQQ = json.getLong("triggerQQ");//对方QQ
			//String triggerQQName = json.getString("triggerQQName");//对方昵称
			long seq = json.getLongValue("seq");//操作用
			
			//32表示QQ上线
			//17表示好友更改昵称
			//25表示邀请加入了群聊
			if(msgType == 3){//群验证事件 申请入群
				//Core.handleGroupEvent(selfQQ, fromGroup, triggerQQ, seq, 11, 3);
			}else if(msgType == 105){//申请加为好友
				if (hello = true){
					Core.handlePrivateEvent(selfQQ, triggerQQ, seq, 1);
				}else {
					return;
				}
			}else if(msgType == 19){//有新好友
//				Core.sendPrivateMessages(selfQQ, triggerQQ, "哈喽", 0, 0);
			}else if(msgType == 23){
				Core.callpPraise(selfQQ,triggerQQ,10);
			}
		}catch (Exception e) {
			System.out.println("[事件数据异常]");
		}
		
	}
	
	/**
	 * 收到查询返回
	 * @param data
	 */
	public static void selectResult(String data){
		System.out.println("[收到查询返回]" + data);
		JSONObject json = JSONObject.parseObject(data);
		//long selfQQ = json.getInteger("selfQQ");//框架QQ
		int msgType = json.getInteger("msgType");//类型
		if(msgType == 107){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[好友列表返回]" + list.size());
		}else if(msgType == 109){
			JSONObject userInfo = json.getJSONObject("info");
			System.out.println("[好友信息返回]" + JSONObject.toJSONString(userInfo));
		}else if(msgType == 212){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[群聊列表返回]" + list.size());
		}else if(msgType == 213){
			JSONObject groupInfo = json.getJSONObject("info");
			System.out.println("[群聊信息返回]" + JSONObject.toJSONString(groupInfo));
		}else if(msgType == 214){
			String cardName = json.getString("cardName");
			System.out.println("[查询群名片返回]" + cardName);
		}else if(msgType == 302){
			String path = json.getString("path");
			System.out.println("[插件路径返回]" + path);
		}else if(msgType == 303){
			String picCode = json.getString("picCode");
			System.out.println("[上传图片返回]" + picCode);
		}else if(msgType == 304){
			String audioCode = json.getString("audioCode");
			System.out.println("[上传语音返回]" + audioCode);
			//处理异步
			long t = json.getLongValue("t");
			JSONObject jsonRes = StringUtils.queue.get(t);
			if(jsonRes.getBooleanValue("sync")){//同步发送
				long selfQQ = jsonRes.getLongValue("selfQQ");
				long fromQQ = jsonRes.getLongValue("fromQQ");
				if(jsonRes.getIntValue("msgType") == 1){//好友
					Core.sendPrivateMessages(selfQQ, fromQQ, audioCode, 0, 0);
				}else{//群聊
					Core.sendGroupMessages(selfQQ, fromQQ, audioCode, 0);
				}
			}
		}else if(msgType == 305){
			String skey = json.getString("skey");
			System.out.println("[获取skey返回]" + skey);
		}else if(msgType == 306){
			String pskey = json.getString("pskey");
			System.out.println("[获取pskey返回]" + pskey);
		}else if(msgType == 307){
			String clientkey = json.getString("clientkey");
			System.out.println("[获取clientkey返回]" + clientkey);
		}else if(msgType == 308){
			String nickName = json.getString("nickName");
			System.out.println("[获取nickName返回]" + nickName);
		}
		
		
	}
}
