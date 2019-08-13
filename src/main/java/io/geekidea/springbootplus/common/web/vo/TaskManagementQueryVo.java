package io.geekidea.springbootplus.common.web.vo;

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
@ApiModel(value="TaskManagementQueryVo对象", description="查询参数")
public class TaskManagementQueryVo implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    @ApiModelProperty(value = "手机IMEI码")
    private String mobileImei;

    @ApiModelProperty(value = "别名（自定义标识）")
    private String alias;

    @ApiModelProperty(value = "机器码")
    private String machineCode;

    @ApiModelProperty(value = "IP地址")
    private String ipAddress;

    @ApiModelProperty(value = "设备状态：正常、掉线")
    private String deviceState;

    @ApiModelProperty(value = "注册码")
    private String regCode;

    @ApiModelProperty(value = "注册码到期时间")
    private Date expireDate;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}