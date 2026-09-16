public class Deque extends ListaSimples{
    public void addFirst(int valor) { inserirInicio(valor); }
    public void addLast(int valor) { inserirFim(valor); }

    public int removeFirst() { return removerInicio(); }
    public int removeLast() { return removerFim(); }

    public int getFirst() { return verInicio(); }
    public int getLast() { return verFim(); }
}
