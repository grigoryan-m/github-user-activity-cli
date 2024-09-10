import org.json.JSONObject;
import org.json.JSONArray;

import java.util.HashMap;

public class JsonParser {
    public static void stringToArray(String str){
        JSONArray jsonArray = new JSONArray(str);
        displayActivity(jsonArray);
    }

    private static HashMap<String, Integer> countPushes(JSONArray jsonArray){
        HashMap<String, Integer> pushes = new HashMap<>();
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            if(jsonObj.getString("type").equals("PushEvent")){
                String repoName = jsonObj.getJSONObject("repo").getString("name");
                if(pushes.containsKey(repoName)){
                    pushes.put(repoName, pushes.get(repoName) + 1);
                    continue;
                }
                pushes.put(repoName, 1);
            }
        }
        return pushes;
    }

    private static void displayActivity(JSONArray jsonArray){
        countPushes(jsonArray);
    }
}
