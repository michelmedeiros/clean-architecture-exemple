package br.com.clean.architecture.example.infra.gateway.encrypt;

import br.com.clean.architecture.example.domain.student.EncryptPassword;
import br.com.clean.architecture.example.infra.exceptions.InvalidEncryptException;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

@Service
public class PasswordAlgorithmAES implements EncryptPassword {

    public static final String AES_CBC_PKCS_ALGORITHM = "AES/CBC/PKCS5Padding";

    private static SecretKey secretKey;
    private static IvParameterSpec ivParameterSpec;

    @Override
    public String encrypt(String password) throws InvalidEncryptException {
        try {
            SecretKey key = generateKey(128);
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_ALGORITHM);
            IvParameterSpec ivParameterSpec = this.generateIv();
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            byte[] cipherText = cipher.doFinal(password.getBytes());
            return Base64.getEncoder()
                    .encodeToString(cipherText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException
                | BadPaddingException e) {
            throw new InvalidEncryptException("Invalid encrypt password: " + password, e);
        }
    }

    @Override
    public String decrypt(String encryptPassword) throws InvalidEncryptException {
        try {
            SecretKey key = generateKey(128);
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_ALGORITHM);
            IvParameterSpec ivParameterSpec = this.generateIv();
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            byte[] plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(encryptPassword));
            return new String(plainText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException
                | BadPaddingException e) {
            throw new InvalidEncryptException("Invalid decrypt password: " + encryptPassword, e);
        }
    }

    public static SecretKey generateKey(int size) throws NoSuchAlgorithmException {
        if(Objects.isNull(secretKey)) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(size);
            secretKey = keyGenerator.generateKey();
        }
        return secretKey;
    }

    public IvParameterSpec generateIv() {
        if(Objects.isNull(ivParameterSpec)) {
            byte[] iv = new byte[16];
            new SecureRandom().nextBytes(iv);
            ivParameterSpec = new IvParameterSpec(iv);
        }
        return ivParameterSpec;
    }

    @Override
    public boolean isValidEncryptedPassword(String passwordEncrypted, String password) throws InvalidEncryptException {
        var cipherText = this.encrypt(password);
        return cipherText.equals(passwordEncrypted);
    }


}
