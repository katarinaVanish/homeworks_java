package org.knit.lab1;

public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtension;
    private String intParam;
    private String doubleParam;
    private String textParameter;

    public SimpleUrl(String url) {
        newSimpleUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebpageExtension() {
        return webPageExtension;
    }

    public void setWebPageExtension(String webpageExtension) {
        this.webPageExtension = webpageExtension;
    }

    public String getIntParam() {
        return intParam;
    }

    public void setIntParam(String intParam) {
        this.intParam = intParam;
    }

    public String getDoubleParam() {
        return doubleParam;
    }

    public void setDoubleParam(String doubleParam) {
        this.doubleParam = doubleParam;
    }

    public String getTextParameter() {
        return textParameter;
    }

    public void setTextParameter(String textParameter) {
        this.textParameter = textParameter;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtension = " + webPageExtension + "\n" +
                "intParam = " + intParam + "\n" +
                "doubleParam = " + doubleParam + "\n" +
                "textParameter = " + textParameter;
    }

    public void newSimpleUrl(String url) {
        String[] protocolplus = url.split("://");
        String protocol = protocolplus[0];

        String[] adressplus = protocolplus[1].split("/", 2);
        String address = adressplus[0];
        String other = adressplus[1];

        String[] addressParts = address.split("\\.");
        String siteName = addressParts[0];
        String domainZone = addressParts[1];

        String[] pathplus = other.split("\\?", 2);
        String path = pathplus[0];
        String[] pathParts = path.split("/");

        String webpageFullName = pathParts[pathParts.length - 1];
        String[] webpageplus = webpageFullName.split("\\.");
        String webpageName = webpageplus[0];
        String webPageExtension = webpageplus[1];

        String query = pathplus[1];
        String[] params = query.split("&");

        String intParam = params[0].split("=")[1];
        String doubleParam = params[1].split("=")[1];
        String textParameter = params[2].split("=")[1];


        setProtocol(protocol);
        setAddress(address);
        setSiteName(siteName);
        setDomainZone(domainZone);
        setWebpageName(webpageName);
        setWebPageExtension(webPageExtension);
        setIntParam(intParam);
        setDoubleParam(doubleParam);
        setTextParameter(textParameter);



    }
}
