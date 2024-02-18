import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    /**
     * 数组解决约瑟夫问题
     * @param n 一共有 n 个人
     * @param m 报数到 m 就出局
     * @param peopleLeft 要求最终幸存的人数
     */
    public static List<Integer> JosephusArray(int n, int m, int peopleLeft){
        // 存放出局元素序列
        List<Integer> out_items = new ArrayList<>();
        // 用于标记某位置的人是否还在船上，0表示未出局，1表示已出局
        // 共n个元素，但由于第一个元素的下标为0，而题干要求从1开始报数，为了和下标匹配，长度定义为n+1，下标为0的元素闲置
        int[] flag = new int[n + 1];
        // cnt：目前已出局的人数；i：某编号的人；k：当前报的数
        int cnt = 0, i = 0, k = 0;

        while (peopleLeft != n-cnt) {
            // 从第一个人依次进行报数
            i++;
            if (i > n) {
                i = 1;
            }

            if (flag[i] == 0) {  // 如果 i 位置的人未出局
                k++;  // 就报一个数
                if (k == m) {  // 如果报到要求出局的数 m
                    flag[i] = 1;  // 标记为出局
                    cnt++;  // 已出局人数+1
                    out_items.add(i);
                    k = 0;  // 清空k，下次重新从0开始报数
                }
            }
        }
        return out_items;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("数组实现约瑟夫环问题：");

        System.out.print("共有 n 人：");
        int n = scanner.nextInt();  // n 为总人数
        System.out.print("数到数字 m 时出局：");
        int m = scanner.nextInt();  // 数到 m 时出局
        System.out.print("要留下多少人：");
        int peopleLeft = scanner.nextInt();  // 要留下的人数

        System.out.println(JosephusArray(n, m, peopleLeft));
    }
}
