package com.tu.demo_s_mp.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tu.demo_s_mp.entity.Goods;
import com.tu.demo_s_mp.mapper.GoodsMapper;
import com.tu.demo_s_mp.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tu
 * @since 2020-06-05
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
