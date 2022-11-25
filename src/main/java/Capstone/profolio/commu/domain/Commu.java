package Capstone.profolio.commu.domain;

import Capstone.profolio.commu.dto.CommuDto;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "community")
public class Commu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commuCode")
    private int commuCode;

    @Column(name = "userCode")
    @NonNull
    private int userCode;
    @Column(name = "commuTitle")
    @NonNull
    private String commuTitle;
    @Column(name = "commuContext")
    @NonNull
    private String commuContext;
    @Column(name = "commuShareOption")
    @NonNull
    private boolean commuShareOption;
    @Column(name = "userName")
    @NonNull
    private String userName;
    @Column(name = "commuCreateDate")
    private LocalDateTime commuCreateDate;
    @Column(name = "commuUpdateDate")
    private LocalDateTime commuUpdateDate;
    @Column(name = "commuDeleteDate")
    private LocalDateTime commuDeleteDate;
    @Column(name = "commuView",columnDefinition = "int default 0")
    @NonNull
    private int commuView;
    @Column(name = "commuLike",columnDefinition = "int default 0")
    @NonNull
    private int commuLike;

    @Builder
    public Commu(int commuCode, int userCode, String commuTitle, String commuContext, boolean commuShareOption, String userName, LocalDateTime commuCreateDate, LocalDateTime commuUpdateDate, LocalDateTime commuDeleteDate, int commuView, int commuLike) {
        this.commuCode = commuCode;
        this.userCode = userCode;
        this.commuTitle = commuTitle;
        this.commuContext = commuContext;
        this.commuShareOption = commuShareOption;
        this.userName = userName;
        this.commuCreateDate = commuCreateDate;
        this.commuUpdateDate = commuUpdateDate;
        this.commuDeleteDate = commuDeleteDate;
        this.commuView = commuView;
        this.commuLike = commuLike;
    }

    @Override
    public String toString() {
        return "Commu{" +
                "commuCode=" + commuCode +
                ", userCode=" + userCode +
                ", commuTitle='" + commuTitle + '\'' +
                ", commuContext='" + commuContext + '\'' +
                ", commuShareOption=" + commuShareOption +
                ", userName='" + userName + '\'' +
                ", commuCreateDate=" + commuCreateDate +
                ", commuUpdateDate=" + commuUpdateDate +
                ", commuDeleteDate=" + commuDeleteDate +
                ", commuView=" + commuView +
                ", commuLike=" + commuLike +
                '}';
    }

    public CommuDto entityToDTO() {
        return CommuDto.builder().commuCode(commuCode).userCode(userCode).commuTitle(commuTitle).commuContext(commuContext).
                commuShareOption(commuShareOption).commuLike(commuLike).commuCreateDate(commuCreateDate).commuDeleteDate(commuDeleteDate).
                commuView(commuView).commuUpdateDate(commuUpdateDate).commuCode(commuCode).userName(userName).build();

    }
}
