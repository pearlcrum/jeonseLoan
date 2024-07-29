package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//24.07.07 재성 수정 완료
@Service
public interface CommonchecklistService {
    // 값 입력
    int insertCommonchecklist(CommonchecklistDTO commonchecklistDto);
    // 값 삭제
    void deleteCommonchecklist(String memID, int wishlistNum);
    //기존에 있는지 체크
    int checkCommonchecklistID(String memID);

    MemberDTO getMember(String memID); //member에서 nice, kcb , 소득, 부채, birth, numhouse 가져오기 위함

    String getAddress(int wishlistID);

    int getHouseID(int wishlistID);

    //특정 commonchecklist 반환
    CommonchecklistDTO getCommonChecklist(int wishlistNum);

    List<Map<String, Object>> getAllCommonChecklist(String memID) throws Exception;
    int getHouseIDFromCommonchecklist(int wishlistNum);

    int getLatestWishlistNumFromCommonchecklist(String memID);
}