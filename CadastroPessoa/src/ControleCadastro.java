import java.util.ArrayList;

//Aluno : Victor Mello Floriano
//Disciplina de Fundamentos de Programação de Sistemas de Informação
//Primeiro trabalho
//import com.sun.glass.events.ViewEvent;

public class ControleCadastro 
{

	private ViewCadastro viewCadastro;
	ArrayList<Pessoa> agenda;
	private int contadorAgenda;
	
	public ControleCadastro()
	{
		viewCadastro  = new ViewCadastro();
		agenda = new ArrayList<>();
		contadorAgenda = 0;
		trataMenu();
	}
	
	private void trataMenu()
	{
		Boolean continuar = true;
		do {
			
			String opc = viewCadastro.mostraMenu();
			
		switch (opc) 
		{
		    case "1":
			    //agenda[contadorAgenda++] = viewCadastro.inserir();
		    	agenda.add(viewCadastro.inserir());
			    break;
			case "2":
				viewCadastro.Listar(agenda);
				break;
			case "3":
				viewCadastro.Alterar(agenda);
				break;
			case "4":
				viewCadastro.Pesquisar(agenda);
				break;
			case "5":
				viewCadastro.Remover(agenda);
				break;
			case "6":
				System.out.println("sair do menu");
				continuar = false;
				break;
		default:
			System.out.println("Opção Invalida");
			break;
		}
		
		} while (continuar);
	}
}
