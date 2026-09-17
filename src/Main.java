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

        // 1 - Geração e Insersão
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

        // 2 - Copiando
        System.out.println("\n--- 2. Copiando L1 para L2 ---");
        ListaSimples L2 = L1.copiar();
        L1.imprimir("L1");
        L2.imprimir("L2");

        // 3 - Removendo
        System.out.println("\n--- 3. Removendo Pares de L1 para a Pilha P ---");
        ListaSimples L1Aux = new ListaSimples();
        while (!L1.estaVazia()) {
            int elem = L1.removerInicio();
            if (elem % 2 == 0) {
                P.push(elem);
            } else {
                L1Aux.inserirFim(elem);
            }
        }
        while (!L1Aux.estaVazia()) {
            L1.inserirFim(L1Aux.removerInicio());
        }
        L1.imprimir("L1 (sem pares)");

        // 4 - Ordenando
        System.out.println("\n--- 4. Ordenando L2 com Bubble Sort ---");
        int n = L2.getTamanho();
        for (int i = 0; i < n - 1; i++) {
            No atual = L2.inicio;
            No proximo = L2.inicio.getProx();
            for (int j = 0; j < n - 1 - i; j++) {
                if (atual.getDado() > proximo.getDado()) {
                    int temp = atual.getDado();
                    atual.setDado(proximo.getDado());
                    proximo.setDado(temp);
                }
                atual = proximo;
                proximo = proximo.getProx();
            }
        }
        L2.imprimir("L2 (Ordenada)");
    }
}
