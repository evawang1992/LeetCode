class TicTacToe {
int[] rows, cols ;int  diagnal , antidiagnal;
    int nn ;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagnal = 0;
        antidiagnal = 0;
        nn = n;
    }
    
    public int move(int row, int col, int player) {
       int delta =  (player%2)==0 ? 1: -1;
        rows[row]+=delta;
        cols[col]+=delta;
        if(row == col) diagnal+= delta;
        if(row+col == nn-1) antidiagnal+=delta;
        if(Math.abs(rows[row]) == nn || Math.abs(cols[col]) == nn || Math.abs(diagnal) == nn || Math.abs(antidiagnal) == nn) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */