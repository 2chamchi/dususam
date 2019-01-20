package com.dudusam.mini.domains;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@Entity
@Table(name="DDS_MEMBER_PREFER")
public class MemberPreferenceVO {

    @ManyToOne(targetEntity = MemberVO.class, fetch = FetchType.LAZY)
    @JoinColumn(name="DDS_MEMBER_SYS_ID", referencedColumnName = "DDS_MEMBER_SYS_ID_PK", insertable = false, updatable = false)
    private MemberVO memberVO;

    @Column(name = "DDS_MEMBER_SYS_ID", length = 40, nullable = false)
    private String memberSystemId;

    @Id
    @Column(name="DDS_MEMBER_PREFER_SYS_ID_PK", length=40, nullable=false)
    @ApiModelProperty(hidden = true)
    private String systemId;

    @Column(name="DDS_MEMBER_PREFER_AGE")
    @ApiModelProperty()
    private int age;

    @Column(name="DDS_MEMBER_PREFER_CHARACTER")
    @ApiModelProperty()
    private int character; // 0 : 외향, 1 : 내향

    @Column(name="DDS_MEMBER_PREFER_COMPANY_LOC")
    @ApiModelProperty()
    private int companyLocation;

    @Column(name="DDS_MEMBER_PREFER_RELIGION")
    @ApiModelProperty()
    private int religion; // 종교

    @Column(name="DDS_MEMBER_PREFER_IS_SMOKE")
    @ApiModelProperty()
    private int isSmoke; // 0 : 금연, 1 : 흡연

    @Column(name="DDS_MEMBER_PREFER_DRINKING")
    @ApiModelProperty()
    private int drinking;

    @Column(name="DDS_MEMBER_PREFER_MOVIE")
    @ApiModelProperty()
    private int movie;

    @Column(name="DDS_MEMBER_PREFER_ACTION")
    @ApiModelProperty()
    private int action;

    @Column(name="DDS_MEMBER_PREFER_FOOD")
    @ApiModelProperty()
    private int food;

    @Column(name="DDS_MEMBER_PREFER_MUSIC")
    @ApiModelProperty()
    private int music;

    @Column(name="DDS_MEMBER_PREFER_MARK", nullable = false)
    @ApiModelProperty(hidden = true)
    private int mark; // 0 : 나, 1 : 선호 대상, 2 : ADDITIONAL POINT

    public MemberVO getMemberVO() {
        return memberVO;
    }

    public void setMemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    public String getMemberSystemId() {
        return memberSystemId;
    }

    public void setMemberSystemId(String memberSystemId) {
        this.memberSystemId = memberSystemId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public int getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(int companyLocation) {
        this.companyLocation = companyLocation;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getIsSmoke() {
        return isSmoke;
    }

    public void setIsSmoke(int isSmoke) {
        this.isSmoke = isSmoke;
    }

    public int getDrinking() {
        return drinking;
    }

    public void setDrinking(int drinking) {
        this.drinking = drinking;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
