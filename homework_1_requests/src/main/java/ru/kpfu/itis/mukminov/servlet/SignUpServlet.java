package ru.kpfu.itis.mukminov.servlet;

import com.cloudinary.Cloudinary;
import ru.kpfu.itis.mukminov.service.impl.UserServiceImpl;
import ru.kpfu.itis.mukminov.util.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SignUp", urlPatterns = "/signUp")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class SignUpServlet extends HttpServlet {
    public static final String FILE_PREFIX = "/Users/ilyam/IdeaProjects/Mukminov_400_HW/homework_1_requests/src/main/webapp/img";
    public static final int DIRECTORIES_COUNT = 100;
    public static final Cloudinary cloudinary = CloudinaryUtil.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("signUp.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");

        int resSignUp = UserServiceImpl.signUp(login, password, name, lastname, uploadFile(req, resp));
        if (resSignUp == 0) {
            resp.sendRedirect("/login");
        } else if (resSignUp == 1) {
            req.setAttribute("signUpResult", "Sorry, but this user login already exist");
            req.getRequestDispatcher("signUp.ftl").forward(req, resp);
        } else if (resSignUp == 2) {
            req.setAttribute("signUpResult", "You entered empty login or password");
            req.getRequestDispatcher("signUp.ftl").forward(req, resp);
        }
    }


    private String uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        File file = new File(FILE_PREFIX + "/"
                + filename.hashCode() % DIRECTORIES_COUNT + "/" + filename);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        outputStream.close();

        String filePath = cloudinary.uploader().upload(file, new HashMap<>()).get("url").toString();
        return filePath;
//        return file.getPath().split("webapp")[1];
    }







}
