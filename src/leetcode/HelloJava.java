package leetcode;

public class HelloJava {

    public static void main(String[] args) {
        int value = -1;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + value);
        for (int i = 0; i < 5; i++) {
            value <<= 7;
            System.out.println(">>>>>>>>>>>>>>>>>>>> " + value);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + (value >> 1));
    }

    private static void testVarargs(Object... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("" + args[i]);
        }
    }

}
