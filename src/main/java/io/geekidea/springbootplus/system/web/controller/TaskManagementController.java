package io.geekidea.springbootplus.system.web.controller;

import io.geekidea.springbootplus.system.entity.TaskManagement;
import io.geekidea.springbootplus.system.service.TaskManagementService;
import io.geekidea.springbootplus.system.web.param.TaskManagementQueryParam;
import io.geekidea.springbootplus.system.web.vo.TaskManagementQueryVo;
import io.geekidea.springbootplus.common.web.controller.BaseController;
import io.geekidea.springbootplus.common.api.ApiResult;
    import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.geekidea.springbootplus.common.web.vo.Paging;
import io.geekidea.springbootplus.common.web.param.IdParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dodar
 * @since 2019-08-13
 */
@Slf4j
@RestController
@RequestMapping("/taskManagement")
@Api(" API")
public class TaskManagementController extends BaseController {

    @Autowired
    private TaskManagementService taskManagementService;

    /**
    * 添加
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加TaskManagement对象",notes = "添加",response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Valid @RequestBody TaskManagement taskManagement) throws Exception{
        boolean flag = taskManagementService.save(taskManagement);
        return ApiResult.result(flag);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改TaskManagement对象",notes = "修改",response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Valid @RequestBody TaskManagement taskManagement) throws Exception{
        boolean flag = taskManagementService.updateById(taskManagement);
        return ApiResult.result(flag);
    }

    /**
    * 删除
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除TaskManagement对象",notes = "删除",response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        boolean flag = taskManagementService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
    * 获取
    */
    @PostMapping("/info")
    @ApiOperation(value = "获取TaskManagement对象详情",notes = "查看",response = TaskManagementQueryVo.class)
    public ApiResult<TaskManagementQueryVo> getSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        TaskManagementQueryVo taskManagementQueryVo = taskManagementService.getTaskManagementById(idParam.getId());
        return ApiResult.ok(taskManagementQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取TaskManagement分页列表",notes = "分页列表",response = TaskManagementQueryVo.class)
    public ApiResult<Paging<TaskManagementQueryVo>> getTaskManagementPageList(@Valid @RequestBody(required = false) TaskManagementQueryParam taskManagementQueryParam) throws Exception{
        Paging<TaskManagementQueryVo> paging = taskManagementService.getTaskManagementPageList(taskManagementQueryParam);
        return ApiResult.ok(paging);
    }

}

