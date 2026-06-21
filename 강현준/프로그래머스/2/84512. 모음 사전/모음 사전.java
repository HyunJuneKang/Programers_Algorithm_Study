/*
사전
길이 5
A > E > I > O > U 
ex) A>AA> AAAA>AAAAA>AAAAE>...> AAAAU > 
    1 2    4    5      6          9
    AAAE-> AAAEA -> ...-> AAAI
     10      11            16
    AAA AAAU AAE
     3    28   29
     2+27
5번째 값은

*/
class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowels = "AEIOU";
        int[] weight = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            int order = vowels.indexOf(word.charAt(i)); // A=0, E=1, I=2, O=3, U=4
            answer += order * weight[i] + 1;
        }

        return answer;
    }
}