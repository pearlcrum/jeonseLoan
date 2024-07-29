package com.jeonse.controller;

import com.jeonse.dto.*;
import com.jeonse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class profileController {
    @Autowired
    private CommonchecklistService commonchecklistService;

    @Autowired
    private IbkansimjeonseService ibkansimjeonseService;

    @Autowired
    private IbkjeonseService ibkjeonseService;

    @Autowired
    private MemberService memberService;

    @Autowired
    HouseinfoService houseinfoService;
    private String memberID;

    @GetMapping("/profile")
    public String profile(@SessionAttribute(name = "memID", required = false) String memID, Model model) throws Exception{

        int wishlistID=commonchecklistService.getLatestWishlistNumFromCommonchecklist(memID);
        int cnt=0;
        if(commonchecklistService.checkCommonchecklistID(memID)>=1) {
            List<Map<String, Object>> resultList = commonchecklistService.getAllCommonChecklist(memID);
            Map<String, Object> allCommonChecklist = new LinkedHashMap<>();
            for (int i = 0; i < resultList.size(); i++) {
                int houseId=(int)resultList.get(i).get("houseID");
                HouseinfoDTO house=houseinfoService.getHouseinfo(houseId);
                String wishlistnum=resultList.get(i).get("wishlistNum").toString();
                String address=house.getCity()+" "+house.getGu()+" "+house.getDong()+" "+house.getHouseName();
                allCommonChecklist.put(wishlistnum,address);
            }
            model.addAttribute("allCommonChecklist", allCommonChecklist);

            MemberDTO memberDTO = memberService.getMemberDTO(memID);

            memberID = memID;

            int nice = memberDTO.getNice();
            int kcb = memberDTO.getKcb();
            long incomeLastYear = memberDTO.getIncomeLastYear();
            long incomeYearBeforeLast = memberDTO.getIncomeYearBeforeLast();
            long debt = memberDTO.getDebt();

            double customerPays; //소득대비 금융위험부담률
            //고객이 연간 부담하는 대출이자(본건 대출 포함) / 고객의 연소득 * 100
            // 본건 대출 제외 대출에 적용하는 이자 한은 가중평균 가계대출금리 5.24 + 1


            model.addAttribute("nice", nice);
            model.addAttribute("kcb", kcb);
            model.addAttribute("incomeYearBeforeLast", incomeYearBeforeLast);
            model.addAttribute("incomeLastYear", incomeLastYear);
            model.addAttribute("debt", debt);
        }
        return "/profile";
    }


    @GetMapping("/deleteMember")
    public String deleteMember(){
    //public String deleteMember(HttpServletRequest httpServletRequest){
        System.out.println("is it working ????");
        //httpServletRequest.getSession().invalidate(); //세션 파기

        //ibkansimjeonseService.deleteIbkAnsimjeonse(memberID);
        //ibkjeonseService.deleteIbkjeonse(memberID);
        //commonchecklistService.deleteCommonchecklist(memberID);
        memberService.deleteMember(memberID);//현재 값 잘 들어가 있음.
        return "redirect:loginForm";
    }

    @PostMapping("/updateMemberCredit")
    public String updateMemberCredit(CreditDTO creditDTO) {
        HashMap<String,Object> credit=new HashMap<String,Object>();
        credit.put("memID",memberID);
        credit.put("nice",creditDTO.getNice());
        credit.put("kcb",creditDTO.getKcb());
        System.out.println("nice점수는" + creditDTO.getNice());
        System.out.println("kcb점수는"+creditDTO.getKcb());
        memberService.updateMemberCredit(credit);
        return "redirect:profile";
    }
    @PostMapping("updateMemberIncome")
    public String updateMemberIncome(IncomeDTO incomeDTO){
        HashMap<String, Object> income=new HashMap<String, Object>();
        income.put("memID",memberID);
        income.put("incomeLastYear",incomeDTO.getIncomeLastYear());
        income.put("incomeYearBeforeLast",incomeDTO.getIncomeYearBeforeLast());
        income.put("debt",incomeDTO.getDebt());
        System.out.println("작년 소득은" + incomeDTO.getIncomeLastYear());
        System.out.println("재작년 소득은"+incomeDTO.getIncomeYearBeforeLast());
        System.out.println("부채는"+incomeDTO.getDebt());
        memberService.updateMemberIncome(income);
        return "redirect:profile";
    }
}
