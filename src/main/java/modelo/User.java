package modelo;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
// atributos 
	protected int id;
	protected String name;
	protected String curso;
	protected String a�o;

//constructor vac�o
	public User() {
	}

	public User(String name, String curso, String a�o) {
		this.name = name;
		this.curso = curso;
		this.a�o = a�o;
	}

	public User(int id, String name, String curso, String a�o) {
		this.id = id;
		this.name = name;
		this.curso = curso;
		this.a�o = a�o;
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

	public String getA�o() {
		return a�o;
	}

	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

}
