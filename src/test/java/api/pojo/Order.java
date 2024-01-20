package api.pojo;

import java.util.List;

public class Order {
    public Long id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public List<String> status;
    public Boolean complete;
}
