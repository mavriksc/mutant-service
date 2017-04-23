package com.hyla;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hyla.dao.DisasterDao;
import com.hyla.dao.MutantDao;
import com.hyla.dao.SquadDao;
import com.hyla.model.Ability;
import com.hyla.model.Characteristic;
import com.hyla.model.Disaster;
import com.hyla.model.DisasterState;
import com.hyla.model.Mutant;
import com.hyla.model.Squad;

@SpringBootApplication
public class MutantServiceApplication {
    @Bean
    CommandLineRunner commandLineRunner(MutantDao mDao,SquadDao sDao, DisasterDao dDao){
        return strings->{
            if (mDao.count() == 0) {
                Mutant m = new Mutant("Wolverine");              
                m.setAbilities(new HashSet<Ability>());
                m.getAbilities().add(new Ability("Regeneration"));
                m.getAbilities().add(new Ability("Sense of Smell"));
                m.getAbilities().add(new Ability("Claws"));
                m.getAbilities().add(new Ability("Adimantium Clad skeleton"));
                mDao.save(m);
                m = new Mutant("Jean Grey");              
                m.setAbilities(new HashSet<Ability>());
                m.getAbilities().add(new Ability("Telepathy"));
                m.getAbilities().add(new Ability("Telekenesis"));
                mDao.save(m);                
            }
            
            if (sDao.count() == 0) {
                Squad s = new Squad();
                s.getMutants().addAll(mDao.findAll());
                sDao.save(s);
            }
            if (dDao.count() == 0) {
                Disaster d = new Disaster("Magneto escaped");
                d.getCharacteristics().add(new Characteristic("Villian can control metal"));
                d.getCharacteristics().add(new Characteristic("Villian's helmet blocks telepathy"));
                dDao.save(d);
            }
            if (dDao.count() == 1) {
                Disaster d = new Disaster("Dam collapse");
                d.getCharacteristics().add(new Characteristic("Water rushing towards populated area"));
                d.getCharacteristics().add(new Characteristic("People whitness the event"));
                d.getCharacteristics().add(new Characteristic("Many small trees and bushes near chokepoint"));
                d.setSquad(sDao.findOne(1L));             
                d.setDisasterAvoided(true);
                d.setState(DisasterState.DEBREIFED);
                dDao.save(d);
            }
            
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(MutantServiceApplication.class, args);
	}
}
