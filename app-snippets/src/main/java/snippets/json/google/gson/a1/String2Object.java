package snippets.json.google.gson.a1;

import com.google.gson.Gson;

public class String2Object {
    public static Data convert(String json) {
        Data data = new Gson().fromJson(json, Data.class);
        
        return data;
    }
}
