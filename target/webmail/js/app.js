window.setMessage = function(message) {
    localStorage.setItem("message", message);
};

window.getMessage = function() {
    return localStorage.getItem("message");
};

window.removeMessage = function() {
    return localStorage.removeItem("message");
};

window.cloneTemplate = function ($template) {
    return $($template.prop('content')).clone();
};


function validationOfArticle(form, action, message) {
    $(function() {
        $(form).submit(function () {
            var title = $(this).find("input[name='title']").val();
            var articleText = $(this).find("textarea[name='articleText']").val();
            var isHidden = $(this).find("input[name='isHidden']").prop("checked");
            var $error = $(this).find(".error").text("");
            $.post("", {action: action, title: title, articleText: articleText, isHidden: isHidden}, function (response) {
                if (response["success"]) {
                    setMessage(message);
                    document.location.href = "/";
                } else {
                    $error.text(response["error"]);
                }
            });
            return false;
        });
    })
}