package com.okaytech.encryption.encryptor;

import com.okaytech.encryption.config.ApplicationConfig;
import com.okaytech.encryption.error.ApplicationException;
import com.ulisesbocchio.jasyptspringboot.encryptor.SimpleAsymmetricByteEncryptor;
import com.ulisesbocchio.jasyptspringboot.encryptor.SimpleAsymmetricConfig;
import com.ulisesbocchio.jasyptspringboot.encryptor.SimpleAsymmetricStringEncryptor;
import com.ulisesbocchio.jasyptspringboot.util.AsymmetricCryptography;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class EncryptorImpl implements Encryptor {
    private ApplicationConfig applicationConfig;
    @Value("${jasypt.encryptor.private-key-location}")
    private String privateKeylocation;

    public EncryptorImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public String generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator =
                KeyPairGenerator.getInstance(applicationConfig.getEncryptionAlgorithm());
            keyPairGenerator.initialize(2048);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            String keyPairString = new StringBuilder().append("-----BEGIN PRIVATE KEY-----\n")
                .append(Base64.getMimeEncoder().encodeToString(keyPair.getPrivate().getEncoded())).append("\n")
                .append("-----END PRIVATE KEY-----\n").append("\n").append("-----BEGIN PUBLIC KEY-----\n")
                .append(Base64.getMimeEncoder().encodeToString(keyPair.getPublic().getEncoded())).append("\n")
                .append("-----END PUBLIC KEY-----\n").toString();

            return keyPairString;
        } catch (NoSuchAlgorithmException e) {
            throw new ApplicationException("No such algorithm: " + applicationConfig.getEncryptionAlgorithm(), e);
        }
    }

    @Override
    public String encrypt(String message) {
        SimpleAsymmetricConfig config = new SimpleAsymmetricConfig();
        config.setPublicKey(applicationConfig.getPublicKeyString());
        config.setKeyFormat(AsymmetricCryptography.KeyFormat.PEM);

        StringEncryptor encryptor = new SimpleAsymmetricStringEncryptor(config);

        return encryptor.encrypt(message);
    }

    @Override
    public String decrypt(String encryptedMessage) {
        SimpleAsymmetricConfig config = new SimpleAsymmetricConfig();
        config.setPrivateKeyLocation(privateKeylocation);
        config.setKeyFormat(AsymmetricCryptography.KeyFormat.PEM);

        SimpleAsymmetricByteEncryptor encryptor = new SimpleAsymmetricByteEncryptor(config);
        return new String(encryptor.decrypt(Base64.getDecoder().decode(encryptedMessage)), StandardCharsets.UTF_8);
    }
}
