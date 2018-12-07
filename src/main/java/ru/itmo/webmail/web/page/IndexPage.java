package ru.itmo.webmail.web.page;

import ru.itmo.webmail.model.domain.Article;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class IndexPage extends Page {
    private void action(HttpServletRequest request, Map<String, Object> view) {
        // No operations.
    }

    private void registrationDone(HttpServletRequest request, Map<String, Object> view) {
        view.put("message", "You have been registered");
    }

    private List<ArticleView> findArticles(HttpServletRequest request, Map<String, Object> view) {
        List<Article> articles = getArticleService().findAll();
        List<ArticleView> views = new ArrayList<>();
        for (Article a : articles) {
            if (a.getIsHidden()) {
                continue;
            }
            ArticleView viewA = new ArticleView();
            viewA.setUser(getUserService().find(a.getUserId()).getLogin());
            viewA.setText(a.getText());
            viewA.setTitle(a.getTitle());
            viewA.setTime(a.getCreationTime().toString());
            views.add(viewA);
        }
        return views;
    }

    public class ArticleView {
        String user;
        String text;
        String title;
        String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String userLogin) {
            this.user = userLogin;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
