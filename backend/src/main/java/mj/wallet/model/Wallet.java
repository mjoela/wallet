package mj.wallet.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wallet{
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("balance")
    private float balance = 0f;

}
