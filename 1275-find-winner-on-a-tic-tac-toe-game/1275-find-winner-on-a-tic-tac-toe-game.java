class Solution {
    public String tictactoe(int[][] moves) {
        int count = 1;
        int[] row = new int[3], col = new int[3];
        int dia = 0, antidia = 0;
        for(int i = 0; i < moves.length; i++){
            int[] move = moves[i];
            int delta = i%2 == 0? 1:-1;
            row[move[0]] += delta;
            col[move[1]] += delta;
            if(move[0] == move[1]) dia+=delta;
            if(move[0]+move[1] == 2) antidia += delta;
            if(Math.abs(row[move[0]]) == 3 || Math.abs(col[move[1]]) == 3|| Math.abs(dia)==3 || Math.abs(antidia) == 3) return i%2 == 0 ? "A" : "B";
        }
        return moves.length == 9?"Draw":"Pending";
    }
}