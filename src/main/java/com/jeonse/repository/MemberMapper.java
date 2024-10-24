package com.jeonse.repository;



import com.jeonse.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

//24.07.07 재성 수정 완료
@Mapper
public interface MemberMapper {

    //로그인
    int loginMem(MemberDTO member);

    //회원가입
    void insertMem(MemberDTO member);

    // 아이디에 따른 회원정보
    MemberDTO getUserInfo(String memID);

    //아이디 중복 체크
    public int checkId(String memID);

    MemberDTO getMemberDTO(String memID);

    int updateMemberCredit(HashMap<String,Object> credit);

    int updateMemberIncome(HashMap<String,Object> income);

    int deleteMember(String memID);
}