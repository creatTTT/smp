package com.tu.demo_s_mp.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tu.demo_s_mp.entity.Address;
import com.tu.demo_s_mp.mapper.AddressMapper;
import com.tu.demo_s_mp.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
