package snippets.jdk.util.zip.a2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflatorApp {
    public static byte[] compressBytes(String data) throws UnsupportedEncodingException, IOException {
        byte[] input = data.getBytes("UTF-8"); 
        Deflater df = new Deflater();      
        df.setInput(input);

        ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);   
        df.finish();
        byte[] buff = new byte[1024];  
        while (!df.finished()) {
            int count = df.deflate(buff);       
            baos.write(buff, 0, count);     
        }
        baos.close();
        byte[] output = baos.toByteArray();

        System.out.println("Original: " + input.length);
        System.out.println("Compressed: " + output.length);
        return output;
    }

    public static String extractBytes(byte[] input) throws UnsupportedEncodingException, IOException, DataFormatException {
        Inflater ifl = new Inflater();   
        ifl.setInput(input);

        ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);
        byte[] buff = new byte[1024];
        while( !ifl.finished()) {
            int count = ifl.inflate(buff);
            baos.write(buff, 0, count);
        }
        baos.close();
        byte[] output = baos.toByteArray();

        System.out.println("Original: " + input.length);
        System.out.println("Extracted: " + output.length);
        return new String(output);
    }

    public static void main(String[] args) {
        String text =   "Hellooo dear! This is a long long long " +
                        "string consuming so much memory. So just " +
                        "compress this string to smaller byte[] array " +
                        "using deflater and store it in byte array " +
                        "and when need extract the byte array again" +
                        "to string!!!!";
        try {
            System.out.println("Original string: " + text);

            byte[] compressedText = compressBytes(text);
            String extractedText = extractBytes(compressedText);

            System.out.println("Extracted string: " + extractedText);
        }
        catch (DataFormatException ex)
        {
            ex.printStackTrace();
        }
        catch (UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
