package com.laptrinhweb.run.controller.admin;


import com.laptrinhweb.run.api.output.NewOutPut;
import com.laptrinhweb.run.dto.CategoryDTO;
import com.laptrinhweb.run.dto.NewDTO;
import com.laptrinhweb.run.service.ICategorysServices;
import com.laptrinhweb.run.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewController {

    @Autowired
    INewService newService;

    @Autowired
    ICategorysServices categorysServices;


    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showListNews(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        ModelAndView mav = new ModelAndView("views/admin/news/list");
        NewOutPut newOutPut = new NewOutPut();
        if(page!=null&&limit!=null){
            newOutPut.setPage(page);
            Pageable pageable = new PageRequest(page-1,limit);
            newOutPut.setListResult(newService.findAll(pageable));
            newOutPut.setTotalPage((int) Math.ceil(newService.totalItem()/limit)+1);

        }else{
            newOutPut.setPage(1);
            Pageable pageable = new PageRequest(0,4);
            newOutPut.setListResult(newService.findAll(pageable));
            newOutPut.setTotalPage((int) Math.ceil(newService.totalItem()/4)+1);
        }
        List<CategoryDTO> listCate = categorysServices.findAll();
        mav.addObject("listCate",listCate);
        mav.addObject("newOutPut",newOutPut);
        mav.addObject("modal","news_insert");

        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua",method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id",required = false) Long id){

        ModelAndView mav = new ModelAndView("views/admin/news/edit");
        NewDTO newDTO = newService.findOne(id);
        List<CategoryDTO> listCate = categorysServices.findAll();
        mav.addObject("listCate",listCate);
        mav.addObject("id",id);
        mav.addObject("newOld",newDTO);
        mav.addObject("modal","news_update");
        return mav;
    }


}
