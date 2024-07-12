package com.jeonse.service;

import com.jeonse.dto.IbkjeonseDTO;
import com.jeonse.repository.IbkjeonseMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IbkjeonseServiceImpl implements IbkjeonseService{

    @Autowired
    IbkjeonseMapper ibkjeonseMapper;

    @Override
    public int insertIbkjeonse(@NotNull IbkjeonseDTO list){
        IbkjeonseDTO ibkjeonseDTO=new IbkjeonseDTO();
        ibkjeonseDTO.setWishlistNum(list.getWishlistNum());
        ibkjeonseDTO.setJeonip(list.isJeonip());
        ibkjeonseDTO.setConfirmDate(list.isConfirmDate());
        ibkjeonseDTO.setInterestRate(list.getInterestRate());
        ibkjeonseDTO.setNowJeonse(list.isNowJeonse());
        ibkjeonseDTO.setCreditManagement(list.isCreditManagement());
        ibkjeonseDTO.setLandLordPermit(list.isLandLordPermit());
        ibkjeonseMapper.insertIbkjeonse(ibkjeonseDTO);
        return 1;
    }
    @Override
    public IbkjeonseDTO getIbkjeonseDTO(int wishlistNum){
        IbkjeonseDTO ibkjeonseDTO=ibkjeonseMapper.getIbkjeonseDTO(wishlistNum);
        return ibkjeonseDTO;
    }
    @Override
    public int deleteIbkjeonse(int wishlistNum){
        ibkjeonseMapper.deleteIbkjeonse(wishlistNum);
        return 0;
    }
}
