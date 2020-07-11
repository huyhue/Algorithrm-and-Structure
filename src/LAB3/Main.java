package LAB3;
public class Main {

    static int findMin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return findMin(a, n - 1);
    }

    static int findSum(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return a[n - 1] + findSum(a, n - 1);
    }

    static boolean isPalRec(String str, int s, int e) {
        if (s == e) {
            return true;
        }
        if ((str.charAt(s)) != (str.charAt(e))) {
            return false;
        }
        if (s < e + 1) {
            return isPalRec(str, s + 1, e - 1);
        }

        return true;
    }

    static boolean isPalindrome(String str) {
        int n = str.length();
        if (n == 0) {
            return true;
        }
        return isPalRec(str, 0, n - 1);
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    static int gcd(int a, int b) {
        // Everything divides 0
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int power(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            return a * power(a, n - 1);
        }
    }

    static int frac(int n) {  //5! = 120
        if (n > 0) {
            return frac(n - 1) * n;
        } else {
            return 1;
        }
    }

    public static int fibo(int n) {   //1 1 2 3 5 8 13 21 34 55 89 144
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 9, 3, 5, 7};
        int n = a.length;
        System.out.println(n);
        System.out.println("Min: " + findMin(a, n));
        System.out.println("Sum: " + findSum(a, n));

        String str = "geeg";
        System.out.println("Palindrome String: " + isPalindrome(str));
        String str1 = "rgeeg";
        System.out.println("Palindrome String: " + isPalindrome(str1));
        String str2 = "gekog";
        System.out.println("Palindrome String: " + isPalindrome(str2));
        
        System.out.println("GDC: " + gcd(8, 2));
        System.out.println("power 2^3: " + power(2, 3));
        System.out.println("frac: " + frac(5));
        System.out.println("fibo: " + fibo(6));
        
    }
}
