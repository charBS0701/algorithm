import java.util.*;

class Solution {
    
    static class Song implements Comparable<Song> {
        int id;
        int play;
        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
        @Override
        public int compareTo(Song o) {
            if (o.play != play) return o.play - play;
            return id - o.id;
        }
    }
    
    static class Genre implements Comparable<Genre> {
        String name;
        int id;
        int plays = 0;
        public Genre(String name, int plays) {
            this.name = name;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.plays - plays;
        }
        @Override
        public boolean equals(Object o) {
            Genre g = (Genre) o;
            return g.name.equals(this.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }
    }
    
    
    static List<PriorityQueue<Song>> songList = new ArrayList<>();
    static List<Genre> genreList = new ArrayList<>();

    
    public int[] solution(String[] genres, int[] plays) {
    
        for (int i=0; i<100; i++) {
            songList.add(new PriorityQueue<>());
        }
        
        for (int i=0; i<plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int genreIdx = -1;
            
            Genre g = new Genre(genre, 0);
            
            if (genreList.contains(g)) {
                genreIdx = genreList.indexOf(g);
            } else {
                genreList.add(g);
                genreIdx = genreList.indexOf(g);
                genreList.get(genreIdx).id = genreIdx;
            }
            
            genreList.get(genreIdx).plays += play;
            songList.get(genreIdx).add(new Song(i,play));
        }
        
        Collections.sort(genreList);
        
        List<Integer> answer = new ArrayList<>();
        for (Genre gen : genreList) {
            
            PriorityQueue<Song> songs = songList.get(gen.id);
            int cnt = 0;
            while (!songs.isEmpty() && cnt < 2) {
                answer.add(songs.poll().id);
                cnt++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}