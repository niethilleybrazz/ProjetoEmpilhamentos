import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Estruturas de dados principais
        ListaSimples L1 = new ListaSimples();
        Pilha P = new Pilha();
        Fila F = new Fila();
        Deque D = new Deque();

        System.out.println("----------------------------------------------------");
        System.out.println("1. GERANDO 20 ELEMENTOS ALEATÓRIOS E INSERINDO EM L1");
        System.out.println("----------------------------------------------------");

        for (int i = 1; i <= 20; i++) {
            int num = random.nextInt(100) + 1;
            System.out.printf("\n[%d/20] Número gerado: %d\n", i, num);
            System.out.println("Escolha a posição para inserir:");
            System.out.println("1 - Início | 2 - Meio | 3 - Fim");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    L1.inserirInicio(num);
                    break;
                case 2:
                    int posicaoMeio = L1.getTamanho() / 2;
                    L1.inserirMeio(num, posicaoMeio);
                    break;
                case 3:
                default:
                    L1.inserirFim(num);
                    break;
            }
            L1.imprimir("L1 Atual");
        }
    }
}
