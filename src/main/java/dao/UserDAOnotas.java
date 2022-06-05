package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Notas;

public class UserDAOnotas {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "joseojeda";

	private static final String INSERT_NOTAS_SQL = "INSERT INTO notas" + " (nota1, nota2, nota3 , promedio ,id_estudiante) VALUES "
			+ " (?, ?, ?,?,?);";
	private static final String SELECT_NOTAS_BY_ID = "select id_estudiante,nota1,nota2,nota3,promedio from notas where id_estudiante =?";
	private static final String SELECT_ALL_NOTAS = "select * from notas";
	private static final String DELETE_NOTAS_SQL = "delete from notas where id_estudiante = ?;";
	private static final String UPDATE_NOTAS_SQL = "update notas set nota1 =?,nota2= ?, nota3 =? ,promedio =? where id_estudiante = ?;";

	public UserDAOnotas() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
//registra el driver de conexión para la base de datos
//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertNotas(Notas notas) throws SQLException {
		System.out.println(INSERT_NOTAS_SQL);

// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto conexion
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTAS_SQL)) {
			preparedStatement.setFloat(1, notas.getNota1());
			preparedStatement.setFloat(2, notas.getNota2());
			preparedStatement.setFloat(3, notas.getNota3());
			preparedStatement.setFloat(4, notas.getPromedio());
			preparedStatement.setInt(5, notas.getId_estudiante());
			System.out.println(preparedStatement);
// Ejecuta la consulta 
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public Notas selectNotas(int id) {
		Notas notas = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto

				PreparedStatement preparedStatement =

						connection.prepareStatement(SELECT_NOTAS_BY_ID);) {
			preparedStatement.setInt(1, id);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				float nota1 = rs.getFloat("nota1");
				float nota2 = rs.getFloat("nota2");
				float nota3 = rs.getFloat("nota3");
				float promedio = rs.getFloat("promedio");
				System.out.println(id);
				notas = new Notas(nota1, nota2, nota3,promedio, id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return notas;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<Notas> selectAllNotas() {
//crea el array para mostrar los resultados 
		List<Notas> notas = new ArrayList<>();
//Conecta con la bd
	
		try (Connection connection = getConnection();
//Prepara la consulta sql 
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTAS);) {
System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				float nota1 = rs.getFloat("nota1");
				float nota2 = rs.getFloat("nota2");
				float nota3 = rs.getFloat("nota3");
				float promedio = rs.getFloat("promedio");
				int id_estudiante = rs.getInt("id_estudiante");
			
				notas.add(new Notas(nota1,nota2,nota3,promedio,id_estudiante));
				System.out.println(notas);
			}
		} catch (SQLException e) {
			printSQLException(e);
			System.out.println("no funciona");
		}

		return notas;
	}

//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteNota(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NOTAS_SQL);) {

			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

//METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateNotas(Notas notas) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NOTAS_SQL);) {
			statement.setFloat(1, notas.getNota1());
			statement.setFloat(2, notas.getNota2());
			statement.setFloat(3, notas.getNota3());
			statement.setFloat(4, notas.getPromedio());
			statement.setInt(5, notas.getId_estudiante());
	
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException)

				e).getSQLState());

				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();

				}
			}
		}
	}
}
