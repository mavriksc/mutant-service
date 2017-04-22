package com.hyla.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyla.dao.DisasterDao;
import com.hyla.dao.MutantDao;
import com.hyla.dao.SquadDao;
import com.hyla.dto.MutantResponse;
import com.hyla.dto.MutantResponseList;
import com.hyla.model.Mutant;

@RestController
@RequestMapping("/api")
public class MutantController {
    private MutantDao mDao;
    private SquadDao sDao;
    private DisasterDao dDao;
    
    @GetMapping("/mutants")
    public MutantResponseList getMutants(){
        return new MutantResponseList(mDao.findAll());
    }
    @GetMapping("/mutants/{id}")
    public MutantResponse getMutant(@PathVariable Long id){
        return new MutantResponse(mDao.findOne(id));
    }
    @DeleteMapping("/mutants/{id}")
    public void deleteMutant(@PathVariable Long id){
        Mutant m = mDao.findOne(id);
        mDao.delete(m);
    }
    @PutMapping("/mutants/{id}")
    public MutantResponse updateMutant(@PathVariable Long id,@RequestBody Mutant mutant){
        Mutant m = mDao.findOne(id);
        m.copy(mutant);
        mDao.save(m);
        return new MutantResponse(m);
    }
    @PostMapping("/mutants")
    public MutantResponse createMutant(@RequestBody Mutant m){
        m = mDao.save(m);
        return new MutantResponse(m);
    }

    
    public MutantController(MutantDao mDao, SquadDao sDao, DisasterDao dDao){
        this.mDao = mDao;
        this.sDao = sDao;
        this.dDao = dDao;        
    }
    

}
