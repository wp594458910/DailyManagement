package com.daily.util;

import com.daily.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by IntelliJ IDEA.
 * Creator : peng
 * Date : 2018-03-26
 * Time : 8:56
 */
public class Test {
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        encryptPassword(user);
        System.out.println("salt:"+user.getSalt());
        System.out.println("password:"+user.getPassword());

    }

    public static void encryptPassword(User user) {

        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
}
