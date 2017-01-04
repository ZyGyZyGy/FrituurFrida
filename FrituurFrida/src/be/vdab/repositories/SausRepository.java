package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausRepository {

    private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();

    static {
	SAUZEN.put(5L, new Saus(
		5L, "cocktail", Arrays.asList(
		"room", "ketchup", "paprikapoeder", "sherry", "cognac",
		"gembersiroop", "citroensap", "peper", "zout" )));
	SAUZEN.put(12L, new Saus(
		12L, "mayonaise", Arrays.asList(
		"olie", "eidooiers", "azijn", "citroensap", "mosterd" )));
	SAUZEN.put(18L, new Saus(
		18L, "mosterd", Arrays.asList(
		"mosterdzaden", "azijn", "water", "zout", "suiker",
		"peper", "mierikswortel", "rozemarijn", "lavendel" )));
	SAUZEN.put(23L, new Saus(
		23L, "tartare", Arrays.asList(
		"ei", "peterselie", "gehakte", "uitjes", "sjalotjes",
		"augurk", "kappertjes", "bieslook")));
	SAUZEN.put(31L, new Saus(
		31L, "vinaigrette", Arrays.asList(
		"olijfolie", "wijnazijn", "zout", "peper", "tuinkruiden", "moster", "knoflook")));
    }
    
    public List<Saus> findAll() {
	return new ArrayList<>(SAUZEN.values());
    }
    
}
