package com.jeonse.repository;

import com.jeonse.dto.CommonchecklistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//24.07.07 재성 수정 완료
@Mapper
public interface CommonchecklistMapper {

    // 값 입력
    int insertCommonchecklist(CommonchecklistDTO commonchecklistDto);
    // 값 삭제
    void deleteCommonchecklist(int wishlistNum); // 값 삭제

    int checkCommonchecklistID(String memID); //중복 값 확인

    int getHouseIDFromCommonchecklist(int wishlistNum);

    CommonchecklistDTO getCommonChecklist(int wishlistNum);

    List<Map<String, Object>> getAllCommonChecklist(String memID) throws Exception;

    int getLatestWishlistNumFromCommonchecklist(String memID);
}