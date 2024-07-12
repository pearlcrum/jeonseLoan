package com.jeonse.dto;


import lombok.Data;
//24.07.07 재성 수정 완료
@Data
public class IncomeDTO {
    private String memID;
    private long incomeLastYear; //21억 초과 가능
    private long incomeYearBeforeLast; //21억 초과 가능
    private long debt; //21억 초과 가능
}
