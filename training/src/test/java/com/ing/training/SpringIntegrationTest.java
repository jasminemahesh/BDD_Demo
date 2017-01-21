package com.ing.training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class SpringIntegrationTest {
    
    RestTemplate restTemplate;
    Response response=null;
    
    public void execute(String url, HttpMethod httpMethod)
    {
	restTemplate=new RestTemplate();  
	ResponseExtractor<Response> responseExtractor=new ResponseExtractor<Response>() {
	    
	    public Response extractData(ClientHttpResponse httpResponse) throws IOException{
		return new Response(httpResponse);
	    }
	};
	response= restTemplate.execute(url, httpMethod, getRequestCallBack(), responseExtractor, new Object[]{});
    }

    private RequestCallback getRequestCallBack()
    {
	final Map<String, String> httpHeaders=new HashMap<String, String>();
	httpHeaders.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
	return new RequestCallback() {
	    
	    //@Override
	    public void doWithRequest(ClientHttpRequest request) throws IOException {
		request.getHeaders().setAll(httpHeaders);
		
	    }
	};
    }
   
}
