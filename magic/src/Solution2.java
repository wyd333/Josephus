import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
public class Solution2 {
    /**
     * 循环链表解决约瑟夫问题
     * @param n 一共有 n 个人
     * @param m 报数到 m 就出局
     * @param peopleLeft 要求最终幸存的人数
     */
    static List<Integer> JosephusCircleList(int n, int m, int peopleLeft) {
        List<Integer> out_items = new ArrayList<>();    // 存放出局元素序列

        // 1-创建循环链表
        Node head = new Node(1);    // 节点编号从1开始
        head.next = head;
        Node pre = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            pre.next = node;
            node.next = head;
            pre = pre.next;
        }

        int cnt = 0;    // 已经出局了的人数
        Node cur = head;
        // 2-遍历约瑟夫环
        while(peopleLeft != n-cnt) {    // 当没有达到要求剩下的人数时
            for (int k = 1; k < m; k++) {
                pre = cur;
                cur = cur.next;
            }
            out_items.add(cur.data);
            cnt++;
            pre.next = cur.next;
            cur = cur.next;
        }
        return out_items;
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

        System.out.println(JosephusCircleList(n,m,peopleLeft));
    }
}


