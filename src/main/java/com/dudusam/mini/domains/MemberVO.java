package com.dudusam.mini.domains;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name="DDS_MEMBER")
public class MemberVO {

    @Id
    @Column(name="DDS_MEMBER_SYS_ID_PK", length=40, nullable=false)
    @ApiModelProperty(hidden = true)
    private String systemId;

    @Column(name="DDS_MEMBER_LOGIN_ID", length = 20, nullable=false)
    @ApiModelProperty(value = "로그인 아이디")
    private String loginId;

    @Column(name="DDS_MEMBER_PWD", length=10, nullable=false)
    @ApiModelProperty(value = "로그인 패스워드", position = 1)
    private String pwd;

    @Column(name="DDS_MEMBER_EMAIL", length=40, nullable=false)
    @NotBlank(message = "It is necessary value.")
    @ApiModelProperty(value = "E-mail", position = 2)
    private String email;

    @Column(name="DDS_MEMBER_GENDER", nullable=false)
    @ApiModelProperty(value = "성별", position = 3)
    private int gender;

    @CreationTimestamp
    @Column(name="DDS_MEMBER_REG_DATE", nullable=false)
    @ApiModelProperty(hidden = true)
    private LocalDateTime registerDate;

    @UpdateTimestamp
    @Column(name="DDS_MEMBER_UPD_DATE")
    @ApiModelProperty(hidden = true)
    private LocalDateTime  updateDate;

    @Column(name="DDS_MEMBER_IS_PUBLIC", nullable=false)
    @ApiModelProperty(value = "공개 여부", position = 4)
    private int isPublic;


    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

}
