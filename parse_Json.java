package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/3/17.
 */
public class parse_Json {
    public List<Json> parseJson(Json apiData, String[] columns) {
        List<Json> res = new ArrayList<>();
        helper(apiData, columns, 0, new StringBuilder(), res);
        return res;
    }
    public void helper(Json apiData, String[] columns, int index, StringBuilder sb, List<Json> res) {
        if (apiData.type().equals("JSONString")) {
            sb.append(columns[index]).append(":").append(apiData.value()).append("}");
            res.add(new Json(sb.toString()));
        } else {
            if (apiData.type().equals("JSONMapping")) {
                for (String key : apiData.keys()) {
                    String cur = columns[index] + ":" + key + ",";
                    sb.append(cur);
                    helper(apiData.get(key), columns, index + 1, sb, res);
                }
            }
        }
    }

    class Json {
        String json;
        public Json(){}
        public Json(String json) {this.json = json;}
        public String toString(){
            return "";
        }
        public String type() {
            return "";
        }
        public String value() {
            return "";
        }
        public Json get(String key) {return null;}
        public String[] keys() {return new String[2];}
    }

    class JSONString extends Json{
        public String value(){return "";}
        public String type(){return "";}
    }

}
