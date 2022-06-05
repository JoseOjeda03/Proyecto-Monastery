package modelo;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
// atributos 
	protected int id;
	protected String name;
	protected String curso;
	protected String año;

//constructor vacío
	public User() {
	}

	public User(String name, String curso, String año) {
		this.name = name;
		this.curso = curso;
		this.año = año;
	}

	public User(int id, String name, String curso, String año) {
		this.id = id;
		this.name = name;
		this.curso = curso;
		this.año = año;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

}
