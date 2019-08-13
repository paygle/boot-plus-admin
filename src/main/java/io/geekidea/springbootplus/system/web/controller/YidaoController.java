package io.geekidea.springbootplus.system.web.controller;

import io.geekidea.springbootplus.system.entity.Yidao;
import io.geekidea.springbootplus.system.service.YidaoService;
import io.geekidea.springbootplus.system.web.param.YidaoQueryParam;
import io.geekidea.springbootplus.system.web.vo.YidaoQueryVo;
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
@RequestMapping("/yidao")
@Api(" API")
public class YidaoController extends BaseController {

    @Autowired
    private YidaoService yidaoService;

    /**
    * 添加
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加Yidao对象",notes = "添加",response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Valid @RequestBody Yidao yidao) throws Exception{
        boolean flag = yidaoService.save(yidao);
        return ApiResult.result(flag);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改Yidao对象",notes = "修改",response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Valid @RequestBody Yidao yidao) throws Exception{
        boolean flag = yidaoService.updateById(yidao);
        return ApiResult.result(flag);
    }

    /**
    * 删除
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除Yidao对象",notes = "删除",response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        boolean flag = yidaoService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
    * 获取
    */
    @PostMapping("/info")
    @ApiOperation(value = "获取Yidao对象详情",notes = "查看",response = YidaoQueryVo.class)
    public ApiResult<YidaoQueryVo> getSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        YidaoQueryVo yidaoQueryVo = yidaoService.getYidaoById(idParam.getId());
        return ApiResult.ok(yidaoQueryVo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Yidao分页列表",notes = "分页列表",response = YidaoQueryVo.class)
    public ApiResult<Paging<YidaoQueryVo>> getYidaoPageList(@Valid @RequestBody(required = false) YidaoQueryParam yidaoQueryParam) throws Exception{
        Paging<YidaoQueryVo> paging = yidaoService.getYidaoPageList(yidaoQueryParam);
        return ApiResult.ok(paging);
    }

}

