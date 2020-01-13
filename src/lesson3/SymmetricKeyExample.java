package lesson3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;


public class SymmetricKeyExample {
    private SecretKeySpec secretKey;
    private Cipher cipher;
    public SymmetricKeyExample(String secret, int length,String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException{
        byte[] key = new byte[length];
        key=fixSecret(secret,length);
        this.secretKey=new SecretKeySpec(key, algorithm);
        this.cipher=Cipher.getInstance(algorithm);
    }

    private byte[]fixSecret(String s, int length) throws UnsupportedEncodingException{
        if (s.length()<length){
            int missingLength=length - s.length();
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < missingLength; i++) {
                sBuilder.append(" ");
            }
            s = sBuilder.toString();
        }
        return s.substring(0,length).getBytes(StandardCharsets.UTF_8);
    }

    public void decryptFile(File f)throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException{
        System.out.println("Decrypting file: "+f.getName());
        this.cipher.init(Cipher.DECRYPT_MODE,this.secretKey);
        this.writeToFile(f);
    }
    private void writeToFile(File f) throws IOException, IllegalBlockSizeException, BadPaddingException{
        FileInputStream in = new FileInputStream(f);
        byte[] input = new byte[(int) f.length()];
        in.read();

        FileOutputStream out = new FileOutputStream(f);
        byte[] output=this.cipher.doFinal(input);
        out.write(output);

        out.flush();
        out.close();
        in.close();
    }

    public static void main(String[] args) {
        File dir = new File("C://Games//encoded.txt");
        File[] filelist = dir.listFiles();

        SymmetricKeyExample ske;
        try {
            ske = new SymmetricKeyExample("!@#$MySecr3tPassw0rd", 16, "AES");
            int choice=-2;
            while (choice!=-1){
                String[] options={"Encrypt File","Decrypt File","Exit"};
                choice=JOptionPane.showOptionDialog(null,"Select an option","Options",0,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if (choice == 0) {
                    Arrays.asList(filelist).forEach(file -> {
                        try {
                            ske.decryptFile(file);
                        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException | IOException e) {
                            System.err.println("Couldn't decrypt " + file.getName() + ": " + e.getMessage());
                        }
                    });
                    System.out.println("Files decrypted successfully");
                } else {
                    choice = -1;
                }
            }
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}