package com.atguigu.java.test.day2;

/**
 * 二维数组存取演示：新元素永远放在 [0][0]，已有元素整体往右推。
 *
 * <p>规则：
 * <ol>
 *     <li>第一个元素放在 [0][0]；</li>
 *     <li>存第二个元素时，把第一个元素往右边推一格（列 +1，列满了就进入下一行），
 *         新元素仍然放在 [0][0]；</li>
 *     <li>整个二维数组存满后如果还要继续存，就先清除最后一位（最旧的数据），
 *         再按同样的方式接着存。</li>
 * </ol>
 *
 * <p>所以数组下标越小代表数据越新，最后一位是当前最旧的数据。
 */
public class Test1 {

    /** 默认行数 */
    private static final int DEFAULT_ROWS = 3;
    /** 默认每行的列数 */
    private static final int DEFAULT_COLS = 5;

    /** 真正存放数据的二维数组 */
    private final int[][] data;
    /** 行数 */
    private final int rows;
    /** 每行的列数 */
    private final int cols;
    /** 当前已存放的元素个数（0 ~ rows * cols） */
    private int size;

    public Test1() {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    public Test1(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("行数和列数都必须大于 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    /**
     * 存入一个数字。
     *
     * @param value 要存入的数字
     */
    public void add(int value) {
        // 1. 已经存满：先清除最后一位（最旧的数据），腾出一个位置
        if (size == total()) {
            data[rows - 1][cols - 1] = 0;
            size--;
        }

        // 2. 已有元素整体往右推一格（行优先：先加列，列满换行）
        for (int i = size; i > 0; i--) {
            data[i / cols][i % cols] = data[(i - 1) / cols][(i - 1) % cols];
        }

        // 3. 新元素放到 [0][0]
        data[0][0] = value;
        size++;
    }

    /** 二维数组能存放的元素总个数 */
    public int total() {
        return rows * cols;
    }

    /** 当前已存放的元素个数 */
    public int size() {
        return size;
    }

    /** 按下标取出某个位置的值（行优先顺序，0 表示最新） */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }
        return data[index / cols][index % cols];
    }

    /** 清空 */
    public void clear() {
        for (int[] row : data) {
            java.util.Arrays.fill(row, 0);
        }
        size = 0;
    }

    /** 打印当前二维数组 */
    public void print() {
        for (int[] row : data) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
        System.out.println("当前个数：" + size + "/" + total()
                + "，行优先顺序（越靠前越新）：" + toList());
    }

    /** 按行优先顺序拼出已存放的数据，格式如 [5, 4, 3] */
    public String toList() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[i / cols][i % cols]);
        }
        return sb.append("]").toString();
    }

    @Override
    public String toString() {
        return toList();
    }

    public static void main(String[] args) {
        // 3 行 5 列，一共能存 15 个
        Test1 box = new Test1(3, 5);

        for (int i = 1; i <= 17; i++) {
            box.add(i);
            System.out.println("===== 第 " + i + " 次存入 " + i + " 后 =====");
            box.print();
            System.out.println();
        }
    }
}
