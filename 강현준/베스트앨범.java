/*
1.각 장르들의 노래를 묶어서 총 합을 구한다.
2.각 노래들의 필드에 장르별 재생된 횟수를 필드에 등록.
3. 1번부터 3번까지 정렬 알고리즘 적용
4. 정렬 후 출력할 때 장르별 최대 2회까지만 적용
*/
import java.util.*;
class Song implements Comparable<Song>{
    int idx;
    int playCount;
    int genreCount;
    String genre;
    
    Song(int idx,int playCount,int genreCount,String genre){
        this.idx = idx;
        this.playCount = playCount;
        this.genreCount = genreCount;
        this.genre = genre;
    }
    public int getIdx(){
        return idx;
    }
    public String getGenre(){
        return genre;
    }
    public int getPlayCount(){
        return playCount;
    }
    public int compareTo(Song s){
        if (genreCount == s.genreCount)
            if (playCount == s.playCount)
                return idx - s.idx;
            else
                return s.playCount - playCount;
        else
            return s.genreCount - genreCount;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0 ; i < genres.length;i++){
            if (hm.containsKey(genres[i]))
                hm.put(genres[i],hm.get(genres[i])+plays[i]);
            else
                hm.put(genres[i],plays[i]);
        }
        Song[] songArr = new Song[genres.length];
        
        for (int i = 0 ; i < genres.length; i++){
            songArr[i] = new Song(i,plays[i],hm.get(genres[i]),genres[i]);
        }
        
        
        Arrays.sort(songArr);
        String tempGenre = "";
        int curCnt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < songArr.length; i++){
            Song curSong = songArr[i];
            if (tempGenre.equals(curSong.getGenre())){
                if (curCnt == 2){
                    continue;
                }
                else {
                    result.add(curSong.getIdx());
                    curCnt++;
                }
            } else{
                tempGenre = curSong.getGenre();
                curCnt = 0;
                result.add(curSong.getIdx());
                curCnt++;
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}