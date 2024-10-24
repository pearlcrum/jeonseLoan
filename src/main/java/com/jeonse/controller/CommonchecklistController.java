package com.jeonse.controller;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.IbkansimjeonseDTO;
import com.jeonse.dto.IbkjeonseDTO;
import com.jeonse.dto.MemberDTO;
import com.jeonse.service.CommonchecklistService;
import com.jeonse.service.IbkansimjeonseService;
import com.jeonse.service.IbkjeonseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonchecklistController {
    @Autowired
    private CommonchecklistService commonchecklistService;

    @Autowired
    private IbkansimjeonseService ibkansimjeonseService;

    @Autowired
    private IbkjeonseService ibkjeonseService;
    private String memberID;

    private int wishlistNum;

    private int houseID;

    //체크리스트 보여주기
    @GetMapping("/checklist")
    public String checklist(@SessionAttribute(name="memID", required = false) String memID,@RequestParam(value="houseID") String houseId, CommonchecklistDTO commonchecklistDTO, Model model) {
        //체크리스트에 값이 이미 있는 경우
        memberID=memID;
        /* 여러개의 체크리스트가 들어가야하기에 수정
        if(commonchecklistService.checkCommonchecklistID(memID)!=0){
            List<CommonchecklistDTO> list= new ArrayList<CommonchecklistDTO>();
            list=commonchecklistService.getAllCommonChecklist(memID);
            //int wishlistNum=list.get(0).getWishlistNum(); //현재는 맨 처음 있는거 보여줌
            int wishlistNum=1;
            ibkansimjeonseService.deleteIbkAnsimjeonse(wishlistNum);
            ibkjeonseService.deleteIbkjeonse(wishlistNum);
            commonchecklistService.deleteCommonchecklist(memID,wishlistNum);
            model.addAttribute("message","기존의 체크리스트는 삭제됩니다. 물건지를 다시 검색해 주세요.");
            model.addAttribute("returnURL","/");

            return "message";
            //return "profile";
        }else
     */
        //체크리스트 추가
        //memid 를 받아야함.
        houseID=Integer.parseInt(houseId);
        System.out.println("**** house ID is "+ houseID);
        System.out.println("memID is " + memID);
        MemberDTO member=commonchecklistService.getMember(memID);
        System.out.println("nice is"+ member.getNice());
        System.out.println("kcb is"+ member.getKcb());
        System.out.println("incomeLastYear is"+ member.getIncomeLastYear());
        System.out.println("incomeYearBefore is"+ member.getIncomeYearBeforeLast());
        System.out.println("debt is"+ member.getDebt());
        System.out.println("birth is"+ member.getBirth());
        System.out.println("numhouse is"+ member.getNumhouse());
        return "checklist";


    }

    @PostMapping("/checklistNextStep")
    public String checklistNextStep(CommonchecklistDTO commonchecklistDTO) {
        System.out.println("@@@");
        //값 잘 들어오네
        System.out.println("agentCheck y/n"+  commonchecklistDTO.isAgentCheck());
        System.out.println("foreingerCheck y/n"+  commonchecklistDTO.isForiengerCheck());
        System.out.println("familyCheck y/n"+  commonchecklistDTO.isFamilyCheck());
        System.out.println("loanAmount "+  commonchecklistDTO.getLoanAmount());
        System.out.println("housePrice "+  commonchecklistDTO.getHousePrice());
        System.out.println("jeonseDepoist "+  commonchecklistDTO.getJeonseDeposit());
        System.out.println("jeonseTerm "+  commonchecklistDTO.getJeonseTerm());
        System.out.println("landlordPoss y/n"+  commonchecklistDTO.getLandlordPossessionMonth());
        System.out.println("seniorDebt "+  commonchecklistDTO.getSeniorDebt());

        //가지고 온 값들 db insert
        commonchecklistDTO.setMemID(memberID);
        commonchecklistDTO.setHouseID(houseID);
        System.out.println("houseID"+ commonchecklistDTO.getHouseID());

        int good = commonchecklistService.insertCommonchecklist(commonchecklistDTO);
        wishlistNum=commonchecklistService.getLatestWishlistNumFromCommonchecklist(memberID);
        System.out.println("What is wishlist Num?"+wishlistNum);

        return "redirect:ibkansimjeonseChecklist";
        //good이 0일 경우 error 페이지 개발 필요
    }


    public String processSignup(@RequestParam("inputName") String inputName,
                                @RequestParam("inputEmail") String inputEmail,
                                @RequestParam("inputPassword") String inputPassword,
                                Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("inputName", inputName);
        model.addAttribute("inputEmail", inputEmail);
        model.addAttribute("inputPassword", inputPassword);

        redirectAttributes.addAttribute("inputEmail", inputEmail);
        redirectAttributes.addAttribute("inputPassword", inputPassword);
        return "redirect:index";

    }
    @GetMapping("/ibkansimjeonseChecklist")
    public String ibkansimjeonseChecklist(@SessionAttribute(name="memID", required = false) String memID, IbkansimjeonseDTO ibkansimjeonseDTO, Model model, RedirectAttributes redirect) {
        /*//체크리스트에 값이 이미 있는 경우
        if(commonchecklistService.checkCommonchecklistID(memID)==0){
            model.addAttribute("message","공통 체크리스트부터 작성하셔야 합니다.");
            model.addAttribute("returnURL","/");
            return "message";
        }else {*/
            //체크리스트에 값이 없는 경우
            //memid 를 받아야함.
            memberID = memID;

            System.out.println("memID is " + memID);

            return "ibkansimjeonseChecklist";

    }
    @PostMapping("/ansimJeonseCheckList")
    public String ansimJeonseCheckList(IbkansimjeonseDTO ibkansimjeonseDTO){
        System.out.println("###");
        //값 잘 들어오네
        System.out.println("insurance y/n"+  ibkansimjeonseDTO.isInsurance());
        System.out.println("isNearAgent y/n"+  ibkansimjeonseDTO.isNearAgent());
        System.out.println("isShouldPayInTwoWeeks y/n"+  ibkansimjeonseDTO.isShouldPayInTwoWeeks());
        System.out.println("isPropertyRestrict y/n "+  ibkansimjeonseDTO.isPropertyRestrict());
        //가지고 온 값들 db insert
        //가장 최근에 진행했던 wishlistNum
        ibkansimjeonseDTO.setWishlistNum(wishlistNum);
        int good = ibkansimjeonseService.insertIbkansimjeonse(ibkansimjeonseDTO);
        //good이 1일 경우
        return "redirect:ibkjeonseChecklist";
        //good이 0일 경우 error 페이지 개발 필요
    }


    @GetMapping("/ibkjeonseChecklist")
    public String ibkjeonseChecklist(@SessionAttribute(name="memID", required = false) String memID, IbkjeonseDTO ibkjeonseDTO, Model model) {
        //체크리스트에 값이 이미 있는 경우
        /*if(commonchecklistService.checkCommonchecklistID(memID)==0){
            model.addAttribute("message","공통 체크리스트부터 작성하셔야 합니다.");
            model.addAttribute("returnURL","/");
            return "message";
        }else {*/
            //체크리스트에 값이 없는 경우
            //memid 를 받아야함.
            memberID = memID;
            System.out.println("ibk jeonse memID is " + memID);

            //추후 결과 화면 값 나오면 여기서 체크
            return "ibkjeonseChecklist";

    }
    @PostMapping("/ibkJeonseCheckList")
    public String ibkJeonseCheckList(IbkjeonseDTO ibkjeonseDTO){
        System.out.println("***");
        //값 잘 들어오네
        System.out.println("jeonip y/n"+  ibkjeonseDTO.isJeonip());
        System.out.println("confirmDate y/n"+  ibkjeonseDTO.isConfirmDate());
        System.out.println("interestRate "+  ibkjeonseDTO.getInterestRate());
        System.out.println("nowJeonse y/n "+  ibkjeonseDTO.isNowJeonse());
        System.out.println("creditManagement "+  ibkjeonseDTO.isCreditManagement());
        System.out.println("landLordPermit "+  ibkjeonseDTO.isLandLordPermit());
        //가장 최근에 사용했던 wishlistNum
        ibkjeonseDTO.setWishlistNum(wishlistNum);
        int good = ibkjeonseService.insertIbkjeonse(ibkjeonseDTO);
        //good이 1일 경우
        return "redirect:result";
        //good이 0일 경우 error 페이지 개발 필요
    }
}

