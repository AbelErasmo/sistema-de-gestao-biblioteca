import java.io.Serializable;

public class DataDevolucao extends Biblioteca implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dataDevolucao;
	private String dataEmprestimo;
	private String livroEmprestado;
	
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public String getLivroEmprestado() {
		return livroEmprestado;
	}
	
	public void setLivroEmprestado(String livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}	
}
