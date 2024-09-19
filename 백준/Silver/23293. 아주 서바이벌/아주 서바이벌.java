import java.util.*;
import java.io.*;

class Main {
    static int N, T;
    
    static List<User> users = new ArrayList<>();
    static List<Integer> cheatLog = new ArrayList<>();
    static TreeSet<Integer> bannedUser = new TreeSet<>();
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for (int n=0; n<=N; n++) {
            users.add(new User());
        }
        
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int lnum = Integer.parseInt(st.nextToken());
            int pnum = Integer.parseInt(st.nextToken());
            char ocode = st.nextToken().charAt(0);
            int operand = Integer.parseInt(st.nextToken());
            
            int operand2 = -1;
            if (st.hasMoreTokens()) {
                operand2 = Integer.parseInt(st.nextToken());
            }
            
            User user = users.get(pnum);
            
            if (ocode == 'M') {
                user.loc = operand;
            } else if (ocode == 'F') {
                user.farming(operand);
                if (user.loc != operand) {
                    cheatLog.add(lnum);
                }
            } else if (ocode == 'C') {
                if (!user.craft(operand, operand2)) {
                    cheatLog.add(lnum);
                };
            } else if (ocode == 'A') {
                if (user.loc != users.get(operand).loc) {
                    cheatLog.add(lnum);
                    bannedUser.add(pnum);
                }
            }
        }
        
        Collections.sort(cheatLog);
        
        // 부정로그수
        sb.append(cheatLog.size()).append("\n");
        
        // 로그번호 오름차순
        for (int i=0; i<cheatLog.size(); i++) {
            sb.append(cheatLog.get(i)).append(" ");
            
            if (i==cheatLog.size()-1) sb.append("\n");
        }
        
        // 차단플레이어수
        sb.append(bannedUser.size()).append("\n");
        
        // 플레이어번호 오름차순
        while (bannedUser.size() != 0) {
            sb.append(bannedUser.pollFirst()).append(" ");
        }
        
        System.out.println(sb);
        
    }
    
    static class User {
        int loc;
        Map<Integer, Integer> items = new HashMap<>();
        
        public User() {
            this.loc = 1;
        }
        
        public void farming(int item) {
            this.items.put(item, this.items.getOrDefault(item, 0) + 1);
        }
        
        public boolean craft(int op1, int op2) {
            boolean flag = true;
            if (!items.containsKey(op1)) {
                flag = false;
            } else {
                this.items.put(op1, this.items.get(op1) - 1);
                if (this.items.get(op1) == 0) this.items.remove(op1);
            }
            
            if (!items.containsKey(op2)) {
                flag = false;
            } else {
                this.items.put(op2, this.items.get(op2) - 1);
                if (this.items.get(op2) == 0) this.items.remove(op2);
            }            
            
            return flag;
        }
        
    }
}