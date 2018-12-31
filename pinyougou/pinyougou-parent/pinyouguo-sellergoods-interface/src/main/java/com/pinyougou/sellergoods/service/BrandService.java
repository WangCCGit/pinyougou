package com.pinyougou.sellergoods.service;


import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌服务层接口
 */
public interface BrandService {

    /**
     * 卖家查询所有品牌
     * @return
     */
    public List<TbBrand> findAll();


}
