package zou.springboot.gogogo.bean;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 登录配置项
 * @author ruiyun077
 *
 */
@Component
@ConfigurationProperties(prefix = "ruiyun")
public class LoginConfiguration {
//	private static final String TAOBAO_AUTH_PARAM = "{0}?response_type={1}&client_id={2}&redirect_uri={3}&state={4}&view={5}";
	/**
	 * 淘宝登录参数格式化模板
	 */
//	private static final MessageFormat FORMAT_PARAMS = new MessageFormat(TAOBAO_AUTH_PARAM);
	private String login_platform_name;
	private String app_id;
	private String app_secret;
	private String auth_url;
	private String token_url;
	private String resp_url;
	private String login_url;
	private String url_prefix;
	private String view;
	private String grant_type;
	private String response_type;
	private String redirect_uri;
	private String redirect_result_uri;
	private String state;
	private int extend_prop;
	private String need_filter_url;

	public String getAuthUrl(String formatParams) {
		/**
		 * 淘宝登录参数格式化模板
		 */
		return new MessageFormat(formatParams).format(getParams());
	}

	/**
	 * Token请求参数列表
	 * @param code
	 * @return
	 */
	public Map<String, String> getPlatFormTokenParams(String code) {
		Map<String, String> params=new HashMap<String,String>();
    	params.put("code", code);
    	params.put("grant_type", this.getGrant_type());
    	params.put("client_id", this.getApp_id());
    	params.put("client_secret", this.getApp_secret());
    	params.put("redirect_uri", this.getRedirect_result_uri());
		return params;
	}
	
	private Object[] getParams() {
		return new String[] { this.auth_url,this.response_type, this.app_id, this.getRedirect_uri(), this.state, this.view };
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getApp_secret() {
		return app_secret;
	}

	public void setApp_secret(String app_secret) {
		this.app_secret = app_secret;
	}

	public String getAuth_url() {
		return auth_url;
	}

	public void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}

	public String getResp_url() {
		return resp_url;
	}

	public void setResp_url(String resp_url) {
		this.resp_url = resp_url;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getResponse_type() {
		return response_type;
	}

	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}

	public String getRedirect_uri() {
		return this.url_prefix+redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getToken_url() {
		return token_url;
	}

	public void setToken_url(String token_url) {
		this.token_url = token_url;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getRedirect_result_uri() {
		return this.url_prefix+redirect_result_uri;
	}

	public void setRedirect_result_uri(String redirect_result_uri) {
		this.redirect_result_uri = redirect_result_uri;
	}

	public String getLogin_url() {
		return this.url_prefix+login_url;
	}

	public void setLogin_url(String login_url) {
		this.login_url = login_url;
	}

	public String getUrl_prefix() {
		return url_prefix;
	}

	public void setUrl_prefix(String url_prefix) {
		this.url_prefix = url_prefix;
	}

	public String getNeed_filter_url() {
		return need_filter_url;
	}

	public void setNeed_filter_url(String need_filter_url) {
		this.need_filter_url = need_filter_url;
	}

	public String getLogin_platform_name()
	{
		return login_platform_name;
	}

	public void setLogin_platform_name( String login_platform_name )
	{
		this.login_platform_name = login_platform_name;
	}

	public boolean notLogin(String urlFilter)
	{
		String[] filterUrls = need_filter_url.split(",");
		for(int i =0;i<filterUrls.length;i++){
			if(urlFilter.indexOf(filterUrls[i])>=0){
				return true;
			}
		}
		return false;
	}

	public int getExtend_prop()
	{
		return extend_prop;
	}

	public void setExtend_prop( int extend_prop )
	{
		this.extend_prop = extend_prop;
	}
	
	

}
