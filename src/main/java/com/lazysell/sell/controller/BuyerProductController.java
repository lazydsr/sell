package com.lazysell.sell.controller;

import com.lazysell.sell.pojo.ProductCategory;
import com.lazysell.sell.pojo.ProductInfo;
import com.lazysell.sell.service.ProductCategoryService;
import com.lazysell.sell.service.ProductService;
import com.lazysell.sell.utils.ResultVOUtil;
import com.lazysell.sell.vo.CategoryVO;
import com.lazysell.sell.vo.ProductVO;
import com.lazysell.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BuyerProductController
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.controller
 * Created by Lazy on 2017/11/11 15:01
 * Version: 0.1
 * Info: 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    public ResultVO list() {

        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询上架商品的类目信息
        List<Integer> list = productInfoList.stream().map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(list);
        //拼装数据
        List<CategoryVO> categoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            CategoryVO vo = new CategoryVO();
            vo.setName(productCategory.getCategoryName());
            vo.setType(productCategory.getCategoryType());
            List<ProductVO> foods = new ArrayList<>();
            for (ProductInfo p : productInfoList) {
                if (productCategory.getCategoryType().equals(p.getCategoryType())) {
                    ProductVO pVO = new ProductVO();
                    //BeanUtils.copyProperties(p, pVO);
                    pVO.setId(p.getId());
                    pVO.setName(p.getProductName());
                    pVO.setPrice(p.getProductPrice());
                    pVO.setIcon(p.getProductIcon());
                    pVO.setDescription(p.getProductDesc());
                    foods.add(pVO);
                }
            }
            vo.setFoods(foods);
            categoryVOList.add(vo);
        }




        return ResultVOUtil.success(categoryVOList);
    }
}
