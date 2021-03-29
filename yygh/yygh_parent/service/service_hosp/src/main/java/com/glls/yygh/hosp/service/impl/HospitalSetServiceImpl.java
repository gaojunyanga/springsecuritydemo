package com.glls.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glls.yygh.hosp.mapper.HospitalSetMapper;
import com.glls.yygh.hosp.service.HospitalSetService;
import com.glls.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : HospitalSetServiceImpl
 * @Author : glls
 * @Date: 2021/3/15 19:29
 * @Description :
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Autowired
    private HospitalSetMapper hospitalSetMapper;

}
