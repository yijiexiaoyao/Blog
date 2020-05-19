<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col s10">
        <br>
        <nav class="indigo lighten-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="home" class="breadcrumb">首页</a>
                    <a class="breadcrumb">分类</a>
                </div>
            </div>
        </nav>
        <br>
        <ul class="collapsible popout">
            <c:forEach var="category" items="${categories}">
                <li>
                    <div class="collapsible-header <c:if test='${categoryId==category.id}'>active</c:if> ">${category.name}<span class="badge">${category.count}</span></div>
                    <div class="collapsible-body">
                        <table>
                            <tbody>
                            <c:forEach var="article" items="${articlesList[category.id]}">
                                <tr>
                                    <td>『${article.pubDate }』</td>
                                    <td><a href="article?articleId=${article.id}">${article.title}</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
