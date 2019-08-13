package io.geekidea.springbootplus.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import io.geekidea.springbootplus.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author dodar
 * @since 2019-08-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Yidao对象", description="")
public class Yidao extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "YiDao ID")
    @TableId(value = "dao_id", type = IdType.ID_WORKER)
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
