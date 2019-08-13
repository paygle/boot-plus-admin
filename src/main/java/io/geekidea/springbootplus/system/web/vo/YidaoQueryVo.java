package io.geekidea.springbootplus.system.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 *  查询结果对象
 * </p>
 *
 * @author dodar
 * @date 2019-08-13
 */
@Data
@ApiModel(value="YidaoQueryVo对象", description="查询参数")
public class YidaoQueryVo implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "YiDao ID")
    private Long daoId;

    @ApiModelProperty(value = "游戏账号")
    private String account;

    @ApiModelProperty(value = "游戏区服")
    private String gameArea;

    @ApiModelProperty(value = "VIP等级")
    private String vipLevel;

    @ApiModelProperty(value = "元宝数量")
    private Long ingotNum;

    @ApiModelProperty(value = "任务类型：练级、刷金")
    private String taskType;

    @ApiModelProperty(value = "任务阶段")
    private String taskPhase;

    @ApiModelProperty(value = "游戏密码")
    private String passwd;

    @ApiModelProperty(value = "账号状态")
    private String accountStatus;

    @ApiModelProperty(value = "账号当日登录次数")
    private Integer loginTimesDay;

    @ApiModelProperty(value = "账号封禁状态")
    private String accountBlocked;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "最近退出时间")
    private Date logoutTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}