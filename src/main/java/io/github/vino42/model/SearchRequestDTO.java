package io.github.vino42.model;

import com.meilisearch.sdk.SearchRequest;

import java.io.Serializable;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 22:04
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
public class SearchRequestDTO implements Serializable {

    private String index;

    private SearchRequest searchRequest;

    private String queryStr;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public String getIndex() {
        return index;
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    @Override
    public String toString() {
        return "SearchRequestDTO{" +
                "index='" + index + '\'' +
                ", searchRequest=" + searchRequest +
                ", queryStr='" + queryStr + '\'' +
                '}';
    }
}
