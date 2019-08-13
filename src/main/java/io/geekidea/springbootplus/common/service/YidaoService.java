package io.geekidea.springbootplus.common.service;

import io.geekidea.springbootplus.common.entity.Yidao;
import io.geekidea.springbootplus.common.service.BaseService;
import io.geekidea.springbootplus.common.web.param.YidaoQueryParam;
import io.geekidea.springbootplus.common.web.vo.YidaoQueryVo;
import io.geekidea.springbootplus.common.web.vo.Paging;

import java.io.Serializable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dodar
 * @since 2019-08-13
 */
public interface YidaoService extends BaseService<Yidao> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    YidaoQueryVo getYidaoById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     * @param yidaoQueryParam
     * @return
     */
    Paging<YidaoQueryVo> getYidaoPageList(YidaoQueryParam yidaoQueryParam) throws Exception;

}
