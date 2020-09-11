package com.christ.ffms.entity;

import org.springframework.stereotype.Component;


@Component
@lombok.Data
public class Search {
    private String start;
    private String end;
    private String year;

    public Search() {

    }

    public Search(String start, String end, String year) {
        this.start = start;
        this.end = end;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Search{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
