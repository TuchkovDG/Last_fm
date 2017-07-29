package com.example.last_fm.model.by_country;

import com.google.gson.annotations.SerializedName;

class AttrByCountry {

    @SerializedName("country")
    private String country;
    @SerializedName("page")
    private String page;
    @SerializedName("perPage")
    private String perPage;
    @SerializedName("totalPages")
    private String totalPages;
    @SerializedName("total")
    private String total;

    public AttrByCountry(String country, String page, String perPage, String totalPages, String total) {
        this.country = country;
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
