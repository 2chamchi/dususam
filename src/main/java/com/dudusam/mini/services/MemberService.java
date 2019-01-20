package com.dudusam.mini.services;

import com.dudusam.mini.config.DudusamConstants;
import com.dudusam.mini.dao.MemberDao;
import com.dudusam.mini.domains.MemberVO;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public String addUser(MemberVO memberVO) {
        JsonObject body = new JsonObject();

        // 36 자리
        String systemId = DudusamConstants.DUDUSAM_TABLE_PREFIX +
                DudusamConstants.DUDUSAM_TABLE_TOKEN +
                UUID.randomUUID();
        memberVO.setSystemId(systemId);


        if(memberDao.addUser(memberVO) > 0){
            body.addProperty("result", "success");
        }else{
            body.addProperty("result", "fail");
        }
        return body.toString();
    }

    public MemberVO getUser(String systemId) {
        return null;
    }

    public String updateUser(MemberVO memberVO) {
        JsonObject body = new JsonObject();
        return body.toString();
    }

    public String deleteUser(MemberVO memberVO) {
        JsonObject body = new JsonObject();
        return body.toString();
    }
}
