
import com.jayway.restassured.response.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.*;



import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.put;


public class Main {
    public static void main(String[] args) throws IOException {

        // Apache HttpComponents

        // выполняем запрос get для доступа ко всем параметрам ответа
       HttpGet httpget = new HttpGet("https://api.github.com/repos/EkaterinaSvitina/hometasks1/collaborators?access_token=f9173ce17e32ce09719b9b571edd36de0e5ce11c");
       HttpClient client = HttpClientBuilder.create().build();
       HttpResponse response = client.execute(httpget);

       String string = EntityUtils.toString(response.getEntity( ));
       JSONArray array = new JSONArray(string);
       String result = array.getJSONObject(0).getString("login");

       System.out.println(result);

       //отправляем приглос пользователю
        HttpPut put = new HttpPut("https://api.github.com/repos/EkaterinaSvitina/hometasks1/collaborators/DenisAnischenko?access_token=f9173ce17e32ce09719b9b571edd36de0e5ce11c");

        // RestAssurance

        // выполняем запрос get для доступа ко всем параметрам ответа
        Response resp = get("https://api.github.com/repos/EkaterinaSvitina/hometasks1/collaborators?access_token=f9173ce17e32ce09719b9b571edd36de0e5ce11c");

        JSONArray jsonResponse1 = new JSONArray(resp.asString());

        String result1 = jsonResponse1.getJSONObject(0).getString("login");

        System.out.println(result1);

        //отправляем приглос пользователю
        Response resp1 = put("https://api.github.com/repos/EkaterinaSvitina/hometasks1/collaborators/DenisAnischenko?access_token=f9173ce17e32ce09719b9b571edd36de0e5ce11c");

    }

}
