package argin.io.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPage implements Serializable{
    private Integer currentPage;
    private Integer pageSize;
    private String queryString;
}