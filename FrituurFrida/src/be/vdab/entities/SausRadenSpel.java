package be.vdab.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.vdab.repositories.SausRepository;

public class SausRadenSpel implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final SausRepository sausRepository = new SausRepository();
    private final Saus saus;

    public SausRadenSpel() {
	int indexSaus = new Random().nextInt(sausRepository.size());
	List<Saus> sauzenLijst = new ArrayList<>(sausRepository.findAll());
	saus = sauzenLijst.get(indexSaus);
    }

    public Saus getSaus() {
        return saus;
    }
    
}
