public class min_deletion {
    public int minimumDeletions(String s) {
        int deletions = 0;
        int bCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else { // c == 'a'
                if (bCount > 0) {
                    // We found an 'a' after a 'b'. 
                    // We must delete either this 'a' or one previous 'b'.
                    deletions++;
                    bCount--;
                }
            }
        }

        return deletions;
    }
}
