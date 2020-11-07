package mj.wallet.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import mj.wallet.domain.WalletEntity;
import mj.wallet.model.WalletBody;
import mj.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@Controller
@CrossOrigin
public class WalletApiController{

    @Autowired WalletService walletService;

    @ApiOperation(value = "Create Wallet")
    @PostMapping(value = "/wallet")
    public ResponseEntity<WalletEntity> createWallet(
            @ApiParam(value = "The Wallet to be created", required = true) @Valid @RequestBody WalletBody wallet ){
        log.info( "createWallet called" );
        return new ResponseEntity<>( walletService.createWallet( wallet ), CREATED );
    }

    @ApiOperation(value = "List Wallet objects")
    @GetMapping(value = "/wallets")
    public ResponseEntity<List<WalletEntity>> listWallets(){
        log.info( "getWallets called" );
        return new ResponseEntity<>( walletService.listWallets(), HttpStatus.OK );
    }

    @ApiOperation(value = "Retrieve Wallet by ID")
    @GetMapping(value = "/wallet/{id}")
    public ResponseEntity<Optional<WalletEntity>> retrieveWallet(
            @ApiParam(value = "Identifier of the Wallet", defaultValue = "1", required = true) @PathVariable("id") Integer id ){
        log.info( "getWallet({}) called", id );
        Optional<WalletEntity> wallet = walletService.getWallet( id );
        return ResponseEntity.ok( wallet );
    }

    @ApiOperation(value = "Top-up Wallet")
    @PostMapping(value = "/top-up/{id}/{sum}")
    public ResponseEntity<WalletEntity> topUpWallet(
            @ApiParam(value = "Identifier of the Wallet", defaultValue = "1", required = true) @PathVariable("id") Integer id,
            @ApiParam(value = "Top-up amount", defaultValue = "1", required = true) @PathVariable("sum") float sum ){
        log.info( "topUpWallet called" );
        return ResponseEntity.ok( walletService.topUpWallet( id, sum ) );
    }

    @ApiOperation(value = "Withdraw Wallet")
    @PostMapping(value = "/withdraw/{id}/{sum}")
    public ResponseEntity<WalletEntity> withdrawWallet(
            @ApiParam(value = "Identifier of the Wallet", defaultValue = "1", required = true) @PathVariable("id") Integer id,
            @ApiParam(value = "Top-up amount", defaultValue = "1", required = true) @PathVariable("sum") float sum ){
        log.info( "withdrawWallet called" );
        return ResponseEntity.ok( walletService.withdrawWallet( id, sum ) );
    }

    @DeleteMapping(value = "/wallet/{id}")
    @ApiOperation(value = "Delete Wallet")
    public ResponseEntity<WalletEntity> deleteWallet(
            @ApiParam(value = "walletId", defaultValue = "0", required = true) @PathVariable("id") Integer id
    ){
        log.info( "deleteWallet({}) called", id );
        WalletEntity walletEntity = walletService.deleteWallet( id );
        return ResponseEntity.ok( walletEntity );
    }

}
