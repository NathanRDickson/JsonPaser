package main.java.uk.ac.uos.i2p.HTTPTasks;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendResult {
	
	String posturl;
	String answer;
	
	SendResult(String posturl, String answer) {
		this.posturl = posturl;
		this.answer = answer;
		
		
	}
	
	
	
    public void main() throws Exception {

    	String posturl = "/answer/7286";
    	String answer = "68";
    			
    			
    	 String url = "http://i2j.openode.io";
         url = url + posturl;
         URL finalposturl = new URL(url);
         HttpURLConnection con = (HttpURLConnection) finalposturl.openConnection();

         //add request header
         con.setRequestMethod("POST");
         
         // Send post request
         con.setDoOutput(true);
         DataOutputStream road = new DataOutputStream(con.getOutputStream());
         road.writeBytes(answer);
         road.flush();
         road.close();

         int responseCode = con.getResponseCode();
         System.out.println("\nSending 'POST' request to URL : " + url);
         System.out.println("Post parameters : " + answer);
         System.out.println("Response Code : " + responseCode);

         BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();

         while ((inputLine = in.readLine()) != null) {
                         response.append(inputLine);
         }
         in.close();
         
         //print result
         System.out.println(response.toString());

    	
    }
}

