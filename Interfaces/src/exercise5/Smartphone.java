package exercise5;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+"); //sablon koji ce sluziti za poredjenje sa zadatim strignom, ovo vraca true ako nadje bilo koju cifru jednom ili vise puta
        urls.forEach(e -> {
            Matcher matcher = pattern.matcher(e);
            if(matcher.find()){
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!",e)).append(System.lineSeparator());
            }
                }
        );
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[^0-9]+"); //sablon koji ce sluziti za poredjenje sa zadatim strignom, ovo vraca true ako nadje bilo koju cifru jednom ili vise puta
        numbers.forEach(e -> {
                    Matcher matcher = pattern.matcher(e);
                    if(matcher.find()){
                        sb.append("Invalid number!").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Calling... %s",e)).append(System.lineSeparator());
                    }
                }
        );
        return sb.toString().trim();
    }
}
