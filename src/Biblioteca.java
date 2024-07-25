import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

class Biblioteca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Livro> acervo;
	private List<Cadastro> autenticar;

    public Biblioteca() { 
        acervo = new ArrayList<Livro>();
        autenticar = new ArrayList<Cadastro>();
    }
      
    public void adicionarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        acervo.add(livro);
    }
    
    public void registarEstudante(int codigoEstudante, String nomeEstudante, String curso, int anoFrequencia) {
    	Cadastro registrar = new Cadastro(codigoEstudante, nomeEstudante, curso, anoFrequencia);
    	autenticar.add(registrar);
    }
   
    public void consultarEstudante() {
    	if (autenticar.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Usuario nao encontrado! Porfavor cadastre-se para verificar dados!");
    		System.out.println("");
    	} else {
    		 System.out.println("Dados do Usuario:");
    		 for (Cadastro registrar : autenticar) {
    			 System.out.println("Codigo do Estudante: " + registrar.getCodigoEstudante());
    			 System.out.println("Nome do Estudante: " + registrar.getNomeEstudante());
    			 System.out.println("Curso: " + registrar.getCurso());
    			 System.out.println("Ano de Frequencia: " + registrar.getAnoDeFrequencia());
    			 System.out.println("-----------------------------");
    		 }
    	}
    }
    
    public void sultarAcervo() {
        if (acervo.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "A biblioteca esta vazia.");
            System.out.println("");
        } else {
            System.out.println("Acervo da Biblioteca:");
            for (Livro livro : acervo) {
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Disponivel: " + (livro.isDisponivel() ? "Sim" : "N�o"));
                System.out.println("-----------------------------");
            }
        }
    }
    
  
    public void realizarEmprestimo(String titulo, int codigoEstudante) {
    	Livro livro = buscarLivro(titulo);
    	Cadastro estudante = procurarEstudante(codigoEstudante);
        if (estudante.getCodigoEstudante() == codigoEstudante) {
            if (livro != null && livro.isDisponivel()) {
                livro.setDisponivel(false);
                JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!");
                System.out.println("");
            } else {
            	JOptionPane.showMessageDialog(null, "Livro nao disponivel para emprestimo");
                System.out.println("");
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Codigo nao encontrado. Tente novamente");
        	System.out.println("");
        }
    }

    public void realizarDevolucao(String titulo, int codigoEstudante) {
    	Cadastro estudante = procurarEstudante(codigoEstudante);
    	Livro livro = buscarLivro(titulo);
    	 if (estudante.getCodigoEstudante() == codigoEstudante) {
    		 if (livro != null && !livro.isDisponivel()) {
    	            livro.setDisponivel(true);
    	            JOptionPane.showMessageDialog(null, "Devolucao realizada com sucesso!");
    	            System.out.println("");
    	        } else {
    	        	JOptionPane.showMessageDialog(null, "Livro nao encontrado ou ja devolvido.");
    	            System.out.println("");
    	        }
    	 }
    	
    }
    

    public Livro buscarLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    
	public Cadastro procurarEstudante(int codigoEstudante) {
    	for (Cadastro estudante : autenticar) {
            if (estudante.getCodigoEstudante() == codigoEstudante) {
                return estudante;
            }
        }
    	return null;
    }
}