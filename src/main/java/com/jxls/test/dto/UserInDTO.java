package com.jxls.test.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By User: RXK
 * Date: 2017/9/14
 * Time: 14:24
 * Version: V1.0
 * Description:对象入参的参数
 */
public class UserInDTO
{
	private String id;
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
	private Integer deleteFlag;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getMallId()
	{
		return mallId;
	}

	public void setMallId(String mallId)
	{
		this.mallId = mallId;
	}

	public String getQrCode()
	{
		return qrCode;
	}

	public void setQrCode(String qrCode)
	{
		this.qrCode = qrCode;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Integer getSex()
	{
		return sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

	public BigDecimal getHeight()
	{
		return height;
	}

	public void setHeight(BigDecimal height)
	{
		this.height = height;
	}

	public BigDecimal getWeight()
	{
		return weight;
	}

	public void setWeight(BigDecimal weight)
	{
		this.weight = weight;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getHeadPortraitIcon()
	{
		return headPortraitIcon;
	}

	public void setHeadPortraitIcon(String headPortraitIcon)
	{
		this.headPortraitIcon = headPortraitIcon;
	}

	public String getCityId()
	{
		return cityId;
	}

	public void setCityId(String cityId)
	{
		this.cityId = cityId;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getProvinceId()
	{
		return provinceId;
	}

	public void setProvinceId(String provinceId)
	{
		this.provinceId = provinceId;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public Integer getBirthyear()
	{
		return birthyear;
	}

	public void setBirthyear(Integer birthyear)
	{
		this.birthyear = birthyear;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public Date getRegistTime()
	{
		return registTime;
	}

	public void setRegistTime(Date registTime)
	{
		this.registTime = registTime;
	}

	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getIdCardNo()
	{
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo)
	{
		this.idCardNo = idCardNo;
	}

	public String getCaseHistory()
	{
		return caseHistory;
	}

	public void setCaseHistory(String caseHistory)
	{
		this.caseHistory = caseHistory;
	}

	public String getJob()
	{
		return job;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

	public Integer getHasScheme()
	{
		return hasScheme;
	}

	public void setHasScheme(Integer hasScheme)
	{
		this.hasScheme = hasScheme;
	}

	public Integer getHasAnalyze()
	{
		return hasAnalyze;
	}

	public void setHasAnalyze(Integer hasAnalyze)
	{
		this.hasAnalyze = hasAnalyze;
	}

	public Integer getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public String getCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getUpdateBy()
	{
		return updateBy;
	}

	public void setUpdateBy(String updateBy)
	{
		this.updateBy = updateBy;
	}
}
