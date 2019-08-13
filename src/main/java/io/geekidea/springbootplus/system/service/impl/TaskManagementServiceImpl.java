package io.geekidea.springbootplus.system.service.impl;

import io.geekidea.springbootplus.system.entity.TaskManagement;
import io.geekidea.springbootplus.system.mapper.TaskManagementMapper;
import io.geekidea.springbootplus.system.service.TaskManagementService;
import io.geekidea.springbootplus.system.web.param.TaskManagementQueryParam;
import io.geekidea.springbootplus.system.web.vo.TaskManagementQueryVo;
import io.geekidea.springbootplus.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.common.web.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dodar
 * @since 2019-08-13
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskManagementServiceImpl extends BaseServiceImpl<TaskManagementMapper, TaskManagement> implements TaskManagementService {

    @Autowired
    private TaskManagementMapper taskManagementMapper;

    @Override
    public TaskManagementQueryVo getTaskManagementById(Serializable id) throws Exception{
        return taskManagementMapper.getTaskManagementById(id);
    }

    @Override
    public Paging<TaskManagementQueryVo> getTaskManagementPageList(TaskManagementQueryParam taskManagementQueryParam) throws Exception{
        Page page = setPageParam(taskManagementQueryParam,OrderItem.desc("create_time"));
        IPage<TaskManagementQueryVo> iPage = taskManagementMapper.getTaskManagementPageList(page,taskManagementQueryParam);
        return new Paging(iPage);
    }

}
