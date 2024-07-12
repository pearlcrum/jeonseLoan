package com.jeonse.repository;

import com.jeonse.dto.IbkjeonseDTO;
import org.apache.ibatis.annotations.Mapper;
//24.07.07 재성 수정 완료
@Mapper
public interface IbkjeonseMapper {
    void insertIbkjeonse(IbkjeonseDTO ibkjeonseDTO);

    IbkjeonseDTO getIbkjeonseDTO(int wishlistNum);

    int deleteIbkjeonse(int wishlistNum);
}
