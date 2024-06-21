import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 1;
        
        // 대소문자 대문자로 통일
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        for (int i=0; i<arr1.length; i++) {
            char c = arr1[i];
            if (c >= 'a' && c <= 'z') arr1[i] -= 'a'-'A';                
        }
        for (int i=0; i<arr2.length; i++) {
            char c = arr2[i];
            if (c >= 'a' && c <= 'z') arr2[i] -= 'a'-'A';                
        }        
        
        // 쌍들 map 에 개수 입력 (str1, str2 따로)
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        // 슬라이싱
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr1.length-1; i++) {
            char c1 = arr1[i];
            char c2 = arr1[i+1];
            // 문자가 아닌 것 제외
            if (c1 < 'A' || c1 > 'Z' || c2 < 'A' || c2 > 'Z') continue;
            sb.append(arr1[i]).append(arr1[i+1]);
           
            // 쌍들 map 에 개수 입력 (str1, str2 따로)
            String sub = sb.toString();
            sb.setLength(0);                
            map1.put(sub, map1.getOrDefault(sub,0)+1);
        }
        for (int i=0; i<arr2.length-1; i++) {
            char c1 = arr2[i];
            char c2 = arr2[i+1];
            // 문자가 아닌 것 제외
            if (c1 < 'A' || c1 > 'Z' || c2 < 'A' || c2 > 'Z') continue;
            sb.append(arr2[i]).append(arr2[i+1]);
           
            // 쌍들 map 에 개수 입력 (str1, str2 따로)
            String sub = sb.toString();
            sb.setLength(0);                
            map2.put(sub, map2.getOrDefault(sub,0)+1);
        }        
        
        // 자카드 유사도 계산
        int numCnt = 0;
        int denCnt = 0;
        
        for (Integer val : map1.values()) {
            denCnt += val;
        }
        
        Iterator<Map.Entry<String,Integer>> iter = map2.entrySet().iterator();
        
        while (iter.hasNext()) {
            Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>) iter.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            if (map1.containsKey(key)) {    // 교집합이 있을 때
                int v1 = map1.get(key);
                int v2 = value;

                numCnt += Math.min(v1,v2);
                denCnt += Math.max(v1,v2);
                
                // 처음에 더한거 빼기
                denCnt -= v1;
                
            } else {
                denCnt+=value;
            }
          
        }       
        
        if (map1.size()==0 && map2.size()==0) {
            answer = 1;
        } else if (numCnt == 0) {
            answer = 0;  
        } else {
            answer = (double)numCnt/denCnt;
        }
        answer = Math.floor(answer * 65536);
        
        return (int)answer;
    }
    
}
