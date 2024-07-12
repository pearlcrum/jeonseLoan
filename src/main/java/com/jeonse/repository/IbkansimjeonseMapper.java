package com.jeonse.repository;

import com.jeonse.dto.IbkansimjeonseDTO;
import org.apache.ibatis.annotations.Mapper;

//24.07.07 재성 수정 완료
@Mapper
public interface IbkansimjeonseMapper {
    //값 넣는 것
    void insertIbkansimjeonse(IbkansimjeonseDTO ibkansimjeonseDTO);

    IbkansimjeonseDTO getIbkansimjeonseDTO(int wishlistNum);
    int deleteIbkAnsimjeonse(int wishlistNum);

}
