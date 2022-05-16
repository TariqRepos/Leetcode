class Solution {
    List<String> res;
    
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s.length() > 12)
            return res;
        dfs(0, 0, "", s);
        return res;
    }
    
    public void dfs(int ind, int dots, String curr, String ip){
        if(ind == ip.length() && dots == 4){
            res.add(curr.substring(0, curr.length()-1));
            return;
        }
        else if(dots > 4)
            return;
        
        else{
            for(int i = ind; i<Math.min(ind+3, ip.length()); i++){
                if(Integer.parseInt(ip.substring(ind, i+1)) < 256 
                   && (ind == i || ip.charAt(ind) != '0')){ // prevents leading 0s
                    dfs(i+1, dots+1, curr+ip.substring(ind, i+1)+".", ip);
                }
            }
        }            
    }
}