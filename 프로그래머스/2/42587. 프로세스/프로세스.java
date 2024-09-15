import java.util.*;

class Solution {    
    static int answer;
    static Deque<Item> que = new ArrayDeque<>();
    static PriorityQueue<Item> pq = new PriorityQueue<>((o1,o2) -> o2.pri - o1.pri);
    public int solution(int[] priorities, int location) {
        for (int i=0; i<priorities.length; i++) {
            que.add(new Item(priorities[i], i));
            pq.add(new Item(priorities[i], i));
        }
        
        while (!que.isEmpty()) {
            Item item = que.poll();
            answer++;
            while (pq.peek().pri != item.pri) {
                que.add(item);
                item = que.poll();
            }
            pq.poll();
            
            if (item.loc == location) {
                break;
            }
        }
        
        return answer;
    }
    
    static class Item {
        int pri;
        int loc;
        
        public Item(int pri, int loc) {
            this.pri = pri;
            this.loc = loc;
        }
    }
}