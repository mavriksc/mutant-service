package com.hyla.controller;

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
import com.hyla.dto.MutantCURequest;
import com.hyla.dto.DisasterCURequest;
import com.hyla.dto.DisasterListResponse;
import com.hyla.dto.DisasterResponse;
import com.hyla.dto.MutantListResponse;
import com.hyla.dto.SquadListResponse;
import com.hyla.dto.SquadResponse;
import com.hyla.dto.SquadCURequest;
import com.hyla.model.Disaster;
import com.hyla.model.DisasterState;
import com.hyla.model.Mutant;
import com.hyla.model.Squad;

@RestController
@RequestMapping("/api")
public class MutantController {
    private MutantDao mDao;
    private SquadDao sDao;
    private DisasterDao dDao;
    
    
    @GetMapping("/mutants")
    public MutantListResponse getMutants(){
        return new MutantListResponse(mDao.findAll());
    }   
    @PostMapping("/mutants")
    public MutantResponse createMutant(@RequestBody MutantCURequest mutantCUR){
        Mutant m = new Mutant();
        m.updateFromRequest(mutantCUR);
        m = mDao.save(m);
        return new MutantResponse(m);
    }
    @GetMapping("/mutants/{id}")
    public MutantResponse getMutant(@PathVariable Long id){
        return new MutantResponse(mDao.findOne(id));
    }
//    @DeleteMapping("/mutants/{id}")
//    public void deleteMutant(@PathVariable Long id){
//       if (mDao.exists(id)) {
//           //TODO  remove from squads
//           mDao.delete(id);
//       }       
//    }
    @PutMapping("/mutants/{id}")
    public MutantResponse updateMutant(@PathVariable Long id, @RequestBody MutantCURequest mutantCUR){
        Mutant m = mDao.findOne(id);
        m.updateFromRequest(mutantCUR);
        return new MutantResponse(mDao.save(m));
    }
    
    @GetMapping("/squads")
    public SquadListResponse getSquads(){
        return new SquadListResponse(sDao.findAll());
    }
    @PostMapping("/squads")
    public SquadResponse createSquad(@RequestBody SquadCURequest squadCUR){
        Squad s = new Squad();
        squadCUR.getMutants().forEach(mutantId -> s.getMutants().add(mDao.findOne(mutantId)));
        return new SquadResponse(s);
    }
    @GetMapping("/squads/{id}")
    public SquadResponse getSquad(@PathVariable Long id){
        return new SquadResponse(sDao.findOne(id));
    }
//    @DeleteMapping("/squads/{id}")
//    public void deleteSquad(@PathVariable Long id){
//        if (sDao.exists(id)) {
//            Squad s = sDao.findOne(id);
////            s.getMutants().clear();
////            sDao.save(s);
//            sDao.delete(s);
//        }
//    }
    //make update request type
    @PutMapping("/squads/{id}")
    public SquadResponse updateSquad(@PathVariable Long id, @RequestBody SquadCURequest squadCUR){
        Squad s = sDao.findOne(id);
        s.getMutants().clear();
        squadCUR.getMutants().forEach(mutantId -> s.getMutants().add(mDao.findOne(mutantId)));
        return new SquadResponse(sDao.save(s));
    }
    @GetMapping("/disasters")
    public DisasterListResponse getDisasters(){
        return new DisasterListResponse(dDao.findAll()); 
    }
    @PostMapping("/disasters")
    public DisasterResponse createDisaster(@RequestBody DisasterCURequest disasterCUR){
        Disaster d  = new Disaster(disasterCUR.getName());
        d.getCharacteristics().addAll(disasterCUR.getCharacteristics());
        
        return new DisasterResponse(dDao.save(d)); 
    }
    @GetMapping("/disasters/{id}")
    public DisasterResponse getDisaster(@PathVariable Long id){
        return new DisasterResponse(dDao.findOne(id));
    }
//    @DeleteMapping("/disasters/{id}")
//    public void deleteDisaster(@PathVariable Long id){
//        if (dDao.exists(id)) {
//            Disaster d = dDao.findOne(id);
//            dDao.delete(d);            
//        }
//        
//    }
    //make update request
    @PutMapping("/disasters/{id}")
    public DisasterResponse updateDisaster(@PathVariable Long id, @RequestBody DisasterCURequest disasterCUR){
        Disaster d = dDao.findOne(id);
        if (disasterCUR.getSquadId()!= null && d.getSquad() == null) {
            d.setSquad(sDao.findOne(disasterCUR.getSquadId()));
            d.setState(DisasterState.ASSIGNED);
        }
        if (d.getState() == DisasterState.ASSIGNED && disasterCUR.getState() == DisasterState.DEBREIFED) {
            
        }
        
        return new DisasterResponse(dDao.save(d));
    }
    
    public MutantController(MutantDao mDao, SquadDao sDao, DisasterDao dDao){
        this.mDao = mDao;
        this.sDao = sDao;
        this.dDao = dDao;        
    }
}
