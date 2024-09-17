import java.util.*;
class Solution {
    static List<File> list = new ArrayList<>();
    public String[] solution(String[] files) {
        
        for (String file : files) {
            String head = "";
            String number = "";
            String tail = "";
            int headEndIdx = -1;
            
            for (int i=0; i<file.length(); i++) {
                if (head == "") {
                    if (Character.isDigit(file.charAt(i))) {
                        head = file.substring(0,i);
                        headEndIdx = i-1;
                    }
                } else if (number == "") {
                    if (!Character.isDigit(file.charAt(i))) {
                        number = file.substring(headEndIdx+1,i);
                        tail = file.substring(i);
                        break;
                    }
                }
            }
            
            // tail 이 없는 경우
            if (number == "") {
                number = file.substring(headEndIdx+1);
            }
            
            list.add(new File(head, number, tail));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).toString();
        }
        
        return answer;
    }
    
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        
        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public String toString() {
            return this.head+this.number+this.tail;
        }
        
        @Override
        public int compareTo(File o) {
            String head1 = this.head.toUpperCase();
            String head2 = o.head.toUpperCase();
            
            if (head1.equals(head2)) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            } else {
                return head1.compareTo(head2);
            }
        }
    }
}