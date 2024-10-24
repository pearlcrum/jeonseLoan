package com.jeonse.service;
import com.jeonse.dto.MemberDTO;
import com.jeonse.dto.MessageDTO;
import com.jeonse.repository.MemberMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    @Override
    public void insertMem(@NotNull MemberDTO member) {
        MemberDTO memberDto = new MemberDTO();

        memberDto.setMemID(member.getMemID());
        memberDto.setPass(member.getPass());
        memberDto.setName(member.getName());
        memberDto.setTel(member.getTel());
        memberDto.setNice(member.getNice());
        memberDto.setKcb(member.getKcb());
        memberDto.setIncomeLastYear(member.getIncomeLastYear());
        memberDto.setIncomeYearBeforeLast(member.getIncomeYearBeforeLast());
        memberDto.setDebt(member.getDebt());
        memberDto.setBirth(member.getBirth());
        memberDto.setNumhouse(member.getNumhouse());



        System.out.println("서비스에서 나와"+member);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //암호화
        memberDto.setPass(passwordEncoder.encode(member.getPass()));

        memberMapper.insertMem(memberDto);

        System.out.println("서비스에서 암호화된 비밀번호야"+memberDto.getPass());
        System.out.println("서비스에서 암호화하구 나와"+memberDto);
    }


    @Override
    public MemberDTO getUserInfo(String memID) {
        MemberDTO user = memberMapper.getUserInfo(memID);
        System.out.println("로그인한 친구 정보야"+user);
        return user;
    }


    @Override
    public int checkId(String memID) {
        int cnt = memberMapper.checkId(memID);
        System.out.println("serviceImpl >> " + cnt);
        return cnt;
    }

    //재성 수정 부분
    @Override
    public MemberDTO getMemberDTO(String memID){
        MemberDTO user = memberMapper.getMemberDTO(memID);
        System.out.println("All info of member"+user);
        return user;
    }
    @Override
    public void updateMemberCredit(HashMap<String,Object> credit){
        memberMapper.updateMemberCredit(credit);
    }
    @Override
    public void updateMemberIncome(HashMap<String,Object> income) {memberMapper.updateMemberIncome(income);}


    @Override
    public int deleteMember(String memID){
        memberMapper.deleteMember(memID);
        return 0;
    }

}
