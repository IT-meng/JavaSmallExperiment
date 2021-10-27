package exp103;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetURL {
    public static void main(String[] args) {
        final String input = "<html><body><a href=\"http://www.baidu.com\">百度</a>，" +
                "<a href='www.webmeteor.cn/course/java' target='_blank'>网易</a>，" +
                "<a href='/news/13432.html' target=\"_blank\">内部地址</a></body></html>";
        String regex = "(http|www|\\/){1}\\S+\\.[^'\"]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group(0));

        }
    }
}