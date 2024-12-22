import java.util.Scanner;

public class Main {

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        LinkedListFruta lista = new LinkedListFruta();

        int op = -1;

        while (op != 5) { 
            exibirMenu();
            System.out.print("Digite a opção: ");
            op = scanner.nextInt();
            System.out.println();

            switch (op) {
                case 1:
                    scanner.nextLine(); 

                    System.out.print("Adicione uma fruta: ");
                    String nome = scanner.nextLine();
                
                    System.out.print("Adicione uma quantidade: ");
                    int quantidade = scanner.nextInt();
                
                    lista.add(nome, quantidade);
                    break;
                case 2:
                    lista.listar();
                    break;

                case 3:
                    if (lista.size() != 0) {
                        lista.listar();

                        System.out.print("Escolha o número da fruta : ");
                        int index = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Quantidade: ");
                        int quantidade2 = scanner.nextInt();

                        lista.removeIndex(index, quantidade2);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;
                case 4:
                    scanner.nextLine(); 
                    System.out.print("Adicione uma fruta para pesquisar: ");
                    String nome2 = scanner.nextLine();

                    lista.checar(nome2);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break; 
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("----------------------------- Menu Principal -----------------------------");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Listar produtos");
        System.out.println("3. Retirar produto");
        System.out.println("4. Checar existência do produto");
        System.out.println("5. Sair");
        System.out.println("--------------------------------------------------------------------------");
    }


    public static void main(String[] args) {     
        Main app = new Main();
        app.menuPrincipal();
    }

}
