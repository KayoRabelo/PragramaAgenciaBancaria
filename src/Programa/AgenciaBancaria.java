package Programa;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaBancaria {

	
	static ArrayList<Conta> contasBancarias;
	
	public static void main (String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
       int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma opera��o ---" +
    		    		     		   
    	
	        "|   Op��o 1 - Criar conta" +
	        "|   Op��o 2 - Depositar" +
	        "|   Op��o 3 - Sacar"+         
	        "|   Op��o 4 - Transferir" +    
	        "|   Op��o 5 - Listar" +       
	        "|   Op��o 6 - Sair" ));        
	        
	       
	        
	        switch(operacao) {
	        case 1:
	        	criarConta();
	        	break;
	        case 2:
	        	depositar();
	        	break;
	        case 3:
	        	sacar();
	        	break;
	        case 4:
	        	transferir();
	        	break;
	        case 5:
	        	listarContas();
	        	break;
	        case 6:
	        	JOptionPane.showMessageDialog(null, "obrigado por usar nossa agencia");
	     
	        	System.exit(0);
	        	
	        	default:
	        		JOptionPane.showMessageDialog(null, "op��o inv�lida");
	        		operacoes();
	        		
	        	break;
	        }
	        
	        
	        
	        }
	        
	        
	   public static void criarConta() {
		   Pessoa pessoa = new Pessoa(null,null,null);
		   
		   
		   pessoa.setNome(JOptionPane.showInputDialog("Nome:"));
		   pessoa.setCPF(JOptionPane.showInputDialog("CPF:"));
		   pessoa.setEmail(JOptionPane.showInputDialog("Email:"));

	        

	        Conta conta = new Conta(pessoa);

	        contasBancarias.add(conta);
	        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso");

	        operacoes();
	   }
	   
	   private static Conta encontrarConta(int numeroConta) {
		   Conta conta = null;
		   if (contasBancarias.size() > 0) {
			   for(Conta c: contasBancarias) {
				   if(c.getNumeroConta() == numeroConta);
				   conta = c;
			   }
		   }
		   return conta;
	   }
	   public static void depositar() {
		   
		   
		   int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta para dep�sito:"));
		   
		   Conta conta = encontrarConta(numeroConta);
		   
		   if(conta != null) {
			   
			   Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar:"));
			   conta.depositar(valorDeposito);
			   JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso");
			   
			   
		   
		   }else {
			   
			   JOptionPane.showMessageDialog(null, "conta n�o encontrada");
			 
	   }
	   operacoes();
	}
	   public static void sacar() {
		  int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta para saque:"));
		   
		  
		   
		   Conta conta = encontrarConta(numeroConta);
		   
		   if(conta != null) {
			Double valorSaque =  Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar:"));
			   conta.depositar(valorSaque);
			   
		   
		   }else {
		
			   JOptionPane.showMessageDialog(null, "conta n�o encontrada");
	   }
	   operacoes();
	   }
	   public static void transferir() {
		   int numeroContaRemetente =
		   Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta do remetente:"));
		   
		   Conta contaRemetente = encontrarConta(numeroContaRemetente);
		   
		   
		   if(contaRemetente != null) {
			   int numeroContaDestinatario =
					   Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta do Destinatario:"));
			   
			   
			   Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			   
			   if(contaDestinatario != null) {
				   Double valor =  Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar:"));
				   
				   contaRemetente.transferir(contaDestinatario, valor);
			   } 
			   
			   else {
				   JOptionPane.showMessageDialog(null,"conta para dep�sito n�o foi encontrada");
				
			   }
			    
			   
			   } else {
				   JOptionPane.showMessageDialog(null," Conta para transferencia n�o encontrada");
		
			    }
		   
		   operacoes();
	   }
	   public static void listarContas() {
	        if(contasBancarias.size() > 0) {
	            for(Conta conta: contasBancarias) {
	                System.out.println(conta);
	            }
	        }else {
	           
	        	JOptionPane.showMessageDialog(null, "N�o h� contas cadastradas");
	        	
	        }
	        operacoes();
	   }
	   
}

