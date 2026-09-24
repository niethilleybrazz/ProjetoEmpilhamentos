import java.util.Random;
import java.util.Scanner;

public class Main {
    // 1. Correção: Faltava o 'public' antes do static void main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Estruturas de dados principais
        ListaSimples L1 = new ListaSimples();
        Pilha P = new Pilha();
        Fila F = new Fila();
        Deque D = new Deque();

        // 1 - Geração e Inserção
        System.out.println("\n--- 1. Gerando 20 elementos e inserindo em L1 ---");
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

        // 5 - Múltiplos de 3 na lista L1
        System.out.println("\n--- 5. Múltiplos de 3 em L1 ---");
        System.out.print("Múltiplos de 3: ");
        No atualL1 = L1.inicio;
        while (atualL1 != null) {
            if (atualL1.getDado() % 3 == 0) System.out.print(atualL1.getDado() + " ");
            atualL1 = atualL1.getProx();
        }
        System.out.println();

        // Invertendo
        System.out.println("\n--- 6. Inverter L2 usando Pilha Auxiliar ---");
        Pilha pilhaAux = new Pilha();
        while (!L2.estaVazia()) {
            pilhaAux.push(L2.removerInicio());
        }
        while (!pilhaAux.estaVazia()) {
            L2.inserirFim(pilhaAux.pop());
        }
        L2.imprimir("L2 Invertida");

        // Pilhas P e F
        System.out.println("\n--- 7. Pilha P para Fila F ---");
        while (!P.estaVazia()) {
            F.enqueue(P.pop());
        }
        F.imprimir("Fila F");
        P.imprimir("Pilha P");

        // Deque
        System.out.println("\n--- 8. L2 alternado no Deque D ---");
        No atualL2 = L2.inicio;
        boolean insereInicio = true;
        while (atualL2 != null) {
            if (insereInicio) D.inserirInicio(atualL2.getDado());
            else D.inserirFim(atualL2.getDado());

            insereInicio = !insereInicio;
            atualL2 = atualL2.getProx();
        }
        D.imprimir("Deque D");

        // Invertendo
        System.out.println("\n--- 9. Inverter IN LOCU 1º e último de L1 ---");
        if (L1.getTamanho() >= 2) {
            int temp = L1.inicio.getDado();
            L1.inicio.setDado(L1.fim.getDado());
            L1.fim.setDado(temp);
        }
        L1.imprimir("L1 após troca pontas");

        // Estrutura final
        System.out.println("\n--- 10. Estruturas Finais ---");
        L1.imprimir("L1");
        L2.imprimir("L2");
        P.imprimir("Pilha P");
        F.imprimir("Fila F");
        D.imprimir("Deque D");

        scanner.close();
    }
}