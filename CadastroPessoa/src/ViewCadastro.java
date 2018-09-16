import java.util.ArrayList;
import java.util.Scanner;
// Aluno : Victor Mello Floriano
// Disciplina de Fundamentos de Programação de Sistemas de Informação
// Primeiro trabalho
public class ViewCadastro {
	
	private Scanner teclado;

	public ViewCadastro()
	{
		teclado = new Scanner(System.in);
	}

	public String mostraMenu() {
		
		System.out.println("-----MENU------");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Pesquisar");
		System.out.println("5 - Excluir");
		System.out.println("6 - Sair");
		System.out.println("Opção: ");
		return teclado.nextLine();
		
	}

	public Pessoa inserir() 
	{
		Pessoa umaPessoa = new Pessoa();
		System.out.println("Inserir");
		System.out.println("Nome: ");
		umaPessoa.setNome(teclado.nextLine());
		
		System.out.println("Email: ");
		umaPessoa.setEmail(teclado.nextLine());
		
		System.out.println("CPF: ");
		umaPessoa.setCpf(teclado.nextLine());
		
		return umaPessoa;
	}

	public void Listar(ArrayList<Pessoa> agenda) 
	{
		
		System.out.println("\nLISTA DE CADASTRADOS!");
		for (int pos = 0; pos < agenda.size(); pos++)
		{
			System.out.println("ID: " + pos + " - " + agenda.get(pos).getNome() + "\n DADOS: " +  agenda.get(pos).toString());
			System.out.println("\n");
		}
	}

	public void Alterar(ArrayList<Pessoa> agenda) 
	{
		Listar(agenda);
		
		boolean continuar = true;
		int pos = 0;
		int choose = 0;
		//int question = 1;
      do {
			System.out.println("Digite o registro para alteração: ");
		try {
			
			 pos = Integer.parseInt(teclado.nextLine());
			
			if(pos >= 0 && pos < agenda.size())
			{
				continuar = false;
			}
			else 
			{
				System.out.println("Digite um valor válido: ");
			}
			
		} catch (Exception e) {
			
			System.out.println("Valor digitado Invalido!!");
		}
		} while(continuar);
      
      do {

      System.out.println("\n Para alterar Nome - Digite 1 \n Para alterar email - Digite 2 \n Para alterar CRF - Digite 3 "); 
      System.out.println("\nEscolha qual campo voce deseja alterar: "); 
	  choose = Integer.parseInt(teclado.nextLine());
		 
	  if (choose == 1)
	  {
	      System.out.println("Nome (" +  agenda.get(pos).getNome() + "): ");
	      agenda.get(pos).setNome(teclado.nextLine());
	  }
	  else if (choose == 2) 
	  {
	      System.out.println("Email (" +  agenda.get(pos).getEmail() + "): ");
	      agenda.get(pos).setEmail(teclado.nextLine());
	  }
	  else if (choose == 3) 
	  {
	      System.out.println("CPF (" +  agenda.get(pos).getCpf() + "): ");
	      agenda.get(pos).setCpf(teclado.nextLine());
	  }
	  
	  System.out.println("\n Deseja alterar mais um campo? 1 PARA SIM - 2 PARA NÃO");
	  int question = Integer.parseInt(teclado.nextLine());
	  
	  if (question == 1) 
	  {
		 continuar =true;
		 
	  }
      
	  else if(question == 2)
	  {
		  continuar = false;
	  }
  	} while (continuar);

      
	}
	
	public void Pesquisar(ArrayList<Pessoa> agenda)
	{
		System.out.println("1 - Pesquisar por nome\n2 - Pesquisar por e-mail\n3 - pesquisar por CPF");
		System.out.println("\n\nQual critério deverá ser utilizado?");
		String choice = teclado.nextLine();
		String p_nome, p_mail, p_cpf;
		int encontrado = 0;
		int count = 0;
		switch (choice)
		{
			case "1":
				System.out.println("Entre com o nome");
				p_nome = teclado.nextLine();
				
				for (count = 0; count < agenda.size(); count++)
				{
					if(p_nome.equals(agenda.get(count).getNome())) 
					{
						encontrado++;
						System.out.println("posicao : "+count);
						System.out.println("Nome :  " +agenda.get(count).getNome());
						System.out.println("Mail :  " +agenda.get(count).getEmail());
						System.out.println("CPF :  " +agenda.get(count).getCpf());
												
					}
				}
				if (encontrado == 0) {System.out.println("não encontrado");return;}
				System.out.println("total de encontrados : "+encontrado);
				break;
				
								
			case "2":
				
				System.out.println("Entre com o email");
				p_mail = teclado.nextLine();
				
				for (count = 0; count < agenda.size(); count++)
				{
					if(p_mail.equals( agenda.get(count).getEmail()) )
					{
						encontrado++;
						System.out.println("posicao : "+count);
						System.out.println("Nome :  " +agenda.get(count).getNome());
						System.out.println("Mail :  " +agenda.get(count).getEmail());
						System.out.println("CPF :  " +agenda.get(count).getCpf());
												
					}
				}
				
				
				if (encontrado == 0) {System.out.println("não encontrado");return;}
				System.out.println("total de encontrados : "+encontrado);
				break;

				
			case "3": 
				
				System.out.println("Entre com o cpf");
				p_cpf = teclado.nextLine();
				
				for (count = 0; count < agenda.size(); count++)
				{
					if(p_cpf.equals( agenda.get(count).getCpf()) )
					{
						encontrado++;
						System.out.println("posicao : "+count);
						System.out.println("Nome :  " +agenda.get(count).getNome());
						System.out.println("Mail :  " +agenda.get(count).getEmail());
						System.out.println("CPF :  " +agenda.get(count).getCpf());
												
					}
				}
				
				if (encontrado == 0) {System.out.println("não encontrado");return;}
				System.out.println("total de encontrados : "+encontrado);
				break;

		}
		
		
	}
	
	
	public int Remover(ArrayList<Pessoa> agenda)
	{
		int pos;
		Listar(agenda);
		System.out.println("qual elemento vc deseja remover? ");
		pos = Integer.parseInt(teclado.nextLine());
		String sure;
		if ((pos > agenda.size()) || (pos < 0)) {return 0;} // can't remove an element that doesn't exist / não é possível remover um elemento que não exista

		System.out.println("tem certeza?(Y/N)");
		sure = teclado.nextLine();
		if (sure.equals("N") || sure.equals("n")) {return 0;}
		
		agenda.remove(pos);
		return 1;
	}
	


}
