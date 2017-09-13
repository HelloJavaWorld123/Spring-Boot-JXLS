package com.jxls.test.dto;


import com.jxls.test.dto.base.EntityBase;

import java.math.BigDecimal;
import java.util.Date;

public class User extends EntityBase
{
    /**
     * 手机
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 
     *
     * @mbggenerated
     */
    private String mallId;

    /**
     * 
     *
     * @mbggenerated
     */
    private String qrCode;

    /**
     * 生日
     *
     * @mbggenerated
     */
    private String birthday;

    /**
     * 年龄
     *
     * @mbggenerated
     */
    private Integer age;

    /**
     * 性别 1 为男性 0为女性
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * 身高
     *
     * @mbggenerated
     */
    private BigDecimal height;

    /**
     * 体重
     *
     * @mbggenerated
     */
    private BigDecimal weight;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 头像图片
     *
     * @mbggenerated
     */
    private String headPortraitIcon;

    /**
     * 
     *
     * @mbggenerated
     */
    private String cityId;

    /**
     * 城市
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 
     *
     * @mbggenerated
     */
    private String provinceId;

    /**
     * 省份
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 出生年份
     *
     * @mbggenerated
     */
    private Integer birthyear;

    /**
     * 个性签名
     *
     * @mbggenerated
     */
    private String signature;

    /**
     * 注册时间
     *
     * @mbggenerated
     */
    private Date registTime;

    /**
     * 最后登录时间
     *
     * @mbggenerated
     */
    private Date lastLoginTime;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * 身份证号
     *
     * @mbggenerated
     */
    private String idCardNo;

    /**
     * 病史，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    private String caseHistory;

    /**
     * 职业，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    private String job;
    
    
    private Integer hasScheme;
    private Integer hasAnalyze;
    
    /**
     * 手机
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public String getMallId() {
        return mallId;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 年龄
     *
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     *
     * @mbggenerated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别 1 为男性 0为女性
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别 1 为男性 0为女性
     *
     * @mbggenerated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 身高
     *
     * @mbggenerated
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * 身高
     *
     * @mbggenerated
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * 体重
     *
     * @mbggenerated
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 体重
     *
     * @mbggenerated
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 昵称
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 头像图片
     *
     * @mbggenerated
     */
    public String getHeadPortraitIcon() {
        return headPortraitIcon;
    }

    /**
     * 头像图片
     *
     * @mbggenerated
     */
    public void setHeadPortraitIcon(String headPortraitIcon) {
        this.headPortraitIcon = headPortraitIcon;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 城市
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * 
     *
     * @mbggenerated
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 省份
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 出生年份
     *
     * @mbggenerated
     */
    public Integer getBirthyear() {
        return birthyear;
    }

    /**
     * 出生年份
     *
     * @mbggenerated
     */
    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * 个性签名
     *
     * @mbggenerated
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 个性签名
     *
     * @mbggenerated
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 注册时间
     *
     * @mbggenerated
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * 注册时间
     *
     * @mbggenerated
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * 最后登录时间
     *
     * @mbggenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     *
     * @mbggenerated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 姓名
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 身份证号
     *
     * @mbggenerated
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 身份证号
     *
     * @mbggenerated
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 病史，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    public String getCaseHistory() {
        return caseHistory;
    }

    /**
     * 病史，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    public void setCaseHistory(String caseHistory) {
        this.caseHistory = caseHistory;
    }

    /**
     * 职业，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    public String getJob() {
        return job;
    }

    /**
     * 职业，健康猫app基本信息字段
     *
     * @mbggenerated
     */
    public void setJob(String job) {
        this.job = job;
    }

	public Integer getHasScheme() {
		return hasScheme;
	}

	public void setHasScheme(Integer hasScheme) {
		this.hasScheme = hasScheme;
	}

	public Integer getHasAnalyze() {
		return hasAnalyze;
	}

	public void setHasAnalyze(Integer hasAnalyze) {
		this.hasAnalyze = hasAnalyze;
	}
    
    
    
}