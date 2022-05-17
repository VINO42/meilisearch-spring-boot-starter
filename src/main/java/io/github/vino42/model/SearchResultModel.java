package io.github.vino42.model;

import cn.hutool.json.JSONUtil;
import com.meilisearch.sdk.model.SearchResult;

import java.io.Serializable;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 22:06
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
public class SearchResultModel implements Serializable {

    private String index;

    private SearchResult searchResult;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String toString() {
        return "SearchResultModel{" +
                "index='" + index + '\'' +
                ", searchResult=" + JSONUtil.toJsonStr(searchResult) +
                '}';
    }
}
