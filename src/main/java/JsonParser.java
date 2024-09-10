import org.json.JSONObject;
import org.json.JSONArray;


public class JsonParser {
    public static void stringToArray(String str) {
        JSONArray jsonArray = new JSONArray(str);
        countActivity(jsonArray);
    }

    private static void countActivity(JSONArray jsonArray) {
        String lastActivity = jsonArray.getJSONObject(0).getString("type");
        String repoName = jsonArray.getJSONObject(0).getJSONObject("repo").getString("name");
        int numOfActivity = 1;

        for (int i = 1; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.getString("type").equals(lastActivity) && jsonObject.getJSONObject("repo").getString("name").equals(repoName)) {
                numOfActivity++;
                continue;
            }
            displayActivity(lastActivity, repoName, numOfActivity);
            lastActivity = jsonObject.getString("type");
            repoName = jsonObject.getJSONObject("repo").getString("name");
            numOfActivity = 1;
        }
    }

    private static void displayActivity(String activity, String repoName, int numOfActivity) {
        switch (activity) {
            case "PushEvent" -> System.out.println("- Pushed " + numOfActivity + " commits to " + repoName);
            case "IssuesEvent" -> System.out.println("- Created " + numOfActivity + " issues for " + repoName);
            case "CreateEvent" -> System.out.println("- Created " + numOfActivity + " branches for " + repoName);
        }
    }


}