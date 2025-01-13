// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//TIME COMPLEXITY:O(N)
//SPACE COMPLEXITY:O(1)
// Your code here along with comments explaining your approach


class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int liveNeighbours = countLiveNeighbours(board, i , j, m ,n);
                if (board[i][j] == 1) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (board[i][j] == 0) {
                        if (liveNeighbours == 3) {
                            board[i][j] = 3;
                        }
                    }
                }
            }
        }


        for (int i=0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else {
                    if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    private int countLiveNeighbours(int[][] board, int i, int j, int m, int n) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}, {-1, -1}, {-1, 1}, {1,-1}, {1,1}};
        int count =0;
        for (int[] dir:dirs) {
            int nrow=0, ncol=0;
            nrow = i+dir[0];
            ncol = j+dir[1];
            if (nrow >=0 && nrow<=m-1) {
                if (ncol >=0 && ncol <= n-1) {
                    if (board[nrow][ncol] == 1 || board[nrow][ncol] == 2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


//TIME COMPLEXITY:O(N)
//SPACE COMPLEXITY:O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> lm = new ArrayList<Integer>();

        for (int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] *-1;
            }
        }

        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                lm.add(i+1);
            }
        }



        return lm;

    }
}
