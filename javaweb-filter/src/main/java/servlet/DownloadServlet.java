package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/x-msdownload");
        String file = "3.jpg";
        String path = req.getServletContext().getRealPath("/file/");
        String filePath = path + file;
        FileInputStream fis = new FileInputStream(filePath);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Disposition","attachment; filename=" + file);

        //如果文件名不包含中文可以不设置该项
        //如果包含中文名，则需要设置编码，否则文件名下载后中文字符会乱码
        //getBytes指定了编码的方式，ISO-8859-1指定了解码（读取）的方式,想要转换编码，就是先编码，再解码
        //response.setHeader("Content-Disposition","attachment; filename=" + new String(file.getBytes("gb2312"),"ISO-8859-1"));

        ServletOutputStream out = resp.getOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1){
            out.write(buf,0,len);
        }
        out.close();
        fis.close();
    }
}
