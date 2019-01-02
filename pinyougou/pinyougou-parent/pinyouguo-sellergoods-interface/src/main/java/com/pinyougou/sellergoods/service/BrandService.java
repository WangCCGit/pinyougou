package com.pinyougou.sellergoods.service;


import com.pinyougou.entity.PageEntity;
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

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageEntity findPage(int page,int size);

    /**
     *添加品牌
     */
    void add(TbBrand tbBrand);

    /**
     * 查询出来再修改
     */
    TbBrand findOne(long id);
    /**
     * 根据查询出来的修改
     */
    void update(TbBrand tbBrand);

    /**
     * 批量删除
     */
    void delete(Long[] ids);

    /**
     * 模糊分页
     * @param tbBrand
     * @param pageNum 当前页码
     * @param pagesize 每页显示条数
     * @return
     */
     PageEntity findPage2(TbBrand tbBrand,int pageNum,int pagesize);
}
