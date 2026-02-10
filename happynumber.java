public class happynumber {
    public static boolean isHappy(int n) {
        if(n==1 || n == 7) return true;
        else if(n<10) return false;
        else{
            int sum=0;
            while(n>0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            return isHappy(sum);
        }
    }


    public static void main(String[] args) 
    {
        int n = 7;
        boolean result = isHappy(n);
        System.out.println("Happy number   "+result);
    }
}
