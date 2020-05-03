package com.hebut.ctalk.jsonparse;

import android.util.Log;

import com.hebut.ctalk.dto.MessageDTO;
import com.hebut.ctalk.dto.UserDTO;

import org.jetbrains.annotations.TestOnly;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseMessages {
    private static final String TAG = "parseMessage";


    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }
    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }


    public List<MessageDTO> fetchItems(){
        List<MessageDTO> MessagesList = new ArrayList<>();
        try {

            // String url ="xxxx/xxxx/x";
            // String jsonString = getUrlString(url);
            String jsonString = "{\n" +
                    "  \"messages\": {\n" +
                    "  \"total\": \"3\",\n" +
                    "  \"message\": [\n" +
                    "      {\n" +
                    "\t\"mid\": \"1dqnnjfnnfno0129\",\n" +
                    "        \"title\": \"message-title\",\n" +
                    "        \"author\":{\n" +
                    "\t   \"uid\": \"jdqowr892u0\",\n" +
                    "           \"username\": \"li\",\n" +
                    "           \"gender\": \"男\",\n" +
                    "           \"password\": \"ipeuqpep\",\n" +
                    "           \"level\": \"4\",\n" +
                    "           \"profilePicture\": \"/xxxx/xxxxx/xxx.png\"\n" +
                    "         },\n" +
                    "        \"date\": \"2019/02/19\",\n" +
                    "        \"content\": \"whdo张qhoqoherbbvlcnwnocnqlndllqdqwlanclanflfljmc;lqmfjpomm;nlmv\",\n" +
                    "        \"type\": \"message\"            \n" +
                    "      },\n" +
                    "      {\n" +
                    "\t\"mid\": \"1dqcfwnmjfnnfno0129\",\n" +
                    "        \"title\": \"message-title\",\n" +
                    "        \"author\":{\n" +
                    "\t   \"uid\": \"jdqowr892u0\",\n" +
                    "           \"username\": \"li\",\n" +
                    "           \"gender\": \"man\",\n" +
                    "           \"password\": \"ipeuqpep\",\n" +
                    "           \"level\": \"4\",\n" +
                    "           \"profilePicture\": \"/xxxx/xxxxx/xxx.png\"\n" +
                    "         },\n" +
                    "        \"date\": \"2019/02/12\",\n" +
                    "        \"content\": \"whdoqho12131u19304019803wlanclanflfljmc;lqmfjpomm;nlmv\",\n" +
                    "        \"type\": \"message\"            \n" +
                    "      },\n" +
                    "      {\n" +
                    "\t\"mid\": \"cadqnncacnfno0129\",\n" +
                    "        \"title\": \"message-title\",\n" +
                    "        \"author\":{\n" +
                    "\t   \"uid\": \"jdqowr892u0\",\n" +
                    "           \"username\": \"li\",\n" +
                    "           \"gender\": \"man\",\n" +
                    "           \"password\": \"ipeuqpep\",\n" +
                    "           \"level\": \"4\",\n" +
                    "           \"profilePicture\": \"/xxxx/xxxxx/xxx.png\"\n" +
                    "         },\n" +
                    "        \"date\": \"2019/02/01\",\n" +
                    "        \"content\": \"whdoqhoy9817319080--881lanflfljmc;lqmfjpomm;nlmv\",\n" +
                    "        \"type\": \"message\"            \n" +
                    "      }      \n" +
                    "\n" +
                    "  ]\n" +
                    "\n" +
                    "  }\n" +
                    "\n" +
                    "}\n" +
                    "\n";
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(MessagesList, jsonBody);
        } catch (JSONException je) {
            Log.e(TAG, "Failec to parse JSON message", je);
        } catch (IOException ioe){
            Log.e(TAG, "Failec to fetch items", ioe);
        }


        return MessagesList;
    }

    private void parseItems(List<MessageDTO> MessagesList, JSONObject jsonBody) throws IOException, JSONException
    {
        JSONObject MessagesJsonObject = jsonBody.getJSONObject("messages");
        JSONArray MessageJsonArray = MessagesJsonObject.getJSONArray("message");

        for (int i = 0; i < MessageJsonArray.length(); i ++){
            System.out.println(MessageJsonArray.length());
            JSONObject MessageJsonObject = MessageJsonArray.getJSONObject(i);

            JSONObject UserJsonObject = MessageJsonObject.getJSONObject("author");


            MessageDTO item = new MessageDTO();
            UserDTO user = new UserDTO();

            user.setId(UserJsonObject.getString("uid"));
            user.setGender(UserJsonObject.getString("gender"));
            user.setLevel(UserJsonObject.getString("level"));
            user.setName(UserJsonObject.getString("username"));
            user.setProfilePicture(UserJsonObject.getString("profilePicture"));

            item.setMid(MessageJsonObject.getString("mid"));
            item.setTitle(MessageJsonObject.getString("title"));
            item.setAuthor(user);
            item.setContent(MessageJsonObject.getString("content"));
            item.setDate(MessageJsonObject.getString("date"));
            item.setType(MessageJsonObject.getString("type"));
            MessagesList.add(item);

        }



    }


}
