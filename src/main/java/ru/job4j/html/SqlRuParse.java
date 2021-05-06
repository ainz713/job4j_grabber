package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc;
        for (int j = 1; j < 6; j++) {
            if (j == 1) {
            doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        } else {
            String c = String.format("https://www.sql.ru/forum/job-offers/%s", j);
            doc = Jsoup.connect(c).get();
        }
        Elements row = doc.select(".postslisttopic");
        Elements dataRow = doc.select("td[style].altCol");
        for (int i = 0; i < row.size(); i++) {
            Element href = row.get(i).child(0);
            Element data = dataRow.get(i);
            System.out.println(href.attr("href"));
            System.out.println(href.text());
            System.out.println(data.text());
        }
    }
    }
}
