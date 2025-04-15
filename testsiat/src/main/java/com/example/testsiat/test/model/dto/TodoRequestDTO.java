package model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TodoRequestDTO{
    private String  title;
    private String  content;
    private String  startDate; // 원래는 삭제
    private String  endDate; // 원래는 삭제
    private String status;
    private int     priority;
    // private int     sequence;
}