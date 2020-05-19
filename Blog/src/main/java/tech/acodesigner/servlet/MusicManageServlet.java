package tech.acodesigner.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.plugin.dom.core.Document;
import tech.acodesigner.dao.MusicDao;
import tech.acodesigner.po.MusicPo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@WebServlet(name = "MusicManageServlet", urlPatterns = "/musicManage")
public class MusicManageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //先判断上传的数据是否多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项是普通类型还是上传的文件
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("表单项的value属性值："+fileItem.getString("UTF-8"));
                    }
                    else {
                        //上传的文件
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名" + fileItem.getName());
                        // req.getServletContext().getRealPath("upload");
                        //设置找到路径
                        String path = "D:\\Blog\\src\\main\\webapp\\music\\";
                        System.out.println("保存文件的路径" + path);
                        //创建文件夹
                        File dir = new File(path);
                        if (!dir.exists()){
                            dir.mkdirs();
                            System.out.println("文件夹创建了");
                        }
                        else {
                            System.out.println("文件夹已存在");
                        }
                        //设置保存名字
                        //  String suffix = fileItem.getName().split("\\.")[1];
                        //  String fileName = UUID.randomUUID().toString() + "." + suffix;
                        String fileName = fileItem.getName();
                        System.out.println("保存的文件名" + fileName);
                        //保存路径
                        String fileSavePath = path + "\\" + fileName;
                        System.out.println("文件保存的路径" + fileSavePath);


                        //保存文件到项目里
                        //fileItem.write(new File("D:\\lianxi\\music\\web\\music\\" + fileItem.getName()));

                        fileItem.write(new File(fileSavePath));

                        request.setAttribute("musicName", fileName);
                        request.setAttribute("url", fileSavePath);
                        request.setAttribute("mainPage", "musicSaveManage.jsp");
                        request.getRequestDispatcher("manage.jsp").forward(request, response);
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        try {
            String action = request.getParameter("action");
            if (action == null || action.equals("")) {
                ArrayList<MusicPo> musics = MusicDao.getAllMusics();
                request.setAttribute("musics", musics);
                request.setAttribute("mainPage", "musicManage.jsp");
                request.getRequestDispatcher("manage.jsp").forward(request, response);
            }


      //    else if (action.equals("preSave")) {
      //        String id = request.getParameter("musicId");
      //        if (id != null && !id.equals("")) {
      //            MusicPo music = MusicDao.getMusic(Integer.parseInt(id));
      //            request.setAttribute("music", music);
      //        }
      //        request.setAttribute("mainPage", "musicSaveManage.jsp");
      //        request.getRequestDispatcher("manage.jsp").forward(request, response);
      //    }
//
            else if (action.equals("delete")) {
                String id = request.getParameter("musicId");
                MusicDao.deleteMusic(Integer.parseInt(id));
                request.getRequestDispatcher("musicManage?action").forward(request, response);
            } else if (action.equals("save")) {
                String id = request.getParameter("musicId");
                String name = request.getParameter("musicName");
                String url = request.getParameter("url");
                MusicPo music = new MusicPo();
                music.setMusicName(name);
                music.setUrl(url);
                if (id != null && !id.equals("")) {
                    music.setMusicId(Integer.parseInt(id));
                    MusicDao.updateMusic(music);
                } else {
                    MusicDao.saveMusic(music);
                }
                request.getRequestDispatcher("musicManage?action").forward(request, response);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
