package com.jeonse.dto;

import lombok.Data;

//24.07.07 재성 수정 완료
@Data
public class IbkansimjeonseDTO {
    private int wishlistNum; // PK이자 FK
    private boolean insurance; //권리보험 가입 가능여부
    private boolean nearAgent; // 공인중개사 근처 여부
    private boolean shouldPayInTwoWeeks;//잔금일 2주 이내 여부
    private boolean propertyRestrict;// 소유권 침해 여부
}
