package io.github.vino42.service;

import cn.hutool.core.util.StrUtil;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.model.SearchResult;
import io.github.vino42.model.SearchRequestDTO;
import io.github.vino42.model.SearchResultDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 21:57
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription : 默认的melisearch 服务类实现
 * =====================================================================================
 */

public class DefaultMeiliSearchService implements MeiliSearchService {
    @Autowired
    private Client client;

    @Override
    public SearchResultDTO query(SearchRequestDTO searchRequestModel) throws Exception {
        String index = searchRequestModel.getIndex();
        if (StrUtil.isBlankOrUndefined(index)) {
            throw new RuntimeException("index illegal");
        }
        SearchRequest searchRequest = searchRequestModel.getSearchRequest();
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        SearchResult search = client.index(index).search(searchRequest);
        searchResultDTO.setIndex(index);
        searchResultDTO.setSearchResult(search);
        return searchResultDTO;
    }

    @Override
    public String rawSearch(SearchRequestDTO searchRequestDTO) throws Exception {
        String index = searchRequestDTO.getIndex();
        if (StrUtil.isBlankOrUndefined(index)) {
            throw new RuntimeException("index illegal");
        }
        SearchRequest searchRequest = searchRequestDTO.getSearchRequest();
        String searchResult = client.index(index).rawSearch(searchRequest);
        return searchResult;
    }
}
