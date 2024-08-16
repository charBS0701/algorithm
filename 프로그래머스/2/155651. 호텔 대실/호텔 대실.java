import java.util.*;
class Solution {
    static int answer;
    static PriorityQueue<Book> pq = new PriorityQueue<>((o1,o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start-o2.start);
    static PriorityQueue<Book> pq2 = new PriorityQueue<>((o1,o2) -> o1.end == o2.end ? o1.start-o2.start : o1.end - o2.end);
    public int solution(String[][] book_time) {        
        for (int i=0; i<book_time.length; i++) {
            String start = book_time[i][0];
            String end = book_time[i][1];
            int startTime = Integer.parseInt(start.substring(0,2)) * 60 + Integer.parseInt(start.substring(3,5));
            int endTime = Integer.parseInt(end.substring(0,2)) * 60 + Integer.parseInt(end.substring(3,5));
            
            // 입실시간 빠른 순, 퇴실시간 빠른순으로 정렬
            pq.add(new Book(startTime, endTime));
            
        }
        
        // 방 하나씩 세기
        for (int i=0; i<book_time.length; i++) {
            //// add
            Book book = pq.poll();
            pq2.add(book);
            
            //// 있던 방 중 새로운 방 시작시간+10 이하면 poll
            while (pq2.peek().end + 10 <= book.start) {
                pq2.poll();
            }
            
            answer = Math.max(answer, pq2.size());
        }
        
        return answer;
    }
    
    static class Book{
        int start;
        int end;
        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}