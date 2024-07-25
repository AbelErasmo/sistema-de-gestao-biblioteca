import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;


public class SistemaDeGestao extends Biblioteca {

	private static final long serialVersionUID = 1L;
	private static final String NOME_ARQUIVO = "biblioteca.ser";

    public static void main(String[] args) {
    	SistemaDeGestao b = new SistemaDeGestao();
    	b.corre();
    } 
     
	public  void corre() {
    	 Biblioteca biblioteca;

         // Verificar se o arquivo ja existe
         if (arquivoExiste()) {
             biblioteca = carregarBiblioteca();
         } else {
             biblioteca = new Biblioteca();
         }
         try { 
        	 while (true) {
            	 exibirMenu();
                 String opcao1 = JOptionPane.showInputDialog("Digite a opcao desejada: ");
                 int opcao = Integer.parseInt(opcao1);
                 switch (opcao) {
                 case 1:
                     String codigo = JOptionPane.showInputDialog("Digite o codigo do estudante:");
                     int code = Integer.parseInt(codigo);
                     String nome = JOptionPane.showInputDialog("Digite o nome do Estudante:");
                     String curso = JOptionPane.showInputDialog("Digite o curso:");
                     String ano = JOptionPane.showInputDialog("Digite o ano que frequenta:");
                     int anoFrequencia = Integer.parseInt(ano);
                     biblioteca.registarEstudante(code, nome, curso, anoFrequencia);
                     JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso!");
                     break;
             	case 2:
                	 biblioteca.consultarEstudante();
                     break;
             	case 3:
             		 String titulo = JOptionPane.showInputDialog("Digite o t�tulo do livro:");
             		 String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
                     biblioteca.adicionarLivro(titulo, autor);
                     JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                     break;
                 case 4:
                     biblioteca.sultarAcervo();
                     break;
                 case 5:
                	 String codigoAluno = JOptionPane.showInputDialog("Digite o codigo de estudante: ");
                	 int coder = Integer.parseInt(codigoAluno);
                	 String livroEmprestimo = JOptionPane.showInputDialog("Digite o titulo do livro que deseja emprestar:");
                     biblioteca.realizarEmprestimo(livroEmprestimo, coder);
                     break;
                 case 6:
                	 String codig = JOptionPane.showInputDialog("Digite o codigo de estudante: ");
                	 int cod = Integer.parseInt(codig);
                	 String livroDevolucao = JOptionPane.showInputDialog("Digite o titulo do livro que deseja devolver:");
                     biblioteca.realizarDevolucao(livroDevolucao, cod);
                     break;
                 case 0:
                	 JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                	 System.exit(1);
                     break;
                 default:
                	 JOptionPane.showMessageDialog(null, "Opcao invalida. Digite novamente.", "Erro", opcao);
                     break;
                 	}
               } 
         } catch (IllegalArgumentException argumentException) {
        	 JOptionPane.showMessageDialog(null, "Opcao invalida. Digite OK para fechar o sistema", "Erro", 0);
        	 System.exit(1);
         } 
        	 
     }

    private Biblioteca carregarBiblioteca() {
		return null;
	}
    
	protected static void exibirMenu() {
        System.out.println("===== Sistema de Gestao da Biblioteca =====");
        System.out.println("1. Registrar Estudante");
        System.out.println("2. Consultar Estudante");
        System.out.println("3. Adicionar Livro");
        System.out.println("4. Consultar Livros");
        System.out.println("5. Realizar Emprestimo");
        System.out.println("6. Realizar Devolucao");
        System.out.println("0. Sair");
    }
	
	private static boolean arquivoExiste() {
        File arquivo = new File(NOME_ARQUIVO);
        return arquivo.exists();
    }
	
    private static Biblioteca salvarBiblioteca(Biblioteca biblioteca) {
        try {
            FileOutputStream fileOut = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
           
        try {
            FileInputStream fileIn = new FileInputStream(NOME_ARQUIVO);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            biblioteca = (Biblioteca) objIn.readObject();
            objIn.close();
            fileIn.close();
            System.out.println("Biblioteca carregada com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar a biblioteca: " + e.getMessage());
        }
        return biblioteca;
        
        } catch(IOException e) {
        	System.out.println("Erro ao carregar a biblioteca: " + e.getMessage());
        } return biblioteca;
    }
}
