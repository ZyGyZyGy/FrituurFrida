package be.vdab.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import be.vdab.entities.GastenboekEntry;

public class GastenboekRepository extends AbstractRepository {

    private static final String FIND_ALL = 
	    "select id, naam, datum, bericht "
	    + "from gastenboek "
	    + "order by id desc";
    private static final String CREATE =
	    "insert into gastenboek(naam, datum, bericht) "
	    + "values(?, ?, ?)";
    private final static String DELETE = 
    		"delete from gastenboek "
    		+ "where id in ("; 
    
	public List<GastenboekEntry> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
			List<GastenboekEntry> entries = new ArrayList<>();
			while (resultSet.next()) {
				entries.add(resultSetNaarGastenboekEntry(resultSet));
			}
			return entries;
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}

	public void create(GastenboekEntry entry) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE)) {
			statement.setString(1, entry.getNaam());
			statement.setDate(2, Date.valueOf(entry.getDatum()));
			statement.setString(3, entry.getBericht());
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}

	public GastenboekEntry resultSetNaarGastenboekEntry(ResultSet resultSet) throws SQLException {
		return new GastenboekEntry(resultSet.getLong("id"), resultSet.getString("naam"),
				resultSet.getDate("datum").toLocalDate(), resultSet.getString("bericht"));
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
