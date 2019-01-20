package com.dudusam.mini.controllers;

import com.dudusam.mini.domains.MemberVO;
import com.dudusam.mini.services.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "Member Controller", description = "회원 관련")
@CrossOrigin(origins="*")
@RequestMapping(value = "/dudusam/api/v1/members")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "회원 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name="memberVO", value ="회원 정보", paramType="body", dataType = "MemberVO", required = true)
    })
    @RequestMapping(value = "/member", method = {RequestMethod.POST})
    public ResponseEntity add(
            @RequestBody MemberVO memberVO) {

        memberService.addUser(memberVO);

        return null;
    }

    @ApiOperation(value = "회원 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name="memberVO", value ="회원 정보", paramType="path", dataType = "String", required = true)
    })
    @RequestMapping(value = "/member/{loginId}", method = {RequestMethod.GET})
    public ResponseEntity select(
           @PathVariable("loginId") String loginId) {

        return null;
    }

    @ApiOperation(value = "회원 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name="memberVO", value ="회원 정보", paramType="body", dataType = "MemberVO", required = true)
    })
    @RequestMapping(value = "/member", method = {RequestMethod.PUT})
    public ResponseEntity update(
           @RequestBody MemberVO memberVO) {

        return null;
    }

    @ApiOperation(value = "회원 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name="memberVO", value ="회원 정보", paramType="body", dataType = "MemberVO", required = true)
    })
    @RequestMapping(value = "/member", method = {RequestMethod.DELETE})
    public ResponseEntity delete(
            @RequestBody MemberVO memberVO) {

        return null;
    }
}
