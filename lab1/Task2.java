package org.knit.lab1;


public class Task2 {
    public void execute() {

        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        SimpleUrl url = new SimpleUrl(urlValue);

        String address = "test.ru";
        String protocol = "https";
        url.setAddress(address);
        url.setProtocol(protocol);
        System.out.println(url);


    }
}
