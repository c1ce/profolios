package Capstone.profolio.commu.controller;

import Capstone.profolio.commu.dto.CommuDto;
import Capstone.profolio.commu.service.CommuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commu")
public class CommuController {

    @Autowired
    private CommuService commuService;

    @GetMapping(value="")
    public List<CommuDto> readCommu(){

        List<CommuDto> commuDto = commuService.readCommu();

        return commuDto;
    }

    @PostMapping(value = "")
    public int createCommu(@RequestBody CommuDto commuDto){
        int result = commuService.createCommu(commuDto);
        return result;
    }
    //https://ayoteralab.tistory.com/entry/Spring-Boot-13-REST-API-3-PUTDELETE-method
    @PutMapping(value="/{code}")
    public int updateCommu(@PathVariable("code") int code,@RequestBody CommuDto commuDto){
        int result = commuService.updateCommu(code,commuDto);
        return result;
    }

    @DeleteMapping(value = "/{code}")
    public int deleteCommu(@PathVariable("code") int code){
        int result = commuService.deleteCommu(code);
        return result;
    }

}
