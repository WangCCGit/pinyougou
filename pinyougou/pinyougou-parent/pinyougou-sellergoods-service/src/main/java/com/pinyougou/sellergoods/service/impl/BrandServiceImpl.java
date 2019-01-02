package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageEntity;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbAddressExample;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{


    @Autowired
    private TbBrandMapper brandMapper;

    /**
     * 卖家查询所有品牌
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    /**
     * 分页查看
     * @param size
     * @return
     */
    @Override
    public PageEntity findPage(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        Page<TbBrand> list = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageEntity(list.getTotal(),list.getResult());
    }

    @Override
    public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
          brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageEntity findPage2(TbBrand tbBrand, int pageNum, int pagesize) {
        PageHelper.startPage(pageNum,pagesize);
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand!=null){
            if (tbBrand.getName()!=null&&tbBrand.getName().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if (tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0){
                criteria.andFirstCharLike(tbBrand.getFirstChar());
            }
        }
        Page<TbBrand> tbBrands = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageEntity(tbBrands.getTotal(),tbBrands.getResult());
    }
}
