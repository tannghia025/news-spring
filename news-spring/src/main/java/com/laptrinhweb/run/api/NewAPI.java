package com.laptrinhweb.run.api;

import com.laptrinhweb.run.api.output.NewOutPut;
import com.laptrinhweb.run.dto.NewDTO;
import com.laptrinhweb.run.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
public class NewAPI {

    @Autowired
    INewService newService;

    @GetMapping(value = "/api/new")
    public NewOutPut showNew(@RequestParam(value = "page", required = false) Integer page,@RequestParam(value = "limit",required = false) Integer limit){
        NewOutPut newOutPut = new NewOutPut();
        if(page!=null && limit!=null){
            newOutPut.setPage(page);
            Pageable pageable = new PageRequest(page-1,limit);
            newOutPut.setListResult(newService.findAll(pageable));
            newOutPut.setTotalPage((int) Math.ceil((double)(newService.totalItem())/limit));
        }else{
                newOutPut.setListResult(newService.findAll());
        }
        return newOutPut;
    }


    @PostMapping(value = "/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {
        return newService.save(newDTO);
    }

    @PutMapping(value = "/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO) {
        return newService.save(newDTO);
    }

    @DeleteMapping(value = "/api/new")
    public void delete(@RequestBody long[] ids) {
        newService.delete(ids);
    }


}
