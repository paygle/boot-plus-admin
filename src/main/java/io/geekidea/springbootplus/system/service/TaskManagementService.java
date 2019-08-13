package io.geekidea.springbootplus.system.service;

import io.geekidea.springbootplus.system.entity.TaskManagement;
import io.geekidea.springbootplus.common.service.BaseService;
import io.geekidea.springbootplus.system.web.param.TaskManagementQueryParam;
import io.geekidea.springbootplus.system.web.vo.TaskManagementQueryVo;
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
public interface TaskManagementService extends BaseService<TaskManagement> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    TaskManagementQueryVo getTaskManagementById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     * @param taskManagementQueryParam
     * @return
     */
    Paging<TaskManagementQueryVo> getTaskManagementPageList(TaskManagementQueryParam taskManagementQueryParam) throws Exception;

}
