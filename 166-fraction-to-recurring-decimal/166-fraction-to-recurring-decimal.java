class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return result.toString();
        result.append(".");
        // System.out.println("result: " + result);
        Map<Long, Integer> map = new HashMap(); //store numerator as repetition of same numerator will cause recurring
        while(rem != 0){
            // System.out.println("rem: " + rem);
            if(!map.containsKey(rem)){
                 map.put(rem, result.length()); //for a given numerator its (num*10)/den starts from this idx
            }else {
                int idx = map.get(rem);
                return result.substring(0, idx)+"("+result.substring(idx)+")";
            }
            rem*= 10;
            // System.out.println("rem *= 10: " + rem);
            result.append(rem/den);
            // System.out.println("rem / den: " + rem/den);
            rem = rem%den;
            // System.out.println("rem % den: " + rem%den);
            // System.out.println(map);
            // System.out.println();
     }   
     return result.toString();
    }
}