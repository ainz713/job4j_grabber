package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class SqlRuPostParser {

    public static void parsePost(Element href) throws IOException {
        Document doc = Jsoup.connect(href.attr("href")).get();
        Element text = doc.select(".msgBody").get(1);
        System.out.println(text.text());
        Element dataText = doc.select(".msgFooter").get(0);
        System.out.println(dataText.text()
                .substring(0, dataText.text().indexOf("[") - 1));
    }
}
