class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int l = 0;
        int r = products.length - 1;
        
        for(int i=0; i<searchWord.length(); i++) {
            List<String> level = new ArrayList<>();
            Character c = searchWord.charAt(i);
            
            while(l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }
            while(l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }
            
            for(int j=l; j<Math.min(l+3, r+1); j++) {
                level.add(products[j]);
            }
            
            res.add(level);
        }
        return res;
        
        
    }
}