<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col s12">
        <div class="card-panel">
            <form action="aboutManage?action=save" method="post">
                <textarea class="ckeditor" id="content" name="content">${about.content }</textarea>
                <br>
                <button class="btn waves-effect waves-light green" type="submit" name="action">保存</button>
            </form>
        </div>
    </div>
</div>
<script>
    ClassicEditor
        .create(document.querySelector('.ckeditor'))
        .catch(error => {
            console.error(error);
        });
</script>