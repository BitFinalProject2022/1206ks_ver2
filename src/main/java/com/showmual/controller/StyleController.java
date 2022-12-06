package com.showmual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showmual.model.ManStyleVo;
import com.showmual.model.WomanStyleVo;
import com.showmual.service.StyleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/closet")
public class StyleController {
    
    @Autowired
    StyleService styleService;
    
    @Autowired
    ManStyleVo manStyleVo;
    
    @Autowired
    WomanStyleVo womanStyleVo;
    
    List<ManStyleVo> manCoordiList = new ArrayList<ManStyleVo>();
    
    List<WomanStyleVo> womanStyleList = new ArrayList<WomanStyleVo>();
    
    
    // 코디 페이지
//    @RequestMapping(value = "/coordinate", method = RequestMethod.GET)
//    public String coordinatePage(Model model) {
//
//        return "coordinate";
//    }
    
    
    
    // 남자스타일 페이지
    @RequestMapping(value = "/manCoordi", method = RequestMethod.GET)
    public String manCoordi(Model model) {
    
        return "manCoordi";
    }
    
    
    // 코디 검색 하기
    @RequestMapping(value="/searchCoordi", method=RequestMethod.POST)
    @ResponseBody
    public List<ManStyleVo> selectImagePath(
            @RequestParam(value = "temperatureList") List<ManStyleVo> temperatureList,
            @RequestParam(value = "colorCodeList") List<ManStyleVo> colorCodeList,
            @RequestParam(value = "styleCodeList") List<ManStyleVo> styleCodeList,
            @RequestParam(value = "hashtagCodeList") List<ManStyleVo> hashtagCodeList) {
        
        manCoordiList = styleService.listManStyles(temperatureList, colorCodeList, styleCodeList, hashtagCodeList);
        
        return manCoordiList;
    }
    
    
    // 여자스타일 페이지
    @RequestMapping(value = "/womanCoordi", method = RequestMethod.GET)
    public String getWomanStyleList(Model model) {
        
        return "womanCoordi";
    }
    
}
