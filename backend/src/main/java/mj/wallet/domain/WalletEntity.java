package mj.wallet.domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity @Table(name = "wallet")
public class WalletEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "balance", nullable = false)
    private float balance;

    protected WalletEntity(){
    }

    public WalletEntity( String name, float balance ){
        this.name = name;
        this.balance = balance;
    }

}
