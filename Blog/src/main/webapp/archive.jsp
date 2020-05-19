<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    var options = [
        {selector: '#archive', offset: 0, callback: function(el) {
            Materialize.showStaggeredList($(el));
        } },
    ];
    Materialize.scrollFire(options);
</script>
<div class="row">
    <div class="col s10">
        <br>
        <nav class="indigo lighten-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="home" class="breadcrumb">首页</a>
                    <a class="breadcrumb">归档</a>
                </div>
            </div>
        </nav>
        <br>
        <div class="card-panel hoverable">
            <ul id="archive">
                <c:forEach var="article" items="${articles}">
                    <li style="opacity: 0">
                        <table>
                            <td>『${article.pubDate }』</td>
                            <td><a href="article?articleId=${article.id}">${article.title}</a></td>
                        </table>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>