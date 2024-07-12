package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.IbkansimjeonseDTO;
import com.jeonse.repository.IbkansimjeonseMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IbkansimjeonseServiceImpl implements IbkansimjeonseService{

    @Autowired
    IbkansimjeonseMapper ibkansimjeonseMapper;
    @Override
    public int insertIbkansimjeonse(@NotNull IbkansimjeonseDTO list){

        //공통 체크리스트에 문제 있을 경우
        // return 0;
        /*
        if(list.isAgentCheck()==false){
            return 0;
        }else if(list.isForiengerCheck()==false){
            return 0;
        }else if(list.isFamilyCheck()==false){
            return 0;
        }else if(list.getJeonseTerm()<3 || list.getJeonseTerm()>24){
            return 0;
        }else if(list.getLandlordPossessionMonth()<1){
            return 0;
        }else {*/
        //공통 체크리스트에 문제 없을 경우
        IbkansimjeonseDTO ibkansimjeonseDTO = new IbkansimjeonseDTO();
        ibkansimjeonseDTO.setWishlistNum(list.getWishlistNum());
        ibkansimjeonseDTO.setInsurance(list.isInsurance());
        ibkansimjeonseDTO.setNearAgent(list.isNearAgent());
        ibkansimjeonseDTO.setShouldPayInTwoWeeks(list.isShouldPayInTwoWeeks());
        ibkansimjeonseDTO.setPropertyRestrict(list.isPropertyRestrict());
        ibkansimjeonseMapper.insertIbkansimjeonse(ibkansimjeonseDTO);
        return 1;

    }
    @Override
    public IbkansimjeonseDTO getIbkansimjeonseDTO(int wishlistNum){
        IbkansimjeonseDTO ibkansimjeonseDTO=ibkansimjeonseMapper.getIbkansimjeonseDTO(wishlistNum);
        return ibkansimjeonseDTO;
    }
    @Override
    public int deleteIbkAnsimjeonse(int wishlistNum){
        ibkansimjeonseMapper.deleteIbkAnsimjeonse(wishlistNum);
        return 0;
    }
}
