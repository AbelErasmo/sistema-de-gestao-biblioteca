import java.io.Serializable;

public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int codigoEstudante;
	private String nomeEstudante;
	private String curso;
	private int anoDeFrequencia;
	private boolean disponivel;
	
	public Cadastro(int codigoEstudante, String nomeEstudante, String curso, int anoDeFrequencia) {
		this.codigoEstudante = codigoEstudante;
		this.nomeEstudante = nomeEstudante;
		this.curso = curso;
		this.anoDeFrequencia = anoDeFrequencia;
	}

	public int getCodigoEstudante() {
		return codigoEstudante;
	}

	public void setCodigoEstudante(int codigoEstudante) {
		this.codigoEstudante = codigoEstudante;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public int getAnoDeFrequencia() {
		return anoDeFrequencia;
	}
	
	public void setAnoDeFrequencia(int anoDeFrequencia) {
		this.anoDeFrequencia = anoDeFrequencia;
	}

	public String getNomeEstudante() {
		return nomeEstudante;
	}

	public void setNomeEstudante(String nomeEstudante) {
		this.nomeEstudante = nomeEstudante;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
}
