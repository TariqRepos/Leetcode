class Solution {
    public String makeGood(String s) {
        for(int i=0; i<s.length() - 1; i++){
            if(s.charAt(i) - 32 == s.charAt(i+1) || s.charAt(i) == s.charAt(i+1) - 32){
                return makeGood(s.substring(0, i) + s.substring(i+2));
            }
        }
        return s;
    }
}


// // Google string recursion question
// // "ABCqZqDqXq"
// class Solution {
//     HashMap<String, String> mappings;
    
//     public String makeGood(String s) {
//         mappings = new HashMap<>();
//         mappings.put("qZq", "789_qXq");
//         mappings.put("qXq", "123");
        
//         return decode(s);
//     }
    
//     public String decode(String s) {
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == 'q'){
//                 String uncoded_str = s.substring(i, i+3);
//                 if(!mappings.containsKey(uncoded_str))
//                     return "";
//                 String decoded_str = mappings.get(uncoded_str);
//                 return s.substring(0, i) + decode(decoded_str + s.substring(i+3));
//             }
//         }
        
//         return s;
//     }
// }