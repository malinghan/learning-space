package com.example.demo;


import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ERecruitHeaderField {
    //candidate //referee -> recommender??? //currentCompany -> lastCompany？？ //currentJob -> lastJob??
    NAME(1, "name", "姓名", "s", 0, "姓名", 1, 30, "candidate"),
    MOBILE(2, "mobile", "手机号", "s", 0, "手机号", 1, 30, "candidate"),
    EMAIL(3, "email", "邮箱", "s", 0, "邮箱", 1, 30, "candidate"),
    RESUMESTATUS(4, "resumeStatus", "简历状态", "s", 0, "简历状态", 1, 30, "candidate"),
    APPLYJOB(5, "applyJob", "应聘职位", "s", 0, "应聘职位", 1, 30, "candidate"),
    CHANNEL(6, "channel", "来源渠道", "s", 0, "来源渠道", 1, 30, "candidate"),
    REFEREE(7, "referee", "推荐人", "s", 0, "推荐人", 0, 30, "candidate"),
    DELIVERYTYPE(8, "delieveType", "投递类型", "s", 0, "投递类型", 1, 30, "candidate"),
    SEX(9, "sex", "性别", "s", 0, "性别", 0, 30, "candidate"),
    BIRTHDATE(10, "birthDate", "出生日期", "s", 0, "出生日期", 0, 30, "candidate"),
    WORKSTARTDATE(11, "workStartDate", "参加工作时间", "s", 0, "参加工作时间", 0, 30, "candidate"),
    WORKAGE(12, "workAge", "工作经验", "s", 0, "工作经验", 0, 30, "candidate"),
    CURRENTCOMPANY(13, "currentCompany", "最近受聘公司", "s", 0, "最近受聘公司", 0, 30, "candidate"),
    CURRENTJOB(14, "currentJob", "最近工作职位", "s", 0, "最近工作职位", 0, 30, "candidate"),
    INDUSTRY(15, "industry", "所在行业", "s", 0, "所在行业", 0, 30, "candidate"),
    DEGREE(16, "degree", "最高学历", "s", 0, "最高学历", 0, 30, "candidate"),
    SCHOOL(17, "school", "毕业院校", "s", 0, "毕业院校", 0, 30, "candidate"),
    SCHOOLTYPE(18, "schoolType", "院校类别", "s", 0, "院校类别", 0, 30, "candidate"),
    MAJOR(19, "major", "所学专业", "s", 0, "所学专业", 0, 30, "candidate"),
    TASKID(20, "taskId", "招聘任务", "s", 0, "招聘任务", 0, 30, "candidate"),
    BIRTHPLACE(21, "birthPlace", "籍贯", "s", 0, "籍贯", 0, 30, "candidate"),
    LIVECITY(22, "liveCity", "现居住地", "s", 0, "现居住地", 0, 30, "candidate"),
    POLITICALSTATUS(23, "politicalStatus", "政治面貌", "s", 0, "政治面貌", 0, 30, "candidate"),
    NATION(24, "nation", "民族", "s", 0, "民族", 0, 30, "candidate"),
    MARRIAGE(25, "marriage", "婚姻状况", "s", 0, "婚姻状况", 0, 30, "candidate"),
    SKILL(26, "skill", "技能", "s", 0, "技能", 0, 30, "candidate"),
    INTERESTING(27, "interesting", "兴趣爱好", "s", 0, "兴趣爱好", 0, 30, "candidate"),
    APPLYTIME(28, "applyTime", "投递日期", "s", 0, "投递日期", 1, 30, "candidate"),
    LABEL(29, "label", "简历标签", "s", 0, "简历标签", 0, 30, "candidate"),
    REMARK(30, "remark", "备注", "s", 0, "备注", 0, 30, "candidate"),
    JOBNATURE(31, "jobNature", "职位性质", "s", 0, "职位性质", 0, 30, "candidate"),
    WORKPOSITION(32, "workPosition", "工作地", "s", 0, "工作地", 0, 30, "candidate"),
    EXPECTSALARY(33, "expectSalary", "期望薪资", "s", 0, "期望薪资", 0, 30, "candidate"),
    EXPECTINDUSTRY(34, "expectIndustry", "期望行业", "s", 0, "期望行业", 0, 30, "candidate"),
    EXPECTENTRYTIME(35, "expectEntryTime", "到岗期限", "s", 0, "到岗期限", 0, 30, "candidate"),
    SELFEVALUATION(36, "selfEvaluation", "自我评价", "s", 0, "自我评价", 0, 30, "candidate"),

    //recommend
    RECOMMENDTIME(60, "_recommendTime", "推荐时间", "s", 0, "推荐时间", 0, 30, "recommend"),
    RECOMMENDACCOUNT(61, "_recommendAccount", "推荐负责人", "s", 0, "推荐负责人", 1, 30, "recommend"),
    RECOMMENDEMPLOYEE(62, "_recommendEmployee", "推荐面试官", "s", 0, "推荐面试官", 1, 30, "recommend"),
    RECOMMENDPASS(63, "_recommendPass", "推荐结果", "s", 0, "推荐结果", 0, 30, "recommend"),
    RECOMMENDFEEDBACKTIME(64, "_recommendFeedBackTime", "推荐反馈时间", "s", 0, "推荐反馈时间", 0, 30, "recommend"),

    //interview
    INTERVIEWROUNDS(65, "_interviewRounds", "面试轮次", "s", 0, "面试轮次", 1, 30, "interview"),
    INTERVIEWDATE(66, "_interviewDate", "面试日期", "s", 0, "面试日期", 1, 30, "interview"),
    INTERVIEWTIME(67, "_interviewTime", "面试时间", "s", 0, "面试时间", 1, 30, "interview"),
    INTERVIEWACCOUNT(68, "_interviewAccount", "负责人", "s", 0, "负责人", 1, 30, "interview"),
    INTERVIEWEMPLOYEE(69, "_interviewEmployee", "面试官", "s", 0, "面试官", 0, 30, "interview"),
    INTERVIEWINVITESTATUS(70, "_interviewInviteStatus", "邀约状态", "s", 0, "邀约状态", 1, 30, "interview"),
    INTERVIEWSIGNSTATUS(71, "_interviewSignStatus", "签到状态", "s", 0, "签到状态", 1, 30, "interview"),
    INTERVIEWFEEDBACK(72, "_interviewFeedBack", "面试结果", "s", 0, "面试结果", 1, 30, "interview"),
    INTERVIEWFEEDBACKTIME(73, "_interviewFeedBackTime", "反馈时间", "s", 0, "反馈时间", 0, 30, "interview"),

    //offer
    OFFERADDTIME(74, "offerAddtime", "offer发送日期", "s", 0, "offer发送日期", 0, 30, "offer"),
    OFFERVALIDITYDAY(75, "offerValidityDay", "offer有效期", "s", 0, "offer有效期", 0, 30, "offer"),
    OFFERBACKTIME(76, "offerBackTime", "offer反馈日期", "s", 0, "offer反馈日期", 0, 30, "offer"),
    OFFERSTATUS(77, "offerStatus", "offer反馈结果", "s", 0, "offer反馈结果", 1, 30, "offer"),
    OFFERACCOUNT(78, "offerAccount", "offer负责人", "s", 0, "offer负责人", 0, 30, "offer"),
    OFFERREGISTERDATE(79, "offerRegisterDate", "offer入职日期", "s", 0, "offer入职日期", 0, 30, "offer"),
    OFFERHIRETYPE(80, "offerHireType", "offer聘用形式", "s", 0, "offer聘用形式", 1, 30, "offer"),
    OFFERREGULARTYPE(81, "offerRegularType", "offer非正式类型", "s", 0, "offer非正式类型", 0, 30, "offer"),
    OFFERPROBATION(84, "offerProbation", "offer试用期", "s", 0, "offer试用期", 1, 30, "offer"),
    OFFERREGULARDATE(85, "offerRegularDate", "offer转正日期", "s", 0, "offer转正日期", 0, 30, "offer"),
    OFFERJOBNAME(86, "offerJobName", "offer入职岗位", "s", 0, "offer入职岗位", 1, 30, "offer"),
    OFFERDEPARTMENTNAME(87, "offerDepartmentName", "offer入职部门", "s", 0, "offer入职部门", 1, 30, "offer"),
    OFFERENTRYCOMPANY(88, "offerEntryCompany", "offer入职公司", "s", 0, "offer入职公司", 0, 30, "offer"),
    OFFERRANK(89, "offerRank", "offer职级", "s", 0, "offer职级", 0, 30, "offer"),
    OFFERHRBPNAME(90, "offerHrbpName", "offerHRBP", "s", 0, "offerHRBP", 0, 30, "offer"),
    OFFERDIRECTORNAME(91, "offerDirectorName", "offer汇报对象", "s", 0, "offer汇报对象", 0, 30, "offer"),
    OFFERSUBJECTION(92, "offerSubjection", "offer管理形式", "s", 0, "offer管理形式", 0, 30, "offer"),
    OFFERCITYNAME(93, "offerCityName", "offer工作城市", "s", 0, "offer工作城市", 0, 30, "offer"),

    //entry
    ISENTRY(94, "isEntry", "是否已入职", "s", 0, "是否已入职", 1, 30, "entry"),
    ENTRTTIME(95, "entryTime", "实际入职日期", "s", 0, "实际入职日期", 1, 30, "entry"),
    ENTRYACCOUNT(96, "entryAccount", "入职负责人", "s", 0, "入职负责人", 1, 30, "entry"),
    ENTRYOPERATORTIME(97, "entryOperatorTime", "操作入职时间", "s", 0, "操作入职时间", 0, 30, "entry"),

    //regular
    ISREGULAR(98, "isRegular", "是否转正", "s", 0, "是否转正", 1, 30, "regular"),
    REGULARTIME(99, "regularTime", "转正日期", "s", 0, "转正日期", 1, 30, "regular"),
    REGULARJUDGEMENT(100, "regularJudgement", "转正评价", "s", 0, "转正评价", 1, 30, "regular");

    private int id;
    private String fieldId;
    private String fieldName;
    private String dataType;
    private Integer isSum;
    private String desc;
    private Integer isSelected;
    private int formId;
    private String group;

    ERecruitHeaderField(int id,
                        String fieldId,
                        String fieldName,
                        String dataType,
                        Integer isSum,
                        String desc,
                        Integer isSelected,
                        int formId,
                        String group) {
        this.id = id;
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.dataType = dataType;
        this.isSum = isSum;
        this.desc = desc;
        this.isSelected = isSelected;
        this.formId = formId;
        this.group = group;
    }




    public static Map<String,List<ERecruitHeaderField>> getERecruitHeaderFieldMapByFormId(int fromId){
        return Stream.of(ERecruitHeaderField.class.getEnumConstants())
                .filter(s -> s.getFormId() == fromId)
                .collect(Collectors.groupingBy(
                        ERecruitHeaderField::getGroup,
                        LinkedHashMap::new,
                        Collectors.toList()));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getIsSum() {
        return isSum;
    }

    public void setIsSum(Integer isSum) {
        this.isSum = isSum;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
