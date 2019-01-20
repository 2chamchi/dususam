package com.dudusam.mini.services;


import com.dudusam.mini.config.DudusamConstants;
import com.dudusam.mini.dao.MemberPreferDao;
import com.dudusam.mini.domains.MemberPreferenceVO;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberPreferService {

    @Autowired
    MemberPreferDao memberPreferDao;

    public String add(MemberPreferenceVO memberPreferenceVO) {
        JsonObject body = new JsonObject();

        String systemId = DudusamConstants.DUDUSAM_TABLE_PREFIX +
                DudusamConstants.DUDUSAM_TABLE_TOKEN +
                UUID.randomUUID(); // 36 자리


        if(memberPreferDao.addUser(memberPreferenceVO) > 0){
            body.addProperty("result", "success");
        }else{
            body.addProperty("result", "fail");
        }
        return body.toString();
    }

    public MemberPreferenceVO get(String systemId) {
        return null;
    }

    public String update(MemberPreferenceVO memberPreferenceVO) {
        JsonObject body = new JsonObject();
        return body.toString();
    }

    public String delete(MemberPreferenceVO memberPreferenceVO) {
        JsonObject body = new JsonObject();
        return body.toString();
    }

}
