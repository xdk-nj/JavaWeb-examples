package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名称
        Part part = req.getPart("img");
        String header = part.getHeader("content-disposition");
        String filename = header.substring(header.indexOf("filename=") + 10, header.length() - 1);
        System.out.println(filename);

        //获取路径  E:\IDEAWorkSpace\javaweb-filter\target\javaweb-filter-1.0-SNAPSHOT\file
        String dirPath = req.getServletContext().getRealPath("/file");
        System.out.println(dirPath);

        //创建文件夹
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        //为文件重新设置文件名
        String finalName = UUID.randomUUID().toString() + filename;
        //创建文件
        File file = new File(dirFile, finalName);
        //流操作
        InputStream inputStream = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(file);
        int len = 0;
        byte[] temp = new byte[1024];
        while ((len = inputStream.read(temp)) != -1) {
            fos.write(temp, 0, len);
        }
        fos.close();
        inputStream.close();
        req.getRequestDispatcher("/file/" + finalName).forward(req, resp);
    }
}
