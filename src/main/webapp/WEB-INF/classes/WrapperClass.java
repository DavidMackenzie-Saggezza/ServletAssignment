import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WrapperClass extends HttpServletRequestWrapper {
    public WrapperClass(HttpServletRequest request) {
        super(request);
    }

    //Random Method
    public int[] fibonacci(int n) {

        if (n < 2) {
            throw new IllegalArgumentException("Fibonacci numbers must be greater than 1");
        }
        int[] finonacciNums = new int[n];
        finonacciNums[0] = 1;
        finonacciNums[1] = 1;
        for (int i = 2; i < n; i++) {
            finonacciNums[i] = finonacciNums[i-1] + finonacciNums[i-2];
        }
        return finonacciNums;
    }
}
