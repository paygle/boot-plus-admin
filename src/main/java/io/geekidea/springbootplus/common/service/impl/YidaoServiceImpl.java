package io.geekidea.springbootplus.common.service.impl;

import io.geekidea.springbootplus.common.entity.Yidao;
import io.geekidea.springbootplus.common.mapper.YidaoMapper;
import io.geekidea.springbootplus.common.service.YidaoService;
import io.geekidea.springbootplus.common.web.param.YidaoQueryParam;
import io.geekidea.springbootplus.common.web.vo.YidaoQueryVo;
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
public class YidaoServiceImpl extends BaseServiceImpl<YidaoMapper, Yidao> implements YidaoService {

    @Autowired
    private YidaoMapper yidaoMapper;

    @Override
    public YidaoQueryVo getYidaoById(Serializable id) throws Exception{
        return yidaoMapper.getYidaoById(id);
    }

    @Override
    public Paging<YidaoQueryVo> getYidaoPageList(YidaoQueryParam yidaoQueryParam) throws Exception{
        Page page = setPageParam(yidaoQueryParam,OrderItem.desc("create_time"));
        IPage<YidaoQueryVo> iPage = yidaoMapper.getYidaoPageList(page,yidaoQueryParam);
        return new Paging(iPage);
    }

}
