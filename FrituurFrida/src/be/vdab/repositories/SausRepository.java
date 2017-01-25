package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import be.vdab.entities.Saus;

public class SausRepository extends AbstractRepository{

//    private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();

    private static final String FIND_ALL =  
	    "select sauzen.id, sauzen.naam as sausnaam," + 
	    " ingredienten.naam as ingredientnaam" + 
	    " from sauzen left join sauzeningredienten" + 
	    " on sauzen.id=sauzeningredienten.sausid" + 
	    " left join ingredienten " + 
	    " on sauzeningredienten.ingredientid=ingredienten.id" + 
	    " order by sauzen.naam"; 
	  private static final String FIND_BY_INGREDIENT = 
	    "select sauzen.id, sauzen.naam as sausnaam, ingredienten.naam" + 
	    " from sauzen inner join sauzeningredienten " +  
	    " on sauzen.id=sauzeningredienten.sausid" + 
	    " inner join ingredienten" + 
	    " on sauzeningredienten.ingredientid=ingredienten.id" + 
	    " where ingredienten.naam like ?" + 
	    " order by sauzen.naam"; 
	  private static final String DELETE = "delete from sauzen where id in ("; 
    
//    static {
//	SAUZEN.put(5L, new Saus(
//		5L, "cocktail", Arrays.asList(
//		"room", "ketchup", "paprikapoeder", "sherry", "cognac",
//		"gembersiroop", "citroensap", "peper", "zout" )));
//	SAUZEN.put(12L, new Saus(
//		12L, "mayonaise", Arrays.asList(
//		"olie", "eidooiers", "azijn", "citroensap", "mosterd" )));
//	SAUZEN.put(18L, new Saus(
//		18L, "mosterd", Arrays.asList(
//		"mosterdzaden", "azijn", "water", "zout", "suiker",
//		"peper", "mierikswortel", "rozemarijn", "lavendel" )));
//	SAUZEN.put(23L, new Saus(
//		23L, "tartare", Arrays.asList(
//		"ei", "peterselie", "gehakte", "uitjes", "sjalotjes",
//		"augurk", "kappertjes", "bieslook")));
//	SAUZEN.put(31L, new Saus(
//		31L, "vinaigrette", Arrays.asList(
//		"olijfolie", "wijnazijn", "zout", "peper", "tuinkruiden", "moster", "knoflook")));
//    }   
    
//    public Optional<Saus> read(long id) {
//	Saus saus = SAUZEN.get(id);
//	return saus == null ? Optional.empty() : Optional.of(saus);
//    }
//
//    
//    public int size() {
//	return SAUZEN.size();
//    }
    
    public List<Saus> findAll() {
	try (Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
	    List<Saus> sauzen = new ArrayList<>();
	    for (long vorigeId = 0; resultSet.next();) {
		long id = resultSet.getLong("id");
		if (id != vorigeId) {
		    sauzen.add(resultSetRijNaarSausZonderIngredienten(resultSet));
		    vorigeId = id;
		}
		sauzen.get(sauzen.size() - 1).addIngredient(resultSet.getString("ingredientnaam"));
	    }
	    return sauzen;
	} catch (SQLException ex) {
	    throw new RepositoryException(ex);
	}
    }

    public List<Saus> findByIngredient(String ingredient) {
	try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(FIND_BY_INGREDIENT)) {
	    statement.setString(1, '%' + ingredient + '%');
	    List<Saus> sauzen = new ArrayList<>();
	    try (ResultSet resultSet = statement.executeQuery()) {
		while (resultSet.next()) {
		    sauzen.add(resultSetRijNaarSausZonderIngredienten(resultSet));
		}
		return sauzen;
	    }
	} catch (SQLException ex) {
	    throw new RepositoryException(ex);
	}
    }

    private Saus resultSetRijNaarSausZonderIngredienten(ResultSet resultSet) throws SQLException {
	return new Saus(resultSet.getLong("id"), resultSet.getString("sausnaam"), new ArrayList<String>());
    }

    public void delete(Set<Long> ids) {
	StringBuilder sql = new StringBuilder(DELETE);
	ids.stream().forEach(id -> sql.append("?,"));
	sql.deleteCharAt(sql.length() - 1);
	sql.append(')');
	try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.toString())) {
	    int index = 1;
	    for (long id : ids) {
		statement.setLong(index++, id);
	    }
	    statement.executeUpdate();
	} catch (SQLException ex) {
	    throw new RepositoryException(ex);
	}
    }
    
}






















