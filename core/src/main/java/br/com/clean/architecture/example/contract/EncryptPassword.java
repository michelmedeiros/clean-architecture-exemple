package br.com.clean.architecture.example.contract;


import br.com.clean.architecture.example.exceptions.InvalidEncryptException;

public interface EncryptPassword {
    String encrypt(String password) throws InvalidEncryptException;
    String decrypt(String encryptPassword) throws InvalidEncryptException;
    boolean isValidEncryptedPassword(String passwordEncrypted, String password) throws InvalidEncryptException;
}
