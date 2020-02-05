package jianzhioffer;

public class Solution03 {
    /**
     * 题目描述：
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 
     * 规律：
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     * 查找的范围，直到找到要查找的数字，或者查找范围为空。
     * 
     * 复杂度分析：
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     */
    public static boolean find(int target, int [][] array) {
        // 边际条件
        if (array==null || array.length<1 || array[0].length<1) return false;

        int row = array.length, col = array[0].length; //二维数组的行列数
        int rowIndex = 0, colIndex = col-1; //二维数组右上角元素下标

        while (rowIndex<row && colIndex>=0) {
            if (array[rowIndex][colIndex]>target) colIndex--;
            else if (array[rowIndex][colIndex]<target) rowIndex++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = null;
        System.out.println(find(1, matrix)); // output: false
    }
}