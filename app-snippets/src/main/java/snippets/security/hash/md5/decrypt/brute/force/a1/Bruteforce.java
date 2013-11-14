package snippets.security.hash.md5.decrypt.brute.force.a1;

import java.security.MessageDigest;

public class Bruteforce {
    static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789*+ ".toCharArray();

    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 15;

    static MessageDigest digest;

    static byte[] hash;
    static long start_time;

    public static void main(String[] args) {
        try {
            digest = java.security.MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String look = "b10a8db164e0754105b7a99be72e3fe5";
        hash = hexStringToByteArray(look);
        System.out.println("Looking for hash " + look);        
        start_time = System.currentTimeMillis();
        for (int baseWidth = MIN_LENGTH; baseWidth <= MAX_LENGTH; baseWidth++) {
            recurse(baseWidth, 0, "");
        }
        long ourtime = (System.currentTimeMillis() - start_time);
        System.out.println("[Failed]: Took " + (ourtime / 1000) + " secs");
    }

    static byte[] md5(String input) {
        digest.update(input.getBytes());
        return digest.digest();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    static void recurse(int width, int position, String baseString) {
        for (char ch : CHARS) {
            String word = baseString + ch;

            if (position < width - 1) {
                recurse(width, position + 1, word);
            }
            
            byte[] gen_hash = md5(word);
            System.out.println(word);
            if (byteComparison(gen_hash, hash)) {
                long ourtime = (System.currentTimeMillis() - start_time);
                System.out.println("\n[Done]: Success!, the hash resolves to: " + word);
                System.out.println("ms taken " + ourtime);
                System.exit(1);
            }
        }
    }

    static boolean byteComparison(byte[] a, byte[] b) {
        if (a.length == b.length) {
            for (int index = 0; index < a.length; index++) {
                if (a[index] != b[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
