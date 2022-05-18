package io.github.vino42.service;

import com.meilisearch.sdk.Task;
import io.github.vino42.model.SearchRequestDTO;
import io.github.vino42.model.SearchResultDTO;

import java.util.List;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 21:57
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
public interface MeiliSearchService {

    SearchResultDTO query(SearchRequestDTO searchRequest) throws Exception;

    String rawSearchStr(SearchRequestDTO searchRequest) throws Exception;

    SearchResultDTO rawSearch(SearchRequestDTO searchRequest) throws Exception;

    SearchResultDTO search(SearchRequestDTO query) throws Exception;

    Task addDocuments(String index, String json) throws Exception;

    Task addDocuments(String index, String json, String privateKey) throws Exception;

    Task[] addDocumentsInBatches(String index, String json) throws Exception;

    Task[] addDocumentsInBatches(String index, String json, int batches, String privateKey) throws Exception;

    Task deleteAllDocuments(String index) throws Exception;

    Task deleteDocument(String index, String identifiers) throws Exception;

    Task deleteDocuments(String index, List<String> identifiers) throws Exception;

    String getDocuments(String index) throws Exception;

    String getDocuments(String index, int limit, int offset) throws Exception;

    String getDocuments(String index, int limit) throws Exception;

    String getDocument(String index, String identifier) throws Exception;

    Task updateDocuments(String index, String data) throws Exception;

    Task updateDocuments(String index, String document, String primaryKey) throws Exception;

    Task[] updateDocumentsInBatches(String index, String document, String primaryKey) throws Exception;

    Task[] updateDocumentsInBatches(String index, String document) throws Exception;

    Task[] updateDocumentsInBatches(String index, String document, Integer batchSize, String primaryKey) throws Exception;

    String[] getDisplayedAttributesSettings(String index) throws Exception;

    Task getTask(String index, int taskId) throws Exception;
}
