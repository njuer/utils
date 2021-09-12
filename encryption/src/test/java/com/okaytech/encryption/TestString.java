package com.okaytech.encryption;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;

/**
 * @Author neiplz
 * @Description //TODO
 * @Date 2019/9/18
 **/
public class TestString {

    @Test
    public void testEncryption() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // 加密所需的salt(盐)
        textEncryptor.setPassword("ZAbPYEpiHVOgaR5w");
        // 要加密的数据（数据库的用户名或密码）
        String encryptedPassword = textEncryptor.encrypt("root123");
        System.out.println("加密后 password:" + encryptedPassword);

        String decryptedPassword = textEncryptor.decrypt(encryptedPassword);
        System.out.println("解密后 password:" + decryptedPassword);
    }


}
