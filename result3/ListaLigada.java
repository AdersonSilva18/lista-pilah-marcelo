public class ListaLigada {

    private Elemento inicio;

    public boolean enqueue(Elemento e) {

        try {
            if (isEmpty()) {
                inicio = e;
            } else {
                Elemento fim = getFim();
                fim.setProximo(e);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public Elemento dequeue() {

        if (inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getProximo();
        e.setProximo(null);
        return e;

    }

    public Elemento getInicio() {
        return inicio;
    }

    /**
     * Percorre a lista ate' encontrar o ultimo elemento. Este metodo e'
     * necessario neste caso pois nao ha' ponteiro para o final.
     *
     * @return
     */
    public Elemento getFim() {
        if (isEmpty()) {
            return inicio;
        }
        Elemento e = inicio;
        while (e.getProximo() != null) {
            e = e.getProximo();
        }
        return e;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

     public Elemento localizarElemento(int numero) {
        Elemento atual = inicio;
        while (atual != null) {
            if (atual.getNumero() == numero) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public boolean inserirNaPosicao(Elemento novo, int posicao) {
        if (posicao < 0) return false;

        if (posicao == 0) {
            novo.setProximo(inicio);
            inicio = novo;
            return true;
        }

        Elemento atual = inicio;
        for (int i = 0; i < posicao - 1 && atual != null; i++) {
            atual = atual.getProximo();
        }

        if (atual == null) return false;

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        return true;
    }

    public Elemento removerNaPosicao(int posicao) {
        if (isEmpty() || posicao < 0) return null;

        if (posicao == 0) {
            Elemento removido = inicio;
            inicio = inicio.getProximo();
            removido.setProximo(null);
            return removido;
        }

        Elemento atual = inicio;
        for (int i = 0; i < posicao - 1 && atual != null; i++) {
            atual = atual.getProximo();
        }

        if (atual == null || atual.getProximo() == null) return null;

        Elemento removido = atual.getProximo();
        atual.setProximo(removido.getProximo());
        removido.setProximo(null);
        return removido;
    }

}
