package com.okaytech.encryption.encryptor;

public interface Encryptor {

    String generateKeyPair();

    String encrypt(String message);

    String decrypt(String encryptedMessage);
}
