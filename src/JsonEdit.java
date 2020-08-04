//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Set;

public class JsonEdit {

    static  ArrayList<MagMonRec> MagMonList = new ArrayList<>();


    public static JsonObject AddRec(JsonObject SourceJson, MagMonRec newMagMon){
        Set<String> keys = SourceJson.keySet();
        Object[] jsonkeys = keys.toArray();
        MagMonList.clear();
        //парсим данные из json
        for (int i = 0; i <= jsonkeys.length - 1; i++) {
            JsonArray bufArray = SourceJson.getAsJsonArray(jsonkeys[i].toString());
            MagMonRec node = new MagMonRec();
            node.setName(jsonkeys[i].toString());
            node.setIP(bufArray.get(0).getAsString());
            node.setPort(bufArray.get(1).getAsString());
            node.setLogin(bufArray.get(2).getAsString());
            node.setPass(bufArray.get(3).getAsString());
            MagMonList.add(node);
        }
        //добавляем данные из новой записи
        MagMonRec node = new MagMonRec();
        node.setName(newMagMon.getName());
        node.setIP(newMagMon.getIP());
        node.setPort(newMagMon.getPort());
        node.setLogin(newMagMon.getLogin());
        node.setPass(newMagMon.getPass());
        MagMonList.add(node);
        //формируем новый json
        JsonObject jsonObj = new JsonObject();
        for(int i=0; i<=MagMonList.size()-1; i++){
            JsonArray arrayJSON = new JsonArray();
            node = MagMonList.get(i);
            arrayJSON.add(node.IP);
            arrayJSON.add(node.Port);
            arrayJSON.add(node.Login);
            arrayJSON.add(node.Pass);
            jsonObj.add(node.Name, arrayJSON);
        }
        return jsonObj;
    }

    public static String MagMonListToJson(ArrayList<MagMonRec> MMList){
        String result = null;
        JsonObject jsonObj = new JsonObject();
        for(int i=0; i<=MainForm.MagMonList.size()-1; i++){
            MagMonRec node = MainForm.MagMonList.get(i);
            JsonObject jsonBuf = new JsonObject();
            jsonBuf.addProperty("HePress",MainForm.MagMonList.get(i).getHePress());
            jsonBuf.addProperty("HeLevel",node.getHeLevel());
            jsonBuf.addProperty("WT1",node.getWaterTemp1());
            jsonBuf.addProperty("WF1",node.getWaterFlow1());
            jsonBuf.addProperty("WT2",node.getWaterTemp2());
            jsonBuf.addProperty("WF2",node.getWaterFlow2());
            jsonBuf.addProperty("LastUpdate",node.getLastTime());
            JsonArray jsonError = new JsonArray();
            ArrayList<String> bufArray = node.getErrors();
                for (int j = 0; j <= bufArray.size() - 1; j++) {
                    jsonError.add(bufArray.get(j));
                }
            jsonBuf.add("Errors", jsonError);
            jsonObj.add(node.getName(), jsonBuf);
        }
        result = jsonObj.toString();
        return result;
    }

    public static void DeleteRec(JsonObject SourceJson, int DelRecNumber){
        Set<String> keys = SourceJson.keySet();
        Object[] jsonkeys = keys.toArray();
        MagMonList.clear();
        //парсим данные из json
        for (int i = 0; i <= jsonkeys.length - 1; i++) {
            JsonArray bufArray = SourceJson.getAsJsonArray(jsonkeys[i].toString());
            MagMonRec node = new MagMonRec();
            node.setName(jsonkeys[i].toString());
            node.setIP(bufArray.get(0).getAsString());
            node.setPort(bufArray.get(1).getAsString());
            node.setLogin(bufArray.get(2).getAsString());
            node.setPass(bufArray.get(3).getAsString());
            MagMonList.add(node);
        }
        MagMonList.remove(DelRecNumber);
        JsonObject jsonObj = new JsonObject();
        for(int i=0; i<=MagMonList.size()-1; i++){
            JsonArray arrayJSON = new JsonArray();
            MagMonRec node = MagMonList.get(i);
            arrayJSON.add(node.IP);
            arrayJSON.add(node.Port);
            arrayJSON.add(node.Login);
            arrayJSON.add(node.Pass);
            jsonObj.add(node.Name, arrayJSON);
        }
        MainForm.userPrefs.put("JsonMagMonList", jsonObj.toString());
    }

    public static ArrayList<MagMonRec> GetMagMonList(JsonObject SourceJson){
        Set<String> keys = SourceJson.keySet();
        Object[] jsonkeys = keys.toArray();
        MagMonList.clear();
        //парсим данные из json
        for (int i = 0; i <= jsonkeys.length - 1; i++) {
            JsonArray bufArray = SourceJson.getAsJsonArray(jsonkeys[i].toString());
            MagMonRec node = new MagMonRec();
            node.setName(jsonkeys[i].toString());
            node.setIP(bufArray.get(0).getAsString());
            node.setPort(bufArray.get(1).getAsString());
            node.setLogin(bufArray.get(2).getAsString());
            node.setPass(bufArray.get(3).getAsString());
            MagMonList.add(node);
        }
        return MagMonList;
    }
}
