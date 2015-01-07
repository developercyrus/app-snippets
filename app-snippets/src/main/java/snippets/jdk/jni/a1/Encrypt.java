package snippets.jdk.jni.a1;

public class Encrypt {
    public Encrypt() {
        String path = this.getClass().getResource("php_mcrypt.dll").getFile(); //32bit dll, unable to resolve yet
        System.out.println(path);
        System.load(path);
    }
    
    public native byte[] base64Decode(String paramString);

    public native String base64Encode(byte[] paramArrayOfByte);

    public native byte[] decodeBytes(byte[] paramArrayOfByte);

    public native String decodeBytesWithIV(byte[] paramArrayOfByte);

    public native byte[] decodeBytesWithKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

    public native byte[] encodeBytes(byte[] paramArrayOfByte);

    public native byte[] encodeBytesWithKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

    public native String md5(String paramString);

    public native String md5WithKey(String paramString);
    
    
    public static void main(String[] args) {
        Encrypt e = new Encrypt();
        System.out.println(e.md5("hello world"));
    }
}
