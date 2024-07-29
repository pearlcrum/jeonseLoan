package com.jeonse.config;

import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.service.CommonchecklistService;
import com.jeonse.service.HouseinfoService;
import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class SecurityController {

    @Autowired
    MemberService memberService;

    @Autowired
    HouseinfoService houseinfoService;

    @Autowired
    CommonchecklistService commonchecklistService;

    @RequestMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userInfo, HttpServletRequest httpServletRequest, Model model) throws Exception {
        if(userInfo!=null) {
            model.addAttribute("user", memberService.getUserInfo(userInfo.getUsername()));

        }
        HttpSession session = httpServletRequest.getSession(true);
        String memID=userInfo.getUsername();
        session.setAttribute("memID", memID);
        System.out.println("Security Controller " + memID);
        session.setMaxInactiveInterval(1800); //session이 30분동안 유지됨.
        //한 개 이상 완성된 checklist존재 시
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
        }
        return "/index";
    }
    @PostMapping(value="/houseSearch")
    @ResponseBody
    public HouseinfoDTO houseSearch(@RequestParam("houseID") int houseID){
        System.out.println("houseSearch success"+ houseID);
        HouseinfoDTO house = houseinfoService.getHouseinfo(houseID);
        return house;
    }
    //아파트 자동완성 검색
    @RequestMapping(value = "/autocomplete")
    public @ResponseBody Map<String, Object> autocomplete
            (@RequestParam Map<String, Object> paramMap) throws Exception{

        List<Map<String, Object>> resultList = houseinfoService.autocomplete(paramMap);
        paramMap.put("resultList", resultList);

        return paramMap;
    }
    @RequestMapping(value = "/getAllHouseInfo")
    public @ResponseBody Map<String, Object> getAllHouseInfo
            (@RequestParam Map<String, Object> paramMap) throws Exception{

        List<Map<String, Object>> resultList = houseinfoService.getAllHouseInfo();
        paramMap.put("resultList", resultList);

        return paramMap;
    }
}
