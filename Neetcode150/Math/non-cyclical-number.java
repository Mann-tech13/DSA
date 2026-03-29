class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        boolean cyc = false;
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int num = n;
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
