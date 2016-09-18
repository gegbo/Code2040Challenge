import java.io.*;
import org.json.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Registration {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		try {
			json.put("token", "34722e711de1f3f65d84c5bdf7c643d0");
			json.put("github","https://github.com/gegbo/Code2040Challenge");
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			try {
			    HttpPost request = new HttpPost("http://challenge.code2040.org/api/register");
			    StringEntity params = new StringEntity(json.toString());
			    request.addHeader("content-type", "application/json");
			    request.setEntity(params);
			    httpClient.execute(request);
			// handle response here...
			} catch (Exception ex) 
			{
			    // handle exception here
			} finally {
			    try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
