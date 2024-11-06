public class ListaLigada {

    private Elemento inicio;

    // Adiciona um elemento ao topo da pilha
    public boolean push(Elemento e) {

        try {
            e.setProximo(inicio);
            inicio = e;
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    // retira o elemento no topo da pilha
    public Elemento pop() {

        if (inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getProximo();
        e.setProximo(null);
        return e;

    }

}
