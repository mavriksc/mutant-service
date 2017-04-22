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
import com.hyla.model.Mutant;
import com.hyla.model.Squad;

@SpringBootApplication
public class MutantServiceApplication {
    @Bean
    CommandLineRunner commandLineRunner(MutantDao mDao,SquadDao sDao, DisasterDao dDao){
        return strings->{
            if (mDao.count() == 0) {
                Mutant m1 = new Mutant("Wolverine");              
                m1.setAbilities(new HashSet<Ability>());
                m1.getAbilities().add(new Ability("Regeneration"));
                m1.getAbilities().add(new Ability("Sense of Smell"));
                m1.getAbilities().add(new Ability("Claws"));
                m1.getAbilities().add(new Ability("Adimantium Clad skeleton"));
                mDao.save(m1);
                Mutant m2 = new Mutant("Jean Grey");              
                m2.setAbilities(new HashSet<Ability>());
                m2.getAbilities().add(new Ability("Telepathy"));
                m2.getAbilities().add(new Ability("Telekenesis"));
                mDao.save(m2);                
            }
            if (sDao.count() == 0) {
                Squad s = new Squad();
                s.getMutants().addAll(mDao.findAll());
                sDao.save(s);
            }
            if (dDao.count() == 0) {
                Disaster d = new Disaster("Magneto escaped");
                d.getCharacteristic().add(new Characteristic("Villian can control metal"));
                d.getCharacteristic().add(new Characteristic("Villian's helmet blocks telepathy"));
                dDao.save(d);
            }
            
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(MutantServiceApplication.class, args);
	}
}
