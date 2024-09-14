import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static int answer;
    static List<Human> people = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
		    int man = Integer.parseInt(st.nextToken());
		    people.add(new Human(Math.abs(man), man>0 ? true : false, true));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
		    int woman = Integer.parseInt(st.nextToken());
		    people.add(new Human(Math.abs(woman), woman>0 ? true : false, false));
		}
		
		Collections.sort(people);
		
		int manIdx = 0;
		int woIdx = 0;
		for (int n=0; n<N * 2; n++) {
		    Human now = people.get(n);
		    if (now.matched || now.t) continue;     // 매칭됐거나 큰걸 좋아하면 pass
		    
		    if (now.gender) {   // 남자인 경우
		        for (; woIdx<N * 2; woIdx++) {
		            Human nowWoman = people.get(woIdx);
		            if (nowWoman.gender || nowWoman.matched || !nowWoman.t) continue; // 남자 || 매칭된 사람 || 작은거좋아 pass
		            if (nowWoman.h < now.h) { // 매칭
		                answer++;
		                woIdx++;
		                now.matched = true;
		                nowWoman.matched = true;
		                break;
		            } else {
		                break;
		            }
		        }
		    } else if (!now.gender) { // 여자인 경우
		        for (; manIdx<N * 2; manIdx++) {
		            Human nowMan = people.get(manIdx);
		            if (!nowMan.gender || nowMan.matched || !nowMan.t) continue; // 여자 || 매칭된 사람 || 작은거좋아 pass 
		            if (nowMan.t && nowMan.h < now.h) { // 매칭
		                answer++;
		                manIdx++;
		                now.matched = true;
		                nowMan.matched = true;
		                break;
		            } else {
		                break;
		            }
		        }		    
		    }
		}
		
		System.out.println(answer);
		
	}
	
	static class Human implements Comparable<Human> {
	    int h;
	    boolean gender;
	    boolean t;
	    boolean matched = false;
	    
	    public Human(int h, boolean t, boolean gender) {
	        this.gender = gender;
	        this.h = h;
	        this.t = t;
	    }
	    
	    @Override
	    public int compareTo(Human human) {
	        if (this.h == human.h) {
	            return 0;
	        } else return this.h - human.h;
	    }
	    
	    @Override
	    public String toString() {
	        return (this.gender ? "M" : "F") + String.valueOf(this.h) + (this.t ? "+" : "-");
	    }
	}
}
