import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution3 {
    /**
     * 递归法（递推公式）解决约瑟夫问题
     * @param n 一共有 n 个人
     * @param m 报数到 m 就出局
     * @param peopleLeft 要求最终幸存的人数
     */
    static List<Integer> JosephusRecursion(int n, int m, int peopleLeft) {
        List<Integer> out_items = new ArrayList<>();    // 存放出局元素序列

        // n-people 即要进行出局操作的次数
        for (int i = 1; i <= n-peopleLeft; i++) {
            out_items.add(J(n, m, i)+1);
        }

        return out_items;
    }

    /**
     * 递归方法
     * @param n 参与报数的总人数
     * @param m 报数到 m 就出局
     * @param i 第 i 次出局
     * @return 第 i 次出局的人（的编号）
     */
    static int J(int n, int m, int i){
        if(i == 1) {
            return (n+m-1) % n;
        }else{
            return (J(n-1, m, i-1) + m) % n;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("循环链表实现约瑟夫环问题：");

        System.out.print("共有 n 人：");
        int n = scanner.nextInt();  // n 为总人数
        System.out.print("数到数字 m 时出局：");
        int m = scanner.nextInt();  // 数到 m 时出局
        System.out.print("要留下多少人：");
        int peopleLeft = scanner.nextInt();  // 要留下的人数

        System.out.println(JosephusRecursion(n,m,peopleLeft));


    }
}


