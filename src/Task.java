
import java.util.*;

public class Task {
    static Scanner scan = new Scanner(System.in);

    public static void n2() {
        System.out.println("input Int for split");
        int amount = scan.nextInt();
        // available coin , future can input coin
        Integer[] coinValues = {10, 5, 1, 20, 50};
        System.out.println(Work.minSplit(amount, coinValues));
    }

    public static void n3() {
        System.out.println("input array size");
        int quantity = scan.nextInt();
        int[] numbers = new int[quantity];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scan.nextInt();
        System.out.println(Arrays.toString(numbers));
        System.out.println(Work.notContains(numbers));
    }

    public static void n4() {
        System.out.println("input first Binary String");
        String firstString = scan.nextLine();
        System.out.println("input second Binary String");
        String secondString = scan.nextLine();
        System.out.println(Work.addBinary(firstString,secondString));
    }

    public static void n5() {
        System.out.println("input stair size");
        int stairsCount = scan.nextInt();
        System.out.println(Work.countVariants(stairsCount));
    }

    public static void n6() {
        MyDS ds = new MyDS();
        System.out.println("input data size");
        int size = scan.nextInt();
        for (int i = 0; i < size; i++)
            ds.add(scan.nextInt());

        System.out.println(ds.hashData);
        System.out.println("input delete element");
        ds.remove(scan.nextInt());
        System.out.println(ds.hashData);

    }
}

class Work {
    static int minSplit(int amount, Integer[] coinValues) {
        if (amount == 0)
            return 0;
        int minSplit = 0;
        Arrays.sort(coinValues, Collections.reverseOrder());
        System.out.println(Arrays.toString(coinValues));
        for (int coin : coinValues) {
            if (amount / coin == 0)
                continue;
            else {
//                System.out.println(amount);
//                System.out.println(coin);
                int quantity = amount / coin;
                amount = amount % coin;
//                System.out.println(amount);
                minSplit += quantity;
                if (amount == 0)
                    return quantity;
//                System.out.println(minSplit);
            }
        }
        return minSplit;
    }

    static int notContains(int[] numbers) {
        int max = 1;
        for (int i = 0; i < numbers.length; i++) {
//            max = numbers[i];
            if (max < numbers[i])
                max = numbers[i];
        }
        System.out.println(max);
        int[] numberChecker = new int[max + 1];
        System.out.println(Arrays.toString(numberChecker));
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0)
                numberChecker[numbers[i]] = 1;
        }
        System.out.println(Arrays.toString(numberChecker));
        for (int i = 1; i < numberChecker.length; i++) {
            if (numberChecker[i] == 0)
                return i;
        }
        return numberChecker.length;
    }

    public static int countVariants(int stairsCount) {
        if (stairsCount == 1 || stairsCount == 0)
            return 1;

        int num1 = 1;
        int num2 = 1;

        for (int i = 1; i < stairsCount; i++) {
            int countVariants = num1 + num2;
            num1 = num2;
            num2 = countVariants;
        }
        return num2;
    }

    public static String addBinary(String A, String B) {
        // initialize the ith index
        int i = A.length() - 1;
        // initialize the jth index
        int j = B.length() - 1;
        // initialize the carry
        int carry = 0;
        // initialize the sum
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            sum = carry;
            if (i >= 0) sum = sum + A.charAt(i) - '0';
            if (j >= 0) sum = sum + B.charAt(j) - '0';
            result.append((char) (sum % 2 + '0'));
            carry = sum / 2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}

class MyDS {
    HashMap<Integer, Integer> hashData;

    public MyDS() {
        hashData = new HashMap<Integer, Integer>();
    }

    void add(int x) {
        if (hashData.get(x) != null)
            return;

        hashData.put(x, x);
    }

    void remove(int x) {
        Integer index = hashData.get(x);
        if (index == null)
            return;

        hashData.remove(x);
    }
}
