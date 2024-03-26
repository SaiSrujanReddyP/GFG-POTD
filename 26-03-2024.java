class Solution {
    public boolean isAdditiveSequence(String s) {
        List<String> res = new ArrayList<>();
        int l = s.length();

        for (int i = 1; i <= l / 2; i++) {
            for (int j = 1; j <= (l - i) / 2; j++) {
                if (checkAddition(res, s.substring(0, i), s.substring(i, i + j),
                                  s.substring(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkAddition(List<String> res, String a, String b, String c) {
        if (!isValid(a) || !isValid(b)) return false;
        String sum = addString(a, b);

        if (sum.equals(c)) {
            res.add(sum);
            return true;
        }

        if (c.length() <= sum.length() || !sum.equals(c.substring(0, sum.length())))
            return false;
        else {
            res.add(sum);
            return checkAddition(res, b, sum, c.substring(sum.length()));
        }
    }

    boolean isValid(String num) {
        if (num.length() > 1 && num.charAt(0) == '0') return false;
        return true;
    }

    int val(String a, int pos) {
        if (pos >= a.length() || pos < 0) return 0;
        return (a.charAt(pos) - '0');
    }

    String addString(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int t = val(a, i) + val(b, j) + carry;
            sum.append(t % 10);
            carry = t / 10;
            i--;
            j--;
        }
        if (carry > 0) sum.append(carry);
        return sum.reverse().toString();
    }
}
