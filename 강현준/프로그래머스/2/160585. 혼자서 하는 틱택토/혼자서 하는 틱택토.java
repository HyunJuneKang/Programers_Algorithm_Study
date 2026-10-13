class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int countO = 0;
        int countX = 0;
        for(int i = 0; i < board.length;i++){
            for(char c : board[i].toCharArray()){
                if (c == 'O') 
                    countO++;
                else if (c == 'X') 
                    countX++;
            }
        }
        //1. O의 개수 < X의 개수 (걸러내기)
        if (countO < countX)
            return 0;
        //2. O의 개수 > X의 개수 + 1 (걸러내기)
        if (countO > countX + 1)
            return 0;
        //3. 여러줄 완성 확인
        int endCountO = 0;
        int endCountX = 0;
        //가로줄 확인
        for(int i = 0; i < board.length;i++){
            char curChar = ' ';
            boolean isEnd = true;
            for(char c : board[i].toCharArray()){
                if (curChar == ' ')
                    curChar = c;
                if (curChar != c){
                    isEnd = false;
                    break;
                } 
            }
            if(isEnd){
                if (curChar == 'O')
                    endCountO++;
                if (curChar == 'X')
                    endCountX++;
            }
        }
        //세로줄 확인
        for(int i = 0; i < board.length;i++){
            char curChar = ' ';
            boolean isEnd = true;
            for(int j = 0 ; j < 3; j++){
                char c = board[j].charAt(i);
                if (curChar == ' ')
                    curChar = c;
                if (curChar != c){
                    isEnd = false;
                    break;
                } 
            }
            if(isEnd){
                if (curChar == 'O')
                    endCountO++;
                if (curChar == 'X')
                    endCountX++;
            }
        }
        // 대각선 ↘
        if (board[0].charAt(0) != '.' &&
            board[0].charAt(0) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(2)) {

            if (board[0].charAt(0) == 'O')
                endCountO++;
            else
                endCountX++;
        }

        // 대각선 ↙
        if (board[0].charAt(2) != '.' &&
            board[0].charAt(2) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(0)) {

            if (board[0].charAt(2) == 'O')
                endCountO++;
            else
                endCountX++;
        }
        if ( endCountO > 0 && endCountX > 0)
            return 0;
        // 4. 승리 후 게임 진행 여부 확인
        if (endCountO > 0 && countO != countX + 1)
            return 0;

        if (endCountX > 0 && countO != countX)
            return 0;
        return answer;
    }
}