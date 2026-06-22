import java.util.*;
class File implements Comparable<File>{
    String name;
    String head;
    String number;
    int idx;
    File(String name,String head,String number,int idx){
        this.name = name;
        this.head = head;
        this.number = number;
        this.idx = idx;
    }
    /*
    HEAD 
        사전 순으로 정렬 문자열 
        비교 시 대소문자 구분을 하지 않는다. 
    NUMBER
        숫자 순으로 정렬한다. 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬
        숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
    TAIL
        원래 입력에 주어진 순서를 유지
    */
    public int compareTo(File f){
        if (head.toLowerCase().equals(f.head.toLowerCase())){
            int a = Integer.parseInt(number);
            int b = Integer.parseInt(f.number);
            if (a == b){
                return idx - f.idx;
            }
            return a-b;
        }
        return head.toLowerCase().compareTo(f.head.toLowerCase());
    }
}
class Solution {
    public String[] solution(String[] files) {

        File[] fileArr = new File[files.length];
        for (int i = 0 ; i < files.length;i++){
            String [] splitarr = split(files[i]);
            fileArr[i] = new File(files[i],splitarr[0],splitarr[1],i);
        }
        Arrays.sort(fileArr);
        String[] answer = new String[fileArr.length];
        for (int i = 0 ; i < fileArr.length;i++){
            answer[i] = fileArr[i].name;
        }
        return answer;
    }
    
    
    public static String[] split(String s){
        StringBuilder head = new StringBuilder();
        StringBuilder num = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        boolean isNum = false;
        boolean isTail = false;
        for(int j = 0 ; j < s.length(); j++){
            char curChar = s.charAt(j);
            //Head
            if(curChar >= '0' && curChar <= '9'){
                isNum = true;
            }
            if (isNum){
                if (curChar < '0' || curChar > '9')
                    isTail = true;
                if(isTail){
                    //테일 채우기
                    tail.append(curChar);
                } else{
                   num.append(curChar);                 
                }                  
            } else {
                //헤드 채우기
                head.append(curChar);
            }
        }
        String[] splitarr = {head.toString(),num.toString(),tail.toString()};
        return splitarr;
    }
    
}