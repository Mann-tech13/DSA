class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length - 1;
        int selectedRow = 0;
        for(int i = 0; i < row; i++) {
            if(matrix[i][col] == target) return true;
            else if(matrix[i][col] > target) {
                selectedRow = i;
                break;
            }
        }
        int left = 0, right = col;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(matrix[selectedRow][mid] == target) return true;
            else if(matrix[selectedRow][mid] > target) right = mid;
            else left = mid + 1;
        }
        return false;
    }
}
