package com.zhou.ssm.utils;

/**
 * Created by Administrator on 2017/4/18.
 */
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static sun.security.pkcs11.wrapper.Functions.toHexString;

public class Files_Helper {
    /**
     * 文件上传，返回相对地址
     */
    public static String FilesUpload_stream(HttpServletRequest request,MultipartFile multipartFile,String filename,String filePath) {
        if (multipartFile != null) {
            //去掉filename空格
            //filename= filename.replaceAll(" ", "");
            //get files suffix
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            //filePath+fileName the complex file Name
            String absolutePath = getAndSetAbsolutePath(request, filePath,filename, suffix);
            //return relative Path
            String relativePath = getRelativePath(filePath,filename, suffix);
            try{
                InputStream inputStream = multipartFile.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                byte buffer[] = new byte[4096]; //create a buffer
                long fileSize = multipartFile.getSize();
                if(fileSize<=buffer.length){//if fileSize < buffer
                    buffer = new byte[(int)fileSize];
                }
                int line =0;
                while((line = inputStream.read(buffer)) >0 )
                {
                    fileOutputStream.write(buffer,0,line);
                }
                fileOutputStream.close();
                inputStream.close();
                return relativePath;
            }catch (Exception e){
                e.printStackTrace();
            }
         } else
            return null;
         return null;
     }

    /**
     * 文件下载
     */
      public static void FilesDownload_stream(HttpServletRequest request, HttpServletResponse response, String filePath) {
          //get server path (real path)
          String realPath = request.getSession().getServletContext().getRealPath(filePath);
          File file = new File(realPath);
          String filenames = file.getName();
          InputStream inputStream;
          try {
             inputStream = new BufferedInputStream(new FileInputStream(file));
             byte[] buffer = new byte[inputStream.available()];
             inputStream.read(buffer);
             inputStream.close();
             response.reset();
             // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
             response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
             response.addHeader("Content-Length", "" + file.length());
             OutputStream os = new BufferedOutputStream(response.getOutputStream());
             response.setContentType("application/octet-stream");
             os.write(buffer);// 输出文件
             os.flush();
             os.close();
            } catch (Exception e) {
             e.printStackTrace();
              }
          }


    //return server absolute path（real path）
    public static String getServerPath(HttpServletRequest request, String filePath) {
        return request.getSession().getServletContext().getRealPath(filePath);
    }

    //return a dir that named date of today ; example:20160912
    public static String getDataPath() {
              return new SimpleDateFormat("yyyyMMdd").format(new Date());
     }

        //check if the path has exist if not create it
        public static void checkDir(String savePath) {
        File dir = new File(savePath);
        if (!dir.exists() || !dir.isDirectory()) {
             dir.mkdir();
          }
        }

       //return server absolute path（real path） the style is  “server absolute path/UUIDName”filePath example "/upload"
       public static String getAndSetAbsolutePath(HttpServletRequest request,String filePath,String filename,  String suffix) {
            String savePath = getServerPath(request, filePath) + "/" + getDataPath() + "/";//example:F:/upload/20160912/
            checkDir(savePath);//check if the path has exist if not create it
            return savePath + filename+ suffix;
       }

       //get the relative path of files style is “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
      public static String getRelativePath(String filePath, String filename,String suffix) {
        return filePath + "/" + getDataPath()  + "/" + filename + suffix;//example:/Upload/20160912/
       }

}
