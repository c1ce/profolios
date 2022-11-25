package Capstone.profolio.commu.dto;

import Capstone.profolio.commu.domain.Commu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommuDto {

    private int commuCode;
    private int userCode;
    private String commuTitle;
    private String commuContext;
    private boolean commuShareOption;
    private String userName;
    private LocalDateTime commuCreateDate;
    private LocalDateTime commuUpdateDate;
    private LocalDateTime commuDeleteDate;
    private int commuView;
    private int commuLike;

    public Commu toEntity(){
        return Commu.builder().commuCode(commuCode).userCode(userCode).commuTitle(commuTitle).commuContext(commuContext).
                commuShareOption(commuShareOption).commuLike(commuLike).commuCreateDate(commuCreateDate).commuDeleteDate(commuDeleteDate).
                commuView(commuView).commuUpdateDate(commuUpdateDate).commuCode(commuCode).userName(userName).build();
    }
}
