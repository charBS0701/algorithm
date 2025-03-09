import java.time.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        LocalTime lt_pos = LocalTime.of(1,getHour(pos),getMin(pos));
        LocalTime lt_op_start = LocalTime.of(1,getHour(op_start),getMin(op_start));
        LocalTime lt_op_end = LocalTime.of(1,getHour(op_end),getMin(op_end));
        LocalTime lt_video_len = LocalTime.of(1,getHour(video_len),getMin(video_len));
                
        for (String com : commands) {            
            if (checkOp(lt_pos, lt_op_start, lt_op_end)) lt_pos = LocalTime.of(1,getHour(op_end),getMin(op_end));
            
            if (com.equals("next")) lt_pos = lt_pos.plusSeconds(10);
            else if (com.equals("prev")) lt_pos = lt_pos.minusSeconds(10);
            
            if (lt_pos.compareTo(LocalTime.parse("01:00:00")) < 0) lt_pos = LocalTime.parse("01:00:00");
            else if (lt_pos.isAfter(lt_video_len)) lt_pos = LocalTime.of(1,getHour(video_len),getMin(video_len));
        }
        
        if (checkOp(lt_pos, lt_op_start, lt_op_end)) lt_pos = LocalTime.of(0,getHour(op_end),getMin(op_end));
        
        return String.format("%02d", lt_pos.getMinute()) + ":" + String.format("%02d", lt_pos.getSecond());
        
    }
    
    static int getHour(String s) {
        return Integer.parseInt(s.substring(0,2));
    }
    
    static int getMin(String s) {
        return Integer.parseInt(s.substring(3,5));
    }
    
    static boolean checkOp(LocalTime now, LocalTime op_start, LocalTime op_end) {
        if (now.compareTo(op_start) >= 0 && now.compareTo(op_end) <= 0) return true;
        return false;
    }
}