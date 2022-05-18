package io.github.vino42.service;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.Task;
import com.meilisearch.sdk.model.SearchResult;
import io.github.vino42.model.SearchRequestDTO;
import io.github.vino42.model.SearchResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMeiliSearchService.class);

    @Autowired
    private Client client;

    @Override
    public SearchResultDTO query(SearchRequestDTO searchRequestModel) throws Exception {
        String index = searchRequestModel.getIndex();
        if (StringUtils.isEmpty(index.trim())) {
            throw new RuntimeException("index illegal");
        }
        SearchRequest searchRequest = searchRequestModel.getSearchRequest();
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        SearchResult search = client.index(index).search(searchRequest);
        searchResultDTO.setIndex(index);
        searchResultDTO.setSearchResult(search);
        LOGGER.debug("[rawSearchStr#query:{},searchResult:{} ]", searchRequestModel, searchResultDTO);
        return searchResultDTO;
    }

    @Override
    public String rawSearchStr(SearchRequestDTO searchRequestDTO) throws Exception {
        String index = searchRequestDTO.getIndex();
        if (StringUtils.isEmpty(index.trim())) {
            throw new RuntimeException("index illegal");
        }
        SearchRequest searchRequest = searchRequestDTO.getSearchRequest();
        String searchResult = client.index(index).rawSearch(searchRequest);
        LOGGER.debug("[rawSearchStr#query:{},searchResult:{} ]", searchRequestDTO, searchResult);
        return searchResult;
    }

    @Override
    public SearchResultDTO rawSearch(SearchRequestDTO searchRequestDTO) throws Exception {
        String index = searchRequestDTO.getIndex();
        if (StringUtils.isEmpty(index.trim())) {
            throw new RuntimeException("index illegal");
        }
        SearchRequest searchRequest = searchRequestDTO.getSearchRequest();
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        String search = client.index(index).rawSearch(searchRequest);
        searchResultDTO.setIndex(index);
        searchResultDTO.setRawSearchStrResult(search);
        LOGGER.debug("[search#query:{},searchResultDTO:{} ]", searchRequestDTO, searchResultDTO);
        return searchResultDTO;
    }

    @Override
    public SearchResultDTO search(SearchRequestDTO query) throws Exception {
        if (StringUtils.isEmpty(query.getIndex().trim())) {
            throw new RuntimeException("index illegal");
        }
        String searchRequest = query.getQueryStr();
        SearchResultDTO searchResultDTO = new SearchResultDTO();
        SearchResult search = client.index(query.getIndex()).search(searchRequest);
        searchResultDTO.setIndex(query.getIndex());
        searchResultDTO.setSearchResult(search);
        LOGGER.debug("[search#query:{},searchResultDTO:{} ]", query, searchResultDTO);
        return searchResultDTO;
    }

    @Override
    public Task addDocuments(String index, String json) throws Exception {
        LOGGER.debug("[addDocuments#index:{},json:{}]", index, json);
        Task task = addDocuments(index, json, null);
        LOGGER.debug("[addDocuments#task:{} ]", task);
        return task;

    }

    @Override
    public Task addDocuments(String index, String json, String privateKey) throws Exception {
        LOGGER.debug("[addDocuments#index:{},json:{},privateKey:{}]", index, json, privateKey);

        if (StringUtils.isEmpty(index.trim())) {
            throw new RuntimeException("index illegal");
        }
        if (StringUtils.isEmpty(json.trim())) {
            throw new RuntimeException("json data illegal");
        }
        Task task = client.index(index).addDocuments(json, privateKey);
        LOGGER.debug("[addDocuments#tasks:{} ]", task);
        return task;
    }

    @Override
    public Task[] addDocumentsInBatches(String index, String json) throws Exception {
        LOGGER.debug("[addDocumentsInBatches#index:{},json:{}]", index, json);

        Task[] tasks = addDocumentsInBatches(index, json, 1000, null);
        LOGGER.debug("[addDocumentsInBatches#tasks:{} ]", tasks);
        return tasks;
    }

    @Override
    public Task[] addDocumentsInBatches(String index, String json, int batches, String privateKey) throws Exception {
        LOGGER.debug("[addDocumentsInBatches#index:{},json:{},batches:{},privateKey:{}]", index, json, batches, privateKey);

        if (StringUtils.isEmpty(index.trim())) {
            throw new RuntimeException("index illegal");
        }
        if (StringUtils.isEmpty(json.trim())) {
            throw new RuntimeException("json data illegal");
        }
        Task[] tasks = client.index(index).addDocumentsInBatches(json, batches, privateKey);
        LOGGER.debug("[addDocumentsInBatches#tasks:{} ]", tasks);
        return tasks;
    }

    @Override
    public Task deleteAllDocuments(String index) throws Exception {
        LOGGER.debug("[deleteAllDocuments#index:{}]", index);
        Task task = client.index(index).deleteAllDocuments();
        LOGGER.debug("[deleteAllDocuments#task:{} ]", task);
        return task;
    }

    @Override
    public Task deleteDocument(String index, String identifiers) throws Exception {
        LOGGER.debug("[deleteAllDocument#index:{}]", index);
        Task task = deleteDocuments(index, Collections.singletonList(identifiers));
        LOGGER.debug("[deleteAllDocuments#task:{} ]", task);
        return task;
    }

    @Override
    public Task deleteDocuments(String index, List<String> identifiers) throws Exception {
        LOGGER.debug("[deleteAllDocuments#index:{}]", index);
        Task task = client.index(index).deleteDocuments(identifiers);
        LOGGER.debug("[deleteAllDocuments#task:{} ]", task);
        return task;
    }

    @Override
    public String getDocuments(String index) throws Exception {
        LOGGER.debug("[getDocuments#index:{}]", index);
        String documents = client.index(index).getDocuments();
        LOGGER.debug("[getDocuments#documents:{} ]", documents);
        return documents;
    }

    @Override
    public String getDocuments(String index, int limit, int offset) throws Exception {
        LOGGER.debug("[getDocuments#index:{}]", index);
        String documents = client.index(index).getDocuments(limit, offset);
        LOGGER.debug("[getDocuments#documents:{} ]", documents);
        return documents;
    }

    @Override
    public String getDocuments(String index, int limit) throws Exception {
        LOGGER.debug("[getDocuments#index:{}]", index);
        String documents = client.index(index).getDocuments(limit);
        LOGGER.debug("[getDocuments#documents:{} ]", documents);
        return documents;
    }

    @Override
    public String getDocument(String index, String identifier) throws Exception {
        LOGGER.debug("[getDocuments#index:{}]", index);
        String documents = client.index(index).getDocument(identifier);
        LOGGER.debug("[getDocuments#task:{} ]", documents);
        return documents;
    }

    @Override
    public Task updateDocuments(String index, String data) throws Exception {
        LOGGER.debug("[updateDocuments#index:{}]", index);
        Task task = client.index(index).updateDocuments(data, null);
        LOGGER.debug("[updateDocuments#task:{} ]", task);
        return task;
    }

    @Override
    public Task updateDocuments(String index, String document, String primaryKey) throws Exception {
        LOGGER.debug("[updateDocuments#index:{},primaryKey:{}]", index, primaryKey);
        Task task = client.index(index).updateDocuments(document, primaryKey);
        LOGGER.debug("[updateDocuments#task:{} ]", task);
        return task;
    }

    @Override
    public Task[] updateDocumentsInBatches(String index, String document, String primaryKey) throws Exception {
        LOGGER.debug("[updateDocumentsInBatches#index:{},primaryKey:{}]", index, primaryKey);
        Task[] task = updateDocumentsInBatches(index, document, 1000, primaryKey);
        return task;
    }

    @Override
    public Task[] updateDocumentsInBatches(String index, String document) throws Exception {
        LOGGER.debug("[updateDocumentsInBatches#index:{},doc:{}]", index, document);
        Task[] task = updateDocumentsInBatches(index, document, 1000, null);
        return task;
    }

    @Override
    public Task[] updateDocumentsInBatches(String index, String document, Integer batchSize, String primaryKey) throws Exception {
        LOGGER.debug("[updateDocumentsInBatches#index:{},doc:{}]", index, document);
        Task[] task = client.index(index).updateDocumentsInBatches(document, batchSize, primaryKey);
        LOGGER.debug("[updateDocumentsInBatches#tasks:{} ]", task);
        return task;
    }

    @Override
    public String[] getDisplayedAttributesSettings(String index) throws Exception {
        LOGGER.debug("[getDisplayedAttributesSettings#index:{}]", index);
        String[] settings = client.index(index).getDisplayedAttributesSettings();
        LOGGER.debug("[getDisplayedAttributesSettings#settings:{} ]", settings);
        return settings;
    }

    @Override
    public Task getTask(String index, int taskId) throws Exception {
        LOGGER.debug("[getTask#index:{},taskId:{}]", index, taskId);
        Task task = client.index(index).getTask(taskId);
        LOGGER.debug("[getTask#task:{} ]", task);
        return task;
    }
}
