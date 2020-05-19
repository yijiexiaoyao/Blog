<%@ page import="tech.acodesigner.po.MusicPo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--@elvariable id="music" type="com.mysql.jdbc.jdbc2.optional.MysqlDataSource"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    function boFang() {
        var audio= new Audio("music/1.mp3");
        audio.play();
    }
</script>
<div class="row">
    <div class="col s12">
        <div class="card-panel">
            <table class="centered">
                <thead>
                <tr>
                    <th>音乐名称</th>
                    <th>音乐地址</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="music" items="${musics}">
                    <tr class="hoverable">




                        <td>${music.musicName}</td>
                        <td>${music.url}</td>
                        <td>
                            <!--
                            <a href="musicManage?action=preSave&musicId=${music.musicId}"
                               class="waves-effect waves-light btn green hoverable">修改</a>
                       -->
                            <button id="bof" class="waves-effect waves-light btn red hoverable" onclick="boFang()">播放</button>

                            <a class="waves-effect waves-light btn red hoverable"
                               href="musicManage?action=delete&musicId=${music.musicId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>



            <div class="center">
                <form action="musicManage?action=save" method="post" enctype="multipart/form-data">
                    选择一个文件:
                    <input type="file" name="uploadFile" id="file"/>
                    <br/><br/>
                    <input type="submit" value="上传" class="waves-effect waves-light btn green hoverable" />
                </form>

            </div>
        </div>
    </div>
</div>