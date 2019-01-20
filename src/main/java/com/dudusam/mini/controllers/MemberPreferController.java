package com.dudusam.mini.controllers;


import com.dudusam.mini.services.MemberPreferService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Member Preference Controller", description = "회원 선호 정보 관련")
@CrossOrigin(origins="*")
@RequestMapping(value = "/dudusam/api/v1/members/preferences")
@RestController
public class MemberPreferController {

    @Autowired
    MemberPreferService memberPreferService;

}
