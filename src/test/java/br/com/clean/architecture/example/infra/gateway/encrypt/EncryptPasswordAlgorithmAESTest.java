package br.com.clean.architecture.example.infra.gateway.encrypt;

import br.com.clean.architecture.example.infra.exceptions.InvalidEncryptException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class EncryptPasswordAlgorithmAESTest {

    @InjectMocks
    private PasswordAlgorithmAES passwordAlgorithm;

    @Test
    @DisplayName("Encrypt password with success")
    void givenPasswordWhenEncryptThenSuccess() throws InvalidEncryptException {
        String password = "teste";
        var encryptedCipherText = passwordAlgorithm.encrypt(password);
        assertTrue(passwordAlgorithm.isValidEncryptedPassword(encryptedCipherText, password));
    }

    @Test
    @DisplayName("Decrypt password with success")
    void givenPasswordWhenDecryptThenSuccess() throws InvalidEncryptException {
        String password = "teste";
        var encryptedCipherText = passwordAlgorithm.encrypt(password);
        var decryptedCipherText = passwordAlgorithm.decrypt(encryptedCipherText);
        assertEquals(password, decryptedCipherText);
    }
}
