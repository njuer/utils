# jasypt使用方法

## 1. 生成非对称密钥对

运行JasyptEncryptionApplication，启动tomcat，默认端口为`8080`。

使用浏览器或postman，使用`GET`方式，生成密钥对。

### 接口：生成非对称密钥对

```bash
http://127.0.0.1:8080/encryptor/gen-key-pair
```

请求成功后获取密钥对，参考样例如下：

```bash
-----BEGIN PRIVATE KEY-----
MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCuJtq9HeEF3pSk8uxjImsXcm2W
uCmDibstL151tHZHryh8rDa2G/1PufQZLeuCxCtWQXrKQDwaiNjj7spHq6U1p/NJFLswpIv3RZ7e
OzEeRhdBgXWiyxVBwUddn4bJtBirIZE1pD3iWp1FA+QA3a172GBNOiBOfG+3uDuPNqeWSYL9tBUB
aewWrE2TKc29Y+lNcv4tkYXfyo34RO0RgZQo/FzP68K+KBaagRuaXExvw5nAzV2KE4WziOPkjD2P
5C7fcxXcSSsCqzdcr/Sajawcn2E2hYYMQCG8wIxD/sQFy8PE8ZMnijXBW2g+eWnyYDFcmEvEqYYW
oanyveJLJyH1AgMBAAECggEAPfaJIXy+Ea6OSNo+DU+zttX59AR2kNyygnM2Mr8QzpSd3S4REV6I
FJPfLA5Qm2hc2wXVQJz2RaKnOQI/apzB3YNyZnA/4iDJxCM7UWrSISljIOWFC3UijRDN6ZvXA3FW
zZzV47YaZq1DA8lMmJpHHadxLEkgMYzI2x9r4ZraqffKq5RP48gRW/45+hrKm/MtAEquVUh9mpvS
uKlOLz3kgmkD03yD0OySRvpvkGH6wXBz3V21HBSMApWJFcFKhXFcJj6vRxkO6MsCeZZvmmf3vrWu
q88wqsuzeJU4cjhQEV279AarW+ePSo34Yt4Oa+06EUcR8tLQOW32YRLq/+GzgQKBgQDszGY8OEi1
HPClJxMKJoM+jN5hAc0EW6kcwy/jOEeDbR6TT1hPo6V7yaoHyjSeR6iyYofMKYxbZD9EG9JzaVfT
KjceXaDfRoMt3eykPw7PiZ2Q/a0xc1fQJ+FKGbi3evl6LtdbuGFXtvcGVv2qSaNzzbryBYZu0Nb1
BCPxdGab0QKBgQC8Rf/AJggPpjvpJg8G99flRjdPgikVH3Z32uc/jNCKl+1wqFY9iLAFbGCzIE3Z
/WKJPUZPJ/3jJ9t31GGEsQ5fLnklH9eXfT/ppoofwbYgXvPglfeohKipXRfPIxXT38Ef04KWFfWE
oRfUOgQW2gkFJ72he3TTjb5prExMi7HA5QKBgFMCfDxUBrjmwj1C61u9kHiW7UXYWcRTVX8ttVXT
3s3lrLg7MlwIo/Q3B5Hfgn6R5ENUYwJg9kD7bWo0zpuCrDTsMZJFhCWBFG85wsD5EfoS5ddz9gjF
xFzF/iX5ylUXmOkKDpiqlAUpsILab+YIFnJ8BjLdWPjz4MbXgrob8fRhAoGBAK4kaNyH0Oj4r22F
oFynnfAZtEs8b1d0VJWjykVDsBihUiPj8HDWH0nE5uSIOroo3p1mKcRJj1IuqZb6wICFbG+pgrBN
9ZHPbfBl9FhPSnBCo3zV+c7LdV3CF6WmJChnTDBt6Nl90iws/Od2ChZA8hrsmT/l+zc6YidIEQK0
K2PpAoGAY1g9qjSRUciJigA54p6xdT51KSdpQ0/XKMNBmK2JYRDry4vA3Kcw5fEzX9WeomciRwik
F2WfQsqbmw3fu0XMQjZDCzS9jpiqexGv4BwQWk4hCMHhj9NnaeEaWoWiYo0j6QaSyyIo11py7QiR
orlGe7jPGQF60jgQ+Y8PGh4lP3o=
-----END PRIVATE KEY-----

-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAribavR3hBd6UpPLsYyJrF3Jtlrgpg4m7
LS9edbR2R68ofKw2thv9T7n0GS3rgsQrVkF6ykA8GojY4+7KR6ulNafzSRS7MKSL90We3jsxHkYX
QYF1ossVQcFHXZ+GybQYqyGRNaQ94lqdRQPkAN2te9hgTTogTnxvt7g7jzanlkmC/bQVAWnsFqxN
kynNvWPpTXL+LZGF38qN+ETtEYGUKPxcz+vCvigWmoEbmlxMb8OZwM1dihOFs4jj5Iw9j+Qu33MV
3EkrAqs3XK/0mo2sHJ9hNoWGDEAhvMCMQ/7EBcvDxPGTJ4o1wVtoPnlp8mAxXJhLxKmGFqGp8r3i
Sych9QIDAQAB
-----END PUBLIC KEY-----

```

其中
- `PRIVATE KEY`全文保存成`private.rsa.pem`文件，放置于`classpath`目录下。
- `PUBLIC KEY`配置于`${jasypt-encryption.public-key-string}`中，注意`|-`前缀为必须的。

完整的`application.yaml`中`jasypt`配置样例如下所示：

```bash
jasypt:
  encryptor:
    private-key-format: PEM
    private-key-location: classpath:private.rsa.pem

jasypt-encryption:
  encryption-algorithm: RSA
  public-key-string: |-
    -----BEGIN PUBLIC KEY-----
    MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAribavR3hBd6UpPLsYyJrF3Jtlrgpg4m7
    LS9edbR2R68ofKw2thv9T7n0GS3rgsQrVkF6ykA8GojY4+7KR6ulNafzSRS7MKSL90We3jsxHkYX
    QYF1ossVQcFHXZ+GybQYqyGRNaQ94lqdRQPkAN2te9hgTTogTnxvt7g7jzanlkmC/bQVAWnsFqxN
    kynNvWPpTXL+LZGF38qN+ETtEYGUKPxcz+vCvigWmoEbmlxMb8OZwM1dihOFs4jj5Iw9j+Qu33MV
    3EkrAqs3XK/0mo2sHJ9hNoWGDEAhvMCMQ/7EBcvDxPGTJ4o1wVtoPnlp8mAxXJhLxKmGFqGp8r3i
    Sych9QIDAQAB
    -----END PUBLIC KEY-----

```


## 2. 加密

将第一步生成的非对称密钥对`PRIVATE KEY`、`PUBLIC KEY`配置于项目中，重启tomcat，调用`/encryptor/encrypt`接口加密原始密码。

### 接口：加密

```bash
http://127.0.0.1:8080/encryptor/encrypt
```

举例如下：

postman中body内配置原始密码为`abcdefg`,调用加密接口后生成密码如下所示：

```bash
cBSkExtLJevb5lJzTg63sXZbAV/Q+r5x8RRX58EdMZBc+KypOYaB1yTApx5V0Y804gPFjt4LDETMNSRZBNimPQcfTQa89329kbbFm946Jn94HA7Dlpgi/xbAtlfe6vmlcYmhhXbAe6lgAgMl8woZcU0b1kibKM/yLPO90AiTFzJKolTlpl9t0kdvQ3qydgXGzJZNbbRfdFE4HuUEmBD0h867K+yqpa02X5FybqC4ovJ2nBuwfo8ispa0Uv0uQgeAFo6/6JKKuE4BWPLzvmImpZ8cHn4RTIcCKA98NM9wRi7J6BOcfCioTj3mEgpQFeoySxfN3+ZAbPYEpiHVOgaR5w==
```


## 3. 解密

将第二步生成的加密码拷贝至postman中body内，调用`/encryptor/decrypt`接口解密密码，得到原始密码`abcdefg`。

### 接口：解密

```bash
http://127.0.0.1:8080/encryptor/decrypt
```


## 4. 在项目中使用

通过`encryption`模块将原始密码加密好后，即可在实际项目中使用。

## 4.1. 在项目中引入jasypt

```xml
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>[3.0.4,)</version>
</dependency>
```

## 4.2. 拷贝`private.rsa.pem`

将`private.rsa.pem`文件拷贝至`classpath`目录下。

## 4.3. 配置`application.yaml`

将jasypt相关配置添加到`application.yaml`中，加密后的密码需要使用`ENC(加密密码)`的形式使用，例如下例中`${spring.datasource.password}`的原始密码为`abcdefg`，加密后的值为`cBSkExtLJevb5lJzTg63sXZbAV/Q+r5x8RRX58EdMZBc+KypOYaB1yTApx5V0Y804gPFjt4LDETMNSRZBNimPQcfTQa89329kbbFm946Jn94HA7Dlpgi/xbAtlfe6vmlcYmhhXbAe6lgAgMl8woZcU0b1kibKM/yLPO90AiTFzJKolTlpl9t0kdvQ3qydgXGzJZNbbRfdFE4HuUEmBD0h867K+yqpa02X5FybqC4ovJ2nBuwfo8ispa0Uv0uQgeAFo6/6JKKuE4BWPLzvmImpZ8cHn4RTIcCKA98NM9wRi7J6BOcfCioTj3mEgpQFeoySxfN3+ZAbPYEpiHVOgaR5w==`,配置值为`ENC(cBSkExtLJevb5lJzTg63sXZbAV/Q+r5x8RRX58EdMZBc+KypOYaB1yTApx5V0Y804gPFjt4LDETMNSRZBNimPQcfTQa89329kbbFm946Jn94HA7Dlpgi/xbAtlfe6vmlcYmhhXbAe6lgAgMl8woZcU0b1kibKM/yLPO90AiTFzJKolTlpl9t0kdvQ3qydgXGzJZNbbRfdFE4HuUEmBD0h867K+yqpa02X5FybqC4ovJ2nBuwfo8ispa0Uv0uQgeAFo6/6JKKuE4BWPLzvmImpZ8cHn4RTIcCKA98NM9wRi7J6BOcfCioTj3mEgpQFeoySxfN3+ZAbPYEpiHVOgaR5w==)`
。
```bash
jasypt:
  encryptor:
    private-key-format: PEM
    private-key-location: classpath:private.rsa.pem

jasypt-encryption:
  encryption-algorithm: RSA
  public-key-string: |-
    -----BEGIN PUBLIC KEY-----
    MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAribavR3hBd6UpPLsYyJrF3Jtlrgpg4m7
    LS9edbR2R68ofKw2thv9T7n0GS3rgsQrVkF6ykA8GojY4+7KR6ulNafzSRS7MKSL90We3jsxHkYX
    QYF1ossVQcFHXZ+GybQYqyGRNaQ94lqdRQPkAN2te9hgTTogTnxvt7g7jzanlkmC/bQVAWnsFqxN
    kynNvWPpTXL+LZGF38qN+ETtEYGUKPxcz+vCvigWmoEbmlxMb8OZwM1dihOFs4jj5Iw9j+Qu33MV
    3EkrAqs3XK/0mo2sHJ9hNoWGDEAhvMCMQ/7EBcvDxPGTJ4o1wVtoPnlp8mAxXJhLxKmGFqGp8r3i
    Sych9QIDAQAB
    -----END PUBLIC KEY-----

spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/dev?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
    username: root
    password: ENC(cBSkExtLJevb5lJzTg63sXZbAV/Q+r5x8RRX58EdMZBc+KypOYaB1yTApx5V0Y804gPFjt4LDETMNSRZBNimPQcfTQa89329kbbFm946Jn94HA7Dlpgi/xbAtlfe6vmlcYmhhXbAe6lgAgMl8woZcU0b1kibKM/yLPO90AiTFzJKolTlpl9t0kdvQ3qydgXGzJZNbbRfdFE4HuUEmBD0h867K+yqpa02X5FybqC4ovJ2nBuwfo8ispa0Uv0uQgeAFo6/6JKKuE4BWPLzvmImpZ8cHn4RTIcCKA98NM9wRi7J6BOcfCioTj3mEgpQFeoySxfN3+ZAbPYEpiHVOgaR5w==)
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 4.4. 运行项目

开始happy吧！