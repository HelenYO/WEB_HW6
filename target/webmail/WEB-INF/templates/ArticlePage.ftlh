
<#import "common.ftl" as c>

<@c.page>
<div class="article form-box">
    <div class="header">Create an article</div>
    <div class="body">
        <form method="post" action="/article">
            <div class="titlefield">
                <div class="name">
                    <label for="title">Title: </label>
                </div>
                <div class="value">
                    <input id="title" name="title" value="${title!}"/>
                </div>
            </div>
            <textarea name="articleText">${articleText!}</textarea>
            <div class="checkbox-field">
                <div class="name">
                    <label for="checkbox">Hide: </label>
                </div>
                <input type="checkbox" class="checkbox-input" name="isHidden">
            </div>
            <div class="button-field">
                <input type="submit" value="Create">
            </div>
            <div class="error"></div>
            <input type="hidden" name="action" value="submitArticle">
        </form>
    </div>
</div>
<script>
    validationOfArticle(".article form", "submitArticle", "You have created article")
</script>
</@c.page>