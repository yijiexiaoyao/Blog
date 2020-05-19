
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
<div class="card-panel hoverable">

    <div class="center-align" style="margin-bottom: 40px">
        <h4><a href="home" class="brand-logo indigo-text darken-3">My Blog</a></h4>
    </div>

    <form id="loginForm" method="post" action="login?action=register" onsubmit="return check()">
        <div class="input-field">
            <i class="material-icons prefix">account_circle</i>
            <input id="username" name="username" type="text" class="validate">
            <label for="username">用户名</label>
        </div>
        <div class="input-field">
            <i class="material-icons prefix">lock</i>
            <input id="password" name="password" type="password" class="validate">
            <label for="password">密码</label>
        </div>
        <div class="input-field">
            <i class="material-icons prefix">lock_outline</i>
            <input id="confirmPassword" name="confirmPassword" type="password" class="validate">
            <label for="password">确认密码</label>
        </div>
        <div class="input-field col s6">
            <i class="material-icons prefix">portrait</i>
            <select id="picture" name="picture" class="icons">
                <option value="" disabled selected>头像</option>
                <c:forEach var="picture" items="${pictures}">
                    <option value="${picture}" data-icon="images/user/${picture}" class="circle" }>${picture}</option>
                </c:forEach>
            </select>
        </div>
        <br><br><br><br>
        <div class="center-align">
            <button class="btn waves-effect waves-light hoverable orange" type="submit" name="action">注册
                <i class="material-icons right">send</i>
            </button>
        </div>
    </form>
</div>