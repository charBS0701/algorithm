import java.util.*;

class Solution {
    static Map<String, String> map = new HashMap<>();
    public String[] solution(String[] record) {
        ArrayList<Log> logs = new ArrayList<>();
        
        StringTokenizer st;
        for(int i=0; i<record.length; i++) {
            st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String id = st.nextToken();
            if (st.hasMoreTokens()) {
                if (act.equals("Enter")) {      // 입장인 경우
                    String nickname = st.nextToken();
                    logs.add(new Log(id, act));
                    map.put(id, nickname);
                } else if (act.equals("Change")) {      // 닉변인 경우 
                    String newNickname = st.nextToken();
                    map.put(id, newNickname);
                }
            } else {    // 퇴장인 경우
            logs.add(new Log(id, act));
            }
        }
        
        String[] answer = new String[logs.size()];
        
        for (int i=0; i<answer.length; i++) {
            answer[i] = logs.get(i).toString();   
        }
        
        return answer;
    }
    
    class Log{
        String id;
        String act;
        public Log(String id, String act) {
            this.id = id;
            this.act = act;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(id)).append("님이 ");
            if (act.equals("Enter")) sb.append("들어왔습니다.");
            else if (act.equals("Leave")) sb.append("나갔습니다.");
            
            return sb.toString();
        }
    }
}