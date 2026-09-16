public class Pilha extends ListaSimples{
    public void push(int valor) {
        inserirInicio(valor);
    }

    public int pop(){
        return removerInicio();
    }
    public int top(){
        return verInicio();
    }
}
