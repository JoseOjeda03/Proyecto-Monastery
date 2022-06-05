package modelo;

public class Notas implements java.io.Serializable{


	private static final long serialVersionUID = 1L;

	// atributos 
		protected float nota1;
		protected float nota2;
		protected float nota3;
		protected float promedio;
		protected int id_estudiante;
		
		//constructor vacío
		public Notas() {
			
		}
		public Notas(float nota1, float nota2, float nota3 , float promedio) {
			this.nota1 = nota1; 
			this.nota2 = nota2; 
			this.nota3 = nota3;
			this.promedio = promedio;
		   
			}
		public Notas(float nota1, float nota2, float nota3, float promedio,int id_estudiante) {
			this.nota1 = nota1; 
			this.nota2 = nota2; 
			this.nota3 = nota3;
			this.promedio = promedio;
		    this.id_estudiante= id_estudiante;
			}
		public float getNota1() {
			return nota1;
		}
		public void setNota1(float nota1) {
			this.nota1 = nota1;
		}
		public float getNota2() {
			return nota2;
		}
		public void setNota2(float nota2) {
			this.nota2 = nota2;
		}
		public float getNota3() {
			return nota3;
		}
		public void setNota3(float nota3) {
			this.nota3 = nota3;
		}
		public float getPromedio() {
			return promedio;
		}
		public void setPromedio(float promedio) {
			this.promedio = promedio;
		}
		public int getId_estudiante() {
			return id_estudiante;
		}
		public void setId_estudiante(int id_estudiante) {
			this.id_estudiante = id_estudiante;
		}


		

		
		
}
