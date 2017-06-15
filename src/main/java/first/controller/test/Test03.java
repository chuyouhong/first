package first.controller.test;

import com.yunpian.sdk.model.ResultDO;
import com.yunpian.sdk.model.SendVoiceInfo;
import com.yunpian.sdk.service.VoiceOperator;
import com.yunpian.sdk.service.YunpianRestClient;

public class Test03 {
	
	public static void main(String[] args) {
		testVoice("2a3eb3f78328e714649587dab62fa4ee", "18721580879", "111111");
	}
	
	public static void testVoice(String apikey, String mobile, String code) {
	    YunpianRestClient client = new YunpianRestClient(apikey);//用apikey生成client,可作为全局静态变量
	    VoiceOperator voiceOperator = client.getVoiceOperator();//获取语音操作类
	    ResultDO<SendVoiceInfo> resultDO = voiceOperator.send(mobile, code);// 发送语音验证码
	    System.out.println(resultDO);
	    //ResultDO<List<VoiceStatusInfo>> result = voiceOperator.pullStatus();// 拉取语音状态报告
	    //System.out.println(result);
	}
	
}


