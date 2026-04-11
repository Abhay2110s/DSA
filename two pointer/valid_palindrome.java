//! Leetcode problem 125
//? To check whether the string is valid palindrome or not...


public class valid_palindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if(!Character.isLetterOrDigit(chi))
            {
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(chj))
            {
                j--;
                continue;
            }

            if(Character.toLowerCase(chi) != Character.toLowerCase(chj))
            {
                return false;
            }

            i++;
            j--;

        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man , a plan , a canal : Panama";
        System.out.println(isPalindrome(str));

    }
    
}
