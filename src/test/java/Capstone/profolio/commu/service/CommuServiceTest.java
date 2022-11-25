package Capstone.profolio.commu.service;

import Capstone.profolio.commu.dto.CommuDto;
import Capstone.profolio.commu.repository.CommuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommuServiceTest {

    @Autowired
    CommuService commuService;
    @Autowired
    CommuRepository commuRepository;@Test
    void readCommu() {
        List<CommuDto> commus = commuService.readCommu();
        for (CommuDto comm:commus) {
            System.out.println(comm);
        }
        //https://kooremo.tistory.com/entry/Entity-List-To-DTO-List
    }

    @Test
    int createCommu() {
        CommuDto commuDto = new CommuDto();
        commuDto.setCommuContext("Context");
        commuDto.setCommuTitle("Title");
        commuDto.setCommuCode(3);
        commuDto.setUserCode(11);
        commuDto.setCommuShareOption(true);
        commuDto.setCommuCreateDate(LocalDateTime.now());
        commuDto.setUserName("Name");
        System.out.println(commuDto);
        commuService.createCommu(commuDto);
        return commuDto.getCommuCode();

    }
    @Test
    void deleteCommu() {
        int code= createCommu();
        commuService.deleteCommu(code);
    }
}