package com.api.guolo_api.adminMangement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.application.in.LotterieUseCase;
import com.api.guolo_api.adminMangement.domain.model.LotterieDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("lottery")
@AllArgsConstructor
@Slf4j
public class LotteryController {
    private final LotterieUseCase lotterieUseCase;

    @GetMapping("")
    public ResponseEntity<?> getAllLotteries() {
        try{
            return ResponseEntity.ok(lotterieUseCase.fetchAll());
        } catch (Exception e){
//            throw e;
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveLottery(@RequestBody LotterieDto lotterieDto) {
        try{
            return ResponseEntity.ok(lotterieUseCase.save(lotterieDto));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("")
    public ResponseEntity<?> updateLottery(@RequestBody LotterieDto lotterieDto) {
        try{
            return ResponseEntity.ok(lotterieUseCase.update(lotterieDto));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteLottery(@RequestBody LotterieDto lotterieDto) {
        try{
            return ResponseEntity.ok(lotterieUseCase.delete(lotterieDto));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("draw/{id}")
    public ResponseEntity<?> draw(@PathVariable UUID id) {
        try{
            return ResponseEntity.ok(lotterieUseCase.draw(id));
        } catch (Exception e){
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getLottery(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(lotterieUseCase.findById(id));
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
