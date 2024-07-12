package com.jeonse.dto;

import lombok.Data;

//24.07.07 재성 수정 완료
@Data
public class HouseinfoDTO {
    private int houseID; // 그냥 구분 값
    private String houseType; // APT 다중주택 등
    private String city; // 시
    private String gu; // 구
    private String dong; // 동
    private String houseName; // 이름 aptName에서 수정
    private long dealAmount; //거래가 21억 넘는 것 가능
    private int buildYear; // 준공일시
    private int dealYear; //매매일시
    private double area; // 평수
    private int floor;  //층
    private double lat; //위도
    private double lng; // 경도
}