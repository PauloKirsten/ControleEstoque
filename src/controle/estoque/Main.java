package controle.estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	  private static ArrayList<Produto> estoque = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        boolean executar = true;
	        while (executar) {
	            System.out.println("\nControle de Estoque de Câmeras e Lentes");
	            System.out.println("1. Adicionar produto");
	            System.out.println("2. Listar produtos");
	            System.out.println("3. Buscar produto");
	            System.out.println("4. Excluir produto");	            
	            System.out.println("5. Sair");
	            System.out.print("Escolha uma opção: ");

	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1:
	                    adicionarProduto();
	                    break;
	                case 2:
	                    listarProdutos();
	                    break;
	                case 3:
	                    buscarProduto();
	                    break;
	                case 4:
	                	excluirProduto();
	                    break;
	                case 5:
	                    executar = false;
	                    System.out.println("Encerrando o programa...");
	                    break;
	                default:
	                    System.out.println("Opção inválida, tente novamente.");
	            }
	        }
	    }

	    private static void adicionarProduto() {

	        System.out.print("Digite o nome do produto (câmera ou lente): ");
	        String nome = scanner.nextLine();
	        System.out.print("Digite o código do produto (câmera ou lente): ");
	        int codigo = scanner.nextInt();	        
	        System.out.print("Digite a quantidade: ");
	        int quantidade = scanner.nextInt();
	        System.out.print("Digite o preço: ");
	        double preco = scanner.nextDouble();
	        scanner.nextLine(); 

	        Produto produto = new Produto (codigo, nome, quantidade, preco);
	        estoque.add(produto);
	        System.out.println("Produto adicionado com sucesso!");
	    }
	    
	    private static void excluirProduto() {
	        System.out.print("Digite o código do produto para excluir: ");
	        int codigo = scanner.nextInt();
	        boolean removido = false;

	        for (int i = 0; i < estoque.size(); i++) {
	            if (estoque.get(i).getCodigo() == codigo) {
	                estoque.remove(i);
	                System.out.println("Produto excluído com sucesso!");
	                removido = true;
	                break;
	            }
	        }

	        if (!removido) {
	            System.out.println("Produto não encontrado.");
	        }
	    }
	    
	    private static void listarProdutos() {
	        if (estoque.isEmpty()) {
	            System.out.println("O estoque está vazio.");
	        } else {
	            System.out.println("Produtos em estoque:");
	            for (Produto produto : estoque) {
	                System.out.println(produto);
	            }
	        }
	    }

	    private static void buscarProduto() {
	        System.out.print("Digite o nome do produto para buscar: ");
	        String nome = scanner.nextLine();
	        boolean encontrado = false;

	        for (Produto produto : estoque) {
	            if (produto.getNome().equalsIgnoreCase(nome)) {
	                System.out.println(produto);
	                encontrado = true;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("Produto não encontrado.");
	        }
	    }
}

