<%--@elvariable id="music" type="tech.acodesigner.po.MusicPo"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row">
    <div class="col s12">
        <div class="card-panel">
            <form action="musicManage?action=save&musicId" method="post" >

                <h1>添加成功</h1>
                <br><br><br><br>
                <div class="center">
                    <ul>
                        <li><a href="musicManage" >返回</a></li>
                    </ul>

                </div>
            </form>
        </div>
    </div>
</div>
<!--
<script type="text/javascript">
    function notEmpty() {
        var name = document.getElementById("name").value;
        var url = document.getElementById("url").value;
        if (name == null || name == "") {
            Materialize.toast("链接名不能为空", 2000, "rounded");
            return false;
        }
        if (url == null || url == "") {
            Materialize.toast("URL不能为空", 2000, "rounded");
            return false;
        }
        return true;
    }
</script>
<div class="row">
    <div class="col s12">
        <div class="card-panel">
            <form action="musicManage?action=save&musicId=${music.musicId}" method="post"
                  onsubmit="return notEmpty()">
                <div class="input-field col s6">
                    <input id="name" name="name" type="text" class="validate" value="${music.musicName}">
                    <label for="name">链接名</label>
                </div>
                <div class="input-field col s6">
                    <input id="url" name="url" type="text" class="validate" value="${music.url}">
                    <label for="url">URL</label>
                </div>
                <br><br><br><br>
                <div class="center">
                    <button class="btn waves-effect waves-light green" type="submit">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>
-->