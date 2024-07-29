package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.dto.MemberDTO;
import com.jeonse.repository.CommonchecklistMapper;
import com.jeonse.repository.HouseinfoMapper;
import com.jeonse.repository.MemberMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonchecklistServiceImpl implements CommonchecklistService{

    @Autowired
    CommonchecklistMapper commonchecklistMapper;
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    HouseinfoMapper houseMapper;
    @Override
    public int insertCommonchecklist(@NotNull CommonchecklistDTO list){

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
        //wishlistNum은 Autoincrement니 뺀다.
        CommonchecklistDTO commonchecklistDto = new CommonchecklistDTO();
        commonchecklistDto.setMemID(list.getMemID());
        commonchecklistDto.setAgentCheck(list.isAgentCheck());
        commonchecklistDto.setForiengerCheck(list.isForiengerCheck());
        commonchecklistDto.setFamilyCheck(list.isFamilyCheck());
        commonchecklistDto.setLoanAmount(list.getLoanAmount());
        commonchecklistDto.setHousePrice(list.getHousePrice());
        commonchecklistDto.setJeonseDeposit(list.getJeonseDeposit());
        commonchecklistDto.setJeonseTerm(list.getJeonseTerm());
        commonchecklistDto.setLandlordPossessionMonth(list.getLandlordPossessionMonth());
        commonchecklistDto.setSeniorDebt(list.getSeniorDebt());
        commonchecklistDto.setHouseID(list.getHouseID());
        commonchecklistMapper.insertCommonchecklist(commonchecklistDto);
        return 1;

    }
    @Override
    public void deleteCommonchecklist(String memID, int wishlistNum){ //체크리스트 지우기
        if(commonchecklistMapper.checkCommonchecklistID(memID)!=0) {
            commonchecklistMapper.deleteCommonchecklist(wishlistNum);
        }
    }
    @Override
    public int checkCommonchecklistID(String memID){ // 값 몇개 있는 지 체크
        int cnt = commonchecklistMapper.checkCommonchecklistID(memID);
        System.out.println("serviceImpl >> " + cnt);
        return cnt;
    }
    @Override
    public MemberDTO getMember(String memID){
        MemberDTO user = memberMapper.getMemberDTO(memID);
        System.out.println("로그인한 친구 정보야"+user);
        return user;
    }
    @Override
    public CommonchecklistDTO getCommonChecklist(int wishlistNum){
        CommonchecklistDTO commonchecklistDTO=commonchecklistMapper.getCommonChecklist(wishlistNum);
        return commonchecklistDTO;
    }

    @Override
    public String getAddress(int wishlistID){
        int houseID=commonchecklistMapper.getHouseIDFromCommonchecklist(wishlistID);
        HouseinfoDTO houseinfoDTO=houseMapper.getHouseInfo(houseID);
        String address="";
        address=houseinfoDTO.getCity()+" "+houseinfoDTO.getGu()+" "+houseinfoDTO.getDong()+" "+houseinfoDTO.getHouseName();
        return address;
    }
    //for push
    @Override
    public int getHouseID(int wishlistID){
        return commonchecklistMapper.getHouseIDFromCommonchecklist(wishlistID);
    }

    @Override
    public List<Map<String, Object>> getAllCommonChecklist(String memID) throws Exception{
        return commonchecklistMapper.getAllCommonChecklist(memID);
    }

    @Override
    public int getHouseIDFromCommonchecklist(int wishlistNum){
        return commonchecklistMapper.getHouseIDFromCommonchecklist(wishlistNum);
    }

    @Override
    public int getLatestWishlistNumFromCommonchecklist(String memID){
        return commonchecklistMapper.getLatestWishlistNumFromCommonchecklist(memID);
    }
}