import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter numbers (type stop to finish):");

        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equalsIgnoreCase("stop")) break;
            try {
                nums.add(Integer.parseInt(s)); // Autoboxing
            } catch (Exception e) {
                System.out.println("Invalid input: " + s);
            }
        }

        int sum = 0;
        for (Integer n : nums) sum += n; // Unboxing
        System.out.println("Sum = " + sum);
    }
}
