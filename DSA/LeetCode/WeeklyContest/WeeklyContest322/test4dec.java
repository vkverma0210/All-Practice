public class test4dec {
    public static boolean isCircularSentence(String sentence) {
        String[] sen = sentence.split(",");

        for (int i = 0; i < sen.length; i++) {
            char[] arr = sen[i].toCharArray();
            if(arr[])
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scr.nextInt();
        }

        System.out.println(unequalTriplets(nums));
        scr.close();
    }
}
