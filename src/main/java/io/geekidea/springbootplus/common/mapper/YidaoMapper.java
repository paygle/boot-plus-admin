package io.geekidea.springbootplus.common.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.geekidea.springbootplus.common.entity.Yidao;
import io.geekidea.springbootplus.common.web.param.YidaoQueryParam;
import io.geekidea.springbootplus.common.web.vo.YidaoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dodar
 * @since 2019-08-13
 */
@Repository
public interface YidaoMapper extends BaseMapper<Yidao> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    YidaoQueryVo getYidaoById(Serializable id);

    /**
     * 获取分页对象
     * @param page
     * @param yidaoQueryParam
     * @return
     */
    IPage<YidaoQueryVo> getYidaoPageList(@Param("page") Page page, @Param("param") YidaoQueryParam yidaoQueryParam);

}
