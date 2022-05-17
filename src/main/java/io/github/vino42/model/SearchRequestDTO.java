package io.github.vino42.model;

import cn.hutool.json.JSONUtil;
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

    @Override
    public String toString() {
        return "SearchRequestModel{"
                +
                "index='" + index
                + '\''
                +
                ", searchRequest="
                + JSONUtil.toJsonStr(searchRequest)
                +
                '}';
    }
}
