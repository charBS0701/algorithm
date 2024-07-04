import java.util.*;
import java.util.Collection.*;
class Solution {
    public int[] solution(int[] answers) {
        // 1 2 3 4 5
        int[] d1 = {1,2,3,4,5};
        // 21 23 24 25
        int[] d2 = {2,1,2,3,2,4,2,5};
        // 33 11 22 44 55
        int[] d3 = {3,3,1,1,2,2,4,4,5,5};       
        
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        list.add(s1);
        Student s2 = new Student();
        list.add(s2);
        Student s3 = new Student();
        list.add(s3);
        
        for (int a : answers) {
            if (s1.idx==5) s1.idx=0;
            if (a == d1[s1.idx++]) s1.c++;
            if (s2.idx==8) s2.idx=0;
            if (a == d2[s2.idx++]) s2.c++;
            if (s3.idx==10) s3.idx=0;
            if (a == d3[s3.idx++]) s3.c++;            
        }
        
        List<Integer> result = new ArrayList<>();
        int max = -1;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).c > max) {
                result.clear();
                result.add(i+1);
                max = list.get(i).c;
            } else if (list.get(i).c == max) {
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(a->a).toArray();
    }
    
    static class Student{
        int c, idx;
    }
}