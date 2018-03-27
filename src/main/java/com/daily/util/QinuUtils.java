package com.daily.util;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;
import com.qiniu.api.rs.URLUtils;
import org.json.JSONException;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * Creator : peng
 * Date : 2018-03-27
 * Time : 14:34
 */
public class QinuUtils {
    private String bucketName;
    private String domain;

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setAccessKey(String accessKey) {
        Config.ACCESS_KEY = accessKey;
    }

    public void setSecretKey(String secretKey) {
        Config.SECRET_KEY = secretKey;
    }

    public boolean uploadFile(String localFile) throws AuthException, JSONException {
        File file = new File(localFile);
        return uploadFile(file);
    }

    public boolean uploadFile(File file) throws AuthException, JSONException {
        String uptoken = getUpToken();
        PutExtra extra = new PutExtra();
        PutRet ret = IoApi.putFile(uptoken, file.getName(), file.getAbsolutePath(), extra);
        if (ret.ok()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean uploadFile(String key, String content) throws AuthException, JSONException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
        String uptoken = getUpToken();
        PutExtra extra = new PutExtra();
        PutRet ret = IoApi.Put(uptoken, key, inputStream, extra);
        if (ret.ok()) {
            return true;
        } else {
            return false;
        }
    }

    public String getDownloadFileUrl(String filename) throws Exception {
        Mac mac = getMac();
        String baseUrl = URLUtils.makeBaseUrl(domain, filename);
        GetPolicy getPolicy = new GetPolicy();
        String downloadUrl = getPolicy.makeRequest(baseUrl, mac);
        return downloadUrl;
    }

    public void deleteFile(String filename) {
        Mac mac = getMac();
        RSClient client = new RSClient(mac);
        client.delete(domain, filename);
    }

    private String getUpToken() throws AuthException, JSONException {
        Mac mac = getMac();
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        return uptoken;
    }

    private Mac getMac() {
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        return mac;
    }

}