package io.github.vino42.service;

import io.github.vino42.model.SearchRequestDTO;
import io.github.vino42.model.SearchResultDTO;

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

    String rawSearch(SearchRequestDTO searchRequest) throws Exception;
}
