package first.controller;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.yunpian.sdk.util.JsonUtil;

public class SendSimpleMessage {
	
	public static void main(String[] args) {
		ClientResponse res=SendSimpleMessage();
		
	}
	
	
	public static ClientResponse SendSimpleMessage() {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", "key-0adb2be4deee3809c326f45c628c1e14"));
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/noreply.lifewow.io/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "postmaster@noreply.lifewow.io");
	//    formData.add("to", "chuyh@medishare.cn");
	    formData.add("to", "807640981@qq.com");
	    formData.add("subject", "Hello chuyouhong");
	    formData.add("text", "Congratulations chuyouhong, you just sent an email with Mailgun!  You are truly awesome!");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                        post(ClientResponse.class, formData);
	}

}
