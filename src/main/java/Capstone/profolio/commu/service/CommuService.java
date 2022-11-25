package Capstone.profolio.commu.service;

import Capstone.profolio.commu.domain.Commu;
import Capstone.profolio.commu.dto.CommuDto;
import Capstone.profolio.commu.repository.CommuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommuService {



    private final CommuRepository commuRepository;


    public List<CommuDto> readCommu() {
        List<Commu> commus = commuRepository.findAll();
        List<CommuDto> commuDtos = commuRepository.findAll().stream().map(Commu::entityToDTO).collect(Collectors.toList());

        return commuDtos;
    }

    public int createCommu(CommuDto commuDto) {

        Commu commu = commuDto.toEntity();
        System.out.println("toEntity()"+commu);
        commuRepository.save(commu);
        return commu.getCommuCode();
    }

    public int updateCommu(int code,CommuDto commuDto) {
        Optional<Commu> commu=commuRepository.findById(code);
        commuDto.setCommuCode(commu.get().getCommuCode());
        if (commu.isPresent()){
            commuRepository.save(commuDto.toEntity());
            return commu.get().getCommuCode();
        }else{
            return 0;
        }
    }

    public int deleteCommu(int code) {
        Optional<Commu> commu=commuRepository.findById(code);
        if (commu.isPresent()){
            commuRepository.deleteById(code);
            return commu.get().getCommuCode();
        }else{
            return 0;
        }
    }


}
