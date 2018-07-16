package wechat;

import org.json.JSONException; 
import org.json.JSONObject; 

public class MenuSetting {

	public static String appId = "wx60428b986b93ceeb";
    public static String appSecret= "b4dcb563597b3085486b13d8c03f7a34"; 
    
	public static void main(String[] args) throws JSONException {
		add();
		//delete();
	}

    public static String getAccessToken() throws JSONException{
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",appId,appSecret);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
        //JSONObject json = JSONObject.fromObject(result);
        JSONObject json = new JSONObject(result);
        return  json.getString("access_token");
    }
    
    public static void delete() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", s);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
    }
    
    public static void add() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String json = "{"
        		+ "\"button\":["
        		+ "{"
        		+ "\"name\":\"趣味答题\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"开始答题\","
                + "\"url\":\"http://em3ttj.natappfree.cc/weather/qa.html\""
                + "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"我的排名\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"个人排名\","
                + "\"url\":\"http://www.hnust.cn\""
             	+ "},"
             	 + "{"
                 + "\"type\":\"view\","
                 + "\"name\":\"班级排名\","
                 + "\"url\":\"http://www.hnust.cn\""
              	+ "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"成绩查询\","
                + "\"url\":\"https://study.ticknet.hnust.cn/#/score\""
             	+ "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"个人中心\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"关于我\","
                + "\"url\":\"http://www.hnust.cn/\""
                + "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"联系我\","
                + "\"url\":\"http://www.hnust.cn/\""
             	+ "}]"
        		+ "}]"
        		+ "}";
        System.out.println(json);
         
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", s);      
        String result = netHelper.getHttpsResponsePostBody(Url, "POST", json);
        System.out.println(result);
    }
    
}

