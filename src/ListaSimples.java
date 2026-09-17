public class ListaSimples {
    protected No inicio;
    protected No fim;
    protected int tamanho;

    public ListaSimples() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserirInicio(int valor) {
        No novo = new No(valor);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio = novo;
        }
        tamanho++;
    }

    public void inserirFim(int valor){
        No novo = new No(valor);
        if(estaVazia()){
            inicio = novo;
            fim = novo;
        } else {
            fim.setProx(novo);
            fim=novo;
        }
        tamanho++;
    }

    public int removerInicio(){
        if(estaVazia()){
            throw new RuntimeException("Estrutura Vazia");
        }
        int valor = inicio.getDado();
        inicio = inicio.getProx();
        tamanho--;
        if(estaVazia()){
            fim = null;
        }
        return valor;
    }

    public int removerFim(){
        if (estaVazia()) {
            throw new RuntimeException("Estrutura vazia!");
        }
        if (tamanho == 1) {
            return removerInicio();
        }
        No atual = inicio;
        while (atual.getProx() != fim) {
            atual = atual.getProx();
        }
        int valor = fim.getDado();
        fim = atual;
        fim.setProx(null);
        tamanho--;
        return valor;
    }

    public int verInicio() {
        if (estaVazia()) throw new RuntimeException("Estrutura vazia!");
        return inicio.getDado();
    }

    public int verFim() {
        if (estaVazia()) throw new RuntimeException("Estrutura vazia!");
        return fim.getDado();
    }

    public void inserirMeio(int valor, int posicao){
        if (posicao <= 0){
            inserirInicio(valor);
            return;
        }
        if (posicao >= tamanho){
            inserirFim(valor);
            return;
        }

        No novo = new No(valor);
        No atual = inicio;
        for (int i = 0; i < posicao - 1; i++){
            atual = atual.getProx();
        }
        novo.setProx(atual.getProx());
        atual.setProx(novo);
        tamanho++;
    }

    public ListaSimples copiar() {
        ListaSimples copia = new ListaSimples();
        No atual = this.inicio;
        while (atual != null) {
            copia.inserirFim(atual.getDado());
            atual = atual.getProx();
        }
        return copia;
    }

    public void imprimir(String nome) {
        System.out.print(nome + ": [ ");
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.getDado() + (atual.getProx() != null ? " - " : ""));
            atual = atual.getProx();
        }
        System.out.println(" ] (Tamanho: " + tamanho + ")");
    }
}
