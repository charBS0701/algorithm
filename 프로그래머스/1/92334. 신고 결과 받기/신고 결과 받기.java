import java.util.*;
class Solution {
    
    // 신고받은 횟수
    static Map<String,Integer> cntMap = new HashMap<>();
    static List<User> userList = new ArrayList<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        for (String user : id_list) {
            userList.add(new User(user));
        }
        
        for (String rep : report) {
            String tmp[] = rep.split(" ");
            String reporter = tmp[0];
            String reportee = tmp[1];
            
            for (User user : userList) {
                if (!user.name.equals(reporter)) continue;
                if (user.reportSet.contains(reportee)) continue;
                user.reportSet.add(reportee);
                cntMap.put(reportee, cntMap.getOrDefault(reportee,0) + 1);
            }
        }
        
        int[] answer = new int[userList.size()];
        for (int i=0; i<answer.length; i++) {
            User user = userList.get(i);
            int sum = 0;
            Iterator<String> it = user.reportSet.iterator();
            while (it.hasNext()) {
                if (cntMap.get(it.next()) >= k) sum++;
            }
            answer[i] = sum;
        }
       
        return answer;
    }
    
    static class User {
        String name;
        Set<String> reportSet = new HashSet<>(); // 신고목록
        
        public User(String name) {
            this.name = name;
        }
    }
}