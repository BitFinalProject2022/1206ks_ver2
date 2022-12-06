package com.showmual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showmual.dao.StyleDao;
import com.showmual.model.ManStyleVo;
import com.showmual.model.WomanStyleVo;

@Service("styleService")
@Transactional
public class StyleService {
    
    @Autowired
    StyleDao styleDao;
    
    public List<ManStyleVo> listManStyles(
            List<ManStyleVo> temperatureList, List<ManStyleVo> colorCodeList,
            List<ManStyleVo> styleCodeList, List<ManStyleVo> hashtagCodeList) {
        List<ManStyleVo> manStyleList = 
                styleDao.selectManCoordinate(temperatureList, colorCodeList, styleCodeList, hashtagCodeList);
        return manStyleList;
    }
    
    public List<WomanStyleVo> listWomanStyles() {
        List<WomanStyleVo> womanStyleList = styleDao.selectWomenCoordinate();
        return womanStyleList;
    }
    
}
