package constants;

public enum OnlinerUrls {
    HOME("https://www.onliner.by/"),
    CATALOG("https://catalog.onliner.by/"),
    CAR_MARKET("https://ab.onliner.by/"),
    REALTY("https://r.onliner.by/pk/"),
    SERVICE("https://s.onliner.by/tasks"),
    FORUM("https://forum.onliner.by/");
    private String url;

    OnlinerUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
