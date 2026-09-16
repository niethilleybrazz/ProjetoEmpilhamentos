public class No {
    private int dado;
    private No prox;

    public No(int valor) {
        this.dado = valor;
        this.prox = null;
    }

    public int getDado() { return dado; }
    public void setDado(int dado) { this.dado = dado; }

    public No getProx() { return prox; }
    public void setProx(No prox) { this.prox = prox; }
}