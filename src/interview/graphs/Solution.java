package interview.graphs;

import java.util.*;

/* Problem Name is &&& ApacheLog &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findTopIpAddress() correctly.
 *  4) If time permits, try to improve your implementation.
 */

public class Solution {

    /**
     * String findTopIpaddress(String[] lines)
     * Given an Apache log file, return IP address(es) which accesses the site most often.
     *
     * Our log is in this format (Common Log Format). One entry per line and it starts with an IP address which accessed the site,
     * followed by a whitespace.
     *
     * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
     *
     * Log file entries are passsed as an interview.array.
     */



    public static String findTopIpaddress(String[] lines) {
        // TODO: Implement solution


        // Split the line by space and consider only the first element. Add it to a interview.string list and find the interview.string that occurs the max times.
        String delimiter = "#";

        if(lines == null || lines.length == 0) {
            return null;
        }


        List<String> ips = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuffer s =  new StringBuffer();

        for(String line: lines) {

            if(line == null || line.length() == 0) {
                continue;
            }

            String[] eachLine =  line.split(" ");
            String ip = eachLine[0];
            if(ip.length() != 0) {
                if(map.containsKey(ip)){
                    int count = map.get(ip);
                    map.put(ip, count+1);
                } else {
                    map.put(ip, 1);
                }
            }
        }



        int max = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if(count > max) {
                max = count;
                s.append(entry.getKey());
            } else if (count == max) {
                if(s.toString().length() == 0) {
                    s.append(entry.getKey());
                } else {
                    s.append(delimiter.concat(entry.getKey()));
                }

            }

        }


        return s.toString();

    }

    /**


     A
     B
     C
     C
     B
     D

     A - 1
     B - 2
     C - 2
     D - 1

     max  = A
     max B
     max C
     * boolean doTestsPass()
     * Returns true if the test passes. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: improve the test
        String lines[] = new String[] {
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");
            return true;
        } else {
            System.out.println("Test failed");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
        doTestsPass1();
    }

    public static boolean doTestsPass1() {
        // TODO: improve the test
        String lines[] = new String[] {
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"
        };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1#10.0.0.2")) {
            System.out.println("Test passed");
            return true;
        } else {
            System.out.println("Test failed");
            return false;
        }
    }


}
