import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        ListaLigada ll = new ListaLigada();

        while (true) {

            System.out.println("\n\n================================================");
            System.out.println("             LISTA LIGADA TIPO II");
            System.out.println("================================================");
            System.out.println("0 - encerrar");
            System.out.println("1 - inserir elemento (no final)");
            System.out.println("2 - extrair elemento (do inicio)");
            System.out.println("3 - imprimir elementos da lista (sentido inicio -> fim)");
            System.out.println("4 - localizar um elemento dado seu numero (primeira ocorrencia)");
            System.out.println("5 - inserir um elemento em determinada posicao");
            System.out.println("6 - remover um elemento de determinada posicao");
            System.out.print("Opcao -> ");
            int opc = scn.nextInt();

            if (opc == 0) {
                break;
            } else if (opc == 1) {
                 System.out.print("Nome do elemento -> ");
                String nm = scn.next();
                System.out.print("Numero do elemento -> ");
                int nr = scn.nextInt();
                Elemento e = new Elemento(nm, nr);
                if (ll.enqueue(e)) {
                    System.out.println("Elemento inserido com sucesso!!");
                } else {
                    System.out.println("*** Falha na insercao do elemento!! ***");
                }
            } else if (opc == 2) {
                Elemento e = ll.dequeue();
                if (e == null) {
                    System.out.println("A Lista esta' vazia!!");
                } else {
                    System.out.println("O elemento foi removido da fila com sucesso.");
                    System.out.print("\nNome ---> " + e.getNome());
                    System.out.print("\nNumero -> " + e.getNumero());
                }
            } else if (opc == 3) {
                System.out.println("Elementos da fila:");
                System.out.println("--------------------------------------------");
                if (ll.isEmpty()) {
                    System.out.println("A fila esta' vazia.");
                } else {
                    Elemento e = ll.getInicio();
                    while (e != null) {
                        System.out.println(e.getNumero() + " | " + e.getNome());
                        e = e.getProximo();
                    }
                }

            } else if (opc == 4) {
                System.out.print("Numero do elemento para localizar -> ");
                int numero = scn.nextInt();
                Elemento encontrado = ll.localizarElemento(numero);
                if (encontrado != null) {
                    System.out.println("Elemento encontrado: " + encontrado.getNome() + " | " + encontrado.getNumero());
                } else {
                    System.out.println("Elemento nao encontrado.");
                }
            } else if (opc == 5) {
                System.out.print("Nome do elemento -> ");
                String nome = scn.next();
                System.out.print("Numero do elemento -> ");
                int numero = scn.nextInt();
                System.out.print("Posicao para inserir -> ");
                int posicao = scn.nextInt();
                Elemento novoElemento = new Elemento(nome, numero);
                if (ll.inserirNaPosicao(novoElemento, posicao)) {
                    System.out.println("Elemento inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir o elemento.");
                }
            } else if (opc == 6) {
                System.out.print("Posicao para remover -> ");
                int posicao = scn.nextInt();
                Elemento removido = ll.removerNaPosicao(posicao);
                if (removido != null) {
                    System.out.println("Elemento removido: " + removido.getNome() + " | " + removido.getNumero());
                } else {
                    System.out.println("Falha ao remover o elemento ou posicao invalida.");
                }
            }
        }
    }
}
