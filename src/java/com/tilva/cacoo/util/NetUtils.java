package com.tilva.cacoo.util;

import com.tilva.cacoo.exception.GenericException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URL;
import java.util.List;

import static  com.tilva.cacoo.util.CacooConstants.API_BASE;
import static com.tilva.cacoo.util.CacooConstants.API_VER;


/**
 *
 * @author mtilva
 */
public class NetUtils {

     
    public static List<String> getDiagramsStringValues(String attr, String apiKey) throws IOException, MalformedURLException, GenericException, JSONException {
        List<String> attrList = new ArrayList<>();
        String url = API_BASE + API_VER + CacooConstants.DIAGRAMS_API + ".json?apiKey=" + apiKey;
        URL requestUrl = new URL(url);
        
            JSONObject resp = getJSONResponse(requestUrl);

            JSONArray jsonDiagramArray = resp.getJSONArray("result");
            for (int i = 0; i < jsonDiagramArray.length(); i++) {
                JSONObject diagramObj = jsonDiagramArray.getJSONObject(i);
                attrList.add(diagramObj.getString(attr));
            }
         
        return attrList;
    }

    private static JSONObject getJSONResponse(URL url) throws MalformedURLException, IOException, JSONException, GenericException {
        
        HttpURLConnection conn = null;
        BufferedReader br = null;
        try {

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                throw new GenericException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            StringBuilder sb = new StringBuilder();

            while ((output = br.readLine()) != null) {
                sb.append(output);               
            }
            
            return new JSONObject(sb.toString());

        } finally{
            if(conn!=null) conn.disconnect();
            if(br!=null) br.close();
        } 
        
    }

    public static void deleteDiagram(String id, String apiKey) throws MalformedURLException, IOException, GenericException {
      

        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL("https://cacoo.com/api/v1/diagrams/" +id + "/delete.json?apiKey=" + apiKey);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 403) {
                String s =conn.getResponseMessage();
                throw new GenericException("Failed : HTTP error code : " + conn.getResponseCode() 
                                                +"\nMessage: " + s + " Diagram is currently being edited or you are not the owner.");                
            }else if(conn.getResponseCode()!=200){
                throw new GenericException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
        }  finally{
            if(conn!=null) conn.disconnect();
        }
    }
}
