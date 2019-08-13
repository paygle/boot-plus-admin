package io.geekidea.springbootplus.common.entity;

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
@ApiModel(value="TaskManagement对象", description="")
public class TaskManagement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID")
    @TableId(value = "task_id", type = IdType.AUTO)
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
