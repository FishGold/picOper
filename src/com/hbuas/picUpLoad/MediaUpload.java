package com.hbuas.picUpLoad;

import net.sf.json.JSONObject;
import com.hbuas.util.CommonUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bgm on 2015/11/26.
 */
public class MediaUpload {
    public static WeiXinPic uploadMedia(String accessToken,String contentType,InputStream inputStream_File) {
        WeiXinPic weixinPic = null;
        String uploadMediaUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        uploadMediaUrl = uploadMediaUrl.replace("ACCESS_TOKEN", accessToken);
        // 定义数据分隔符
        String boundary = "------------7da2e536604c8";
        try {
            URL uploadUrl = new URL(uploadMediaUrl);
            HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
            uploadConn.setDoOutput(true);
            uploadConn.setDoInput(true);
            uploadConn.setRequestMethod("POST");
            // 设置请求头Content-Type
            uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            // 获取媒体文件上传的输出流（往微信服务器写数据）
            OutputStream outputStream = uploadConn.getOutputStream();
            // 根据内容类型判断文件扩展名
            String fileExt = CommonUtil.getFileExt(contentType);
            // 请求体开始
            outputStream.write(("--" + boundary + "\r\n").getBytes());
            outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
            outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

            BufferedInputStream bis = new BufferedInputStream(inputStream_File);
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1) {
                outputStream.write(buf, 0, size);
            }
            outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
            outputStream.close();
            bis.close();
            InputStream inputStream = uploadConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            uploadConn.disconnect();

            // 使用JSON-lib解析返回结果
            JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
            weixinPic = new WeiXinPic();
            weixinPic.setPicUrl(jsonObject.getString("url"));
        } catch (Exception e) {
            System.out.println("上传媒体文件失败："+ e);
        }
        return weixinPic;
    }
}

