package com.jeonse.dto;

import lombok.Data;

//24.07.07 재성 수정 완료
@Data
public class CommonchecklistDTO {
    private int wishlistNum; // 위시 list num auto increment 적용
    private String memID; // abc@naver.com
    private boolean agentCheck; // 중개인 여부
    private boolean foriengerCheck; // 임대인 외국인 여부
    private boolean familyCheck; // 배우자 여부
    private long loanAmount; //대출 원하는 금액 최대 21억 (due to int)
    private long housePrice; //집 값 20억 이상인 경우 많기에 long으로 수정
    private long jeonseDeposit; //보증금 혹시 몰라 20억 이상일 경우 check
    private int jeonseTerm; //전세 기간
    private int landlordPossessionMonth; //3개월 점유
    private long seniorDebt; //선순위 채권 혹시 몰라 20억 이상일 경우 check
    private int houseID; //foreign key
}