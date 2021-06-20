package net.playdoh.algo;

//TC - Linear - o(n)
//SC - Linear - o(n)
//Purpose - Push Zeros to the End
public class PushZeros {


    public static void main(String[] args) {

        int zeroCount = 0;
        String numStr = "5066012";
        System.out.println("Input String ::: " + numStr);
        StringBuffer numBuf = new StringBuffer(numStr.length());
        if (numStr.indexOf('0') >= 0) {
            for (int i = 0; i < numStr.length(); i++) {

                if (numStr.charAt(i) != '0') {
                    numBuf.insert(i, numStr.charAt(i));
                } else {
                    numBuf.setCharAt(numStr.length() - (zeroCount + 1), '0');
                    zeroCount++;
                }
            }
        }
        System.out.println("Output String ::: " + numBuf.toString());
    }
}
