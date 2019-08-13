package io.geekidea.springbootplus.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.geekidea.springbootplus.system.entity.TaskManagement;
import io.geekidea.springbootplus.system.web.param.TaskManagementQueryParam;
import io.geekidea.springbootplus.system.web.vo.TaskManagementQueryVo;
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
public interface TaskManagementMapper extends BaseMapper<TaskManagement> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    TaskManagementQueryVo getTaskManagementById(Serializable id);

    /**
     * 获取分页对象
     * @param page
     * @param taskManagementQueryParam
     * @return
     */
    IPage<TaskManagementQueryVo> getTaskManagementPageList(@Param("page") Page page, @Param("param") TaskManagementQueryParam taskManagementQueryParam);

}
