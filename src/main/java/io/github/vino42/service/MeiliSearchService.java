package io.github.vino42.service;

import io.github.vino42.model.SearchRequestModel;
import io.github.vino42.model.SearchResultModel;

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

    SearchResultModel query(SearchRequestModel searchRequest) throws Exception;

    String rawSearch(SearchRequestModel searchRequest) throws Exception;
}
