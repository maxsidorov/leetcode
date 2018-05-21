class Solution {
    
    public enum Direction {
        RIGHT, BOTTOM, LEFT, TOP
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        int i = 0, j = 0, left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        Direction dir = Direction.RIGHT; 
        for (int k = 0; k < matrix.length * matrix[0].length; k++) {
            result.add(matrix[i][j]);
            switch(dir) {
                case RIGHT: {
                    if (j < right) {
                        j++;
                    } else {
                        dir = Direction.BOTTOM;
                        i++;
                        top++;
                    }
                    break;
                }
                case BOTTOM: {
                    if (i < bottom) {
                        i++;
                    } else {
                        dir = Direction.LEFT;
                        j--;
                        right--;
                    }
                    break;
                }
                case LEFT: {
                    if (j > left) {
                        j--;
                    } else {
                        dir = Direction.TOP;
                        i--;
                        bottom--;
                    }
                    break;
                }
                case TOP: {
                    if (i > top) {
                        i--;
                    } else {
                        dir = Direction.RIGHT;
                        j++;
                        left++;
                        
                    }
                    break;
                }
            }
            //System.out.println("dir = " + dir + ", i = " + i + ", " + "j = " + j + ", " + "left = " + left + ", " + "top = " + top + ", " + "bottom = " + bottom + ", " + "right = " + right);
        }
        return result;
    }
}
