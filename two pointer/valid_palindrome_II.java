//! Leetcode 680 
//? return ture if we can make the String palindrome by deleting at most one character....


public class valid_palindrome_II {

    public static boolean checkplaindrome(String s, int i , int j)
    {
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if(ci != cj)
            {
                //* can delete only one element
                return checkplaindrome(s, i+1, j) || checkplaindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abccdaa";
        System.out.println(validPalindrome(str));
    }
    
    //* We are generally checking two different strings after deleting the character i.e. in this example abca    
    //todo form left side if we delete one character after passing "a".
    //? means skipping b when it compare to c which are not equal than    aca (from left) and aba(from right) are form then we check is any of them is palindrome of not if not than return false else true.
}
