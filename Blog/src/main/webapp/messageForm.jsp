
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function notEmpty() {
        var comment = document.getElementById("comment").value;
        if (comment == null || comment == "") {
            Materialize.toast("评论不能为空", 2000, "rounded");
            return false;
        }
        return true;
    }
</script>
<div class="row">
    <div class="col s10">
        <div class="card-panel hoverable">
            <c:choose>
                <c:when test="${curUser==null }">
                    <div class="center"><p>登陆后可评论</p></div>
                </c:when>
                <c:otherwise>
                    <form action="message?action=save&type=${type}&pid=${pid}&articleId=${articleId}" method="post" onsubmit="return notEmpty()">
                        <div class="input-field col s12">
                            <textarea id="comment" name="comment" class="materialize-textarea"></textarea>
                            <label for="comment">评论</label>
                        </div>
                        <div class="center">
                            <button class="btn waves-effect waves-light green hoverable" type="submit" name="action">发布评论</button>
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>