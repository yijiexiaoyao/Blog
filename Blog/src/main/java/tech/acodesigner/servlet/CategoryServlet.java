package tech.acodesigner.servlet;

import tech.acodesigner.dao.ArticleDao;
import tech.acodesigner.dao.CategoryDao;
import tech.acodesigner.dto.ArticleLiteDto;
import tech.acodesigner.dto.CategoryDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            String categoryId = request.getParameter("categoryId");
            ArrayList<CategoryDto> categories = CategoryDao.getCategories();
            HashMap<Integer, ArrayList<ArticleLiteDto>> articlesList = new HashMap<Integer, ArrayList<ArticleLiteDto>>();
            for (CategoryDto category : categories) {
                ArrayList<ArticleLiteDto> articles = ArticleDao.getArticlesByCategoryId(category.getId());
                articlesList.put(category.getId(), articles);
            }
            request.setAttribute("categoryId",categoryId);
            request.setAttribute("categories", categories);
            request.setAttribute("articlesList", articlesList);
            request.setAttribute("mainPage", "category.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
