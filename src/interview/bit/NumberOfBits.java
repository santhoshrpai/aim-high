package interview.bit;

/**
 * @author rajasan
 */
public class NumberOfBits {

    public static int getNumberOfBits(int n) {
        return (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfBits(7));
    }

}
