package net.playdoh.algo;

//TC - Linear - o(n)
//SC - Linear - o(n)
//Purpose - Push Zeros to the End
public class PushZeros {


    public static void main(String[] args) {

        int zeroCount = 0;
        String numStr = "5066012";
        StringBuffer numBuf = new StringBuffer();
        System.out.println("Input String ::: " + numStr);

        for (int i = 0; i < numStr.length() + zeroCount; i++) {

            if (i >= numStr.length()) {

                numBuf.append('0');
                continue;
            }
            if (numStr.charAt(i) != '0') {
                numBuf.append(numStr.charAt(i));
            } else {
                zeroCount++;
            }
        }
        System.out.println("ZeroCount ::: " + zeroCount);
        System.out.println("Output String ::: " + numBuf.toString());
    }
}
