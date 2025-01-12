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
            System.out.println("");
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

            }
        }

    }

}
