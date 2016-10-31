package ar.edu.unc.famaf.redditreader.backend;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unc.famaf.redditreader.R;
import ar.edu.unc.famaf.redditreader.model.PostModel;

/**
 * Created by federico on 29/10/16.
 */

public class Parser {

    public List<PostModel> readJsonStream(InputStream in) throws IOException, JSONException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        ArrayList<PostModel> list = new ArrayList<PostModel>();
        try {
            JSONObject response = new JSONObject(String.valueOf(reader.readLine()));
            JSONObject data = response.getJSONObject("data");
            JSONArray hotTopics = data.getJSONArray("children");
            for (int i = 0; i < hotTopics.length(); i++) {
                JSONObject topic = hotTopics.getJSONObject(i).getJSONObject("data");

                String title = topic.getString("title");
                String author = topic.getString("author");

                long timestamp = Long.parseLong(topic.getString("created_utc")) * 1000;
                String postTime = getDate(timestamp).toString();
                String comment = topic.getString("num_comments");;
                //String imageUrl = topic.getString("thumbnail");
                String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f2/Puma_marca.jpg";
                list.add(new PostModel(title, author, postTime, comment, R.drawable.icono, imageUrl));
            }
            return list;

        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String getDate(long timeStamp){

        try{
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        }
        catch(Exception ex){
            return "xx";
        }
    }
}
