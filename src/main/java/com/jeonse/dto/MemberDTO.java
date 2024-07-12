package com.jeonse.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;

//24.07.07 재성 수정 완료
@Data

public class MemberDTO {
    private String memID;
    private String name;
    private String pass;
    private String tel;
    private int level; // 관리자 여부
    private int quit; // 탈퇴 여부
    private int nice; // nice 점수
    private int kcb; //kcb 점수
    private long incomeLastYear; //작년소득
    private long incomeYearBeforeLast; //재작년 소득
    private long debt; //총 부채
    private int birth; //나이
    private int numhouse; //총 보유 주택 수
}