public class Fila extends ListaSimples{
    public void enqueue(int valor){
        inserirFim(valor);
    }

    public int dequeue(){
        return removerInicio();
    }

    public int front(){
        return verInicio();
    }
}
