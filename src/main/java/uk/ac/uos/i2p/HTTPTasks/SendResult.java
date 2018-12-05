package main.java.uk.ac.uos.i2p.HTTPTasks;
import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class SendResult {
    public void main() throws Exception {

    	System.out.println("Cake");
    	String[] args = {"http://i2j.openode.io/answer/d3ae45","68"};
    	
            URL url = new URL("http://i2j.openode.io/answer/d3ae45");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("name","Cake");
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            for (int c; (c = in.read()) >= 0;)
                System.out.print((char)c);
        }
    	
    }