import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        List<Data> list = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if (data[i][map.get(ext)] < val_ext) {
                list.add(new Data(data[i][0],data[i][1],data[i][2],data[i][3]));
            }
        }
        
        Collections.sort(list, (o1,o2)-> {
            if (sort_by.equals("code")) return o1.code-o2.code;
            else if (sort_by.equals("date")) return o1.date-o2.date;                
            else if (sort_by.equals("maximum")) return o1.maximum-o2.maximum;
            else return o1.remain-o2.remain;
            });
        
        int[][] result = new int[list.size()][4];
        for (int i=0; i<result.length; i++) {
            result[i][0] = list.get(i).code;
            result[i][1] = list.get(i).date;
            result[i][2] = list.get(i).maximum;
            result[i][3] = list.get(i).remain;
        }
        
        return result;
    }
    
    class Data{
        int code;
        int date;
        int maximum;
        int remain;
        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
    }
    
}