package com.transvision.retrofit_example.online;

import java.util.List;

public class Response123 {
    private String kind, etag, nextPageToken, regionCode;
    private Pageinfo pageinfo;
    private List<Items> items;

    public Response123() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Pageinfo getPageinfo() {
        return pageinfo;
    }

    public void setPageinfo(Pageinfo pageinfo) {
        this.pageinfo = pageinfo;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
