public class main {
    public static void main(String[] args) {
        int i = 5;

        System.out.println(i++); // 输出 5，然后 i 变成 6
        System.out.println(i);   // 输出 6

        System.out.println(++i); // i 先变成 7，再输出 7
        System.out.println(i);   // 输出 7

        System.out.println(i--); // 输出 7，然后 i 变成 6
        System.out.println(--i); // i 先变成 5，再输出 5
    }
}
