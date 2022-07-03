class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            
            // Check if content is a digit
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                // Check if greater or less than
                if (cmp != 0)
                    return cmp;
                
                // If logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2)
                // the letter-log comes before digit-logs
                return -1;
            else if (isDigit1 && !isDigit2)
                return 1;
            else
                // case 3). both logs are digit-log
                return 0;
        });
        
        return logs;
    }
}