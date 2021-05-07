package ru.job4j.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
            Elements row = doc.select(".postslisttopic");
        for (Element element : row) {
            Element href = element.child(0);
            if (!element.text().contains("Важно")) {
                posts.add(detail(href.attr("href")));
            }
        }
        return posts;
    }

    @Override
    public Post detail(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Element msgHeader = doc.select(".messageHeader").get(0);
        Element msgBody = doc.select(".msgBody").get(1);
        Element msgFooter = doc.select(".msgFooter").get(0);
        String name = msgHeader.text().substring(0, msgHeader.text().indexOf("[") - 1);
        String text = msgBody.text();
        LocalDateTime createdDate = new SqlRuDateTimeParser().parse(msgFooter.text()
                .substring(0, msgFooter.text().indexOf("[") - 1));
        return new Post(name, text, link, createdDate);
    }

    public static void main(String[] args) throws IOException {
        SqlRuParse sqlRuParse = new SqlRuParse();
        String url = "https://www.sql.ru/forum/job-offers";
        List<Post> posts = sqlRuParse.list(url);
        for (Post e
                :posts) {
            System.out.println(e.toString());
        }
    }
}
