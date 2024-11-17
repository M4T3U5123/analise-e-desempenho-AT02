import java.util.ArrayList;
import java.util.List;



public class L_Ligada {
    private No cabeca;

    public void adicionar(int numero, int posicao) {
        No novo = new No(numero);
        if (this.cabeca == null) {
            this.cabeca = novo;
        } else {
            No atual = this.cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                if (atual.getPonteiro() == null) {
                    break;
                }
                atual = atual.getPonteiro();
            }
            novo.setPonteiro(atual.getPonteiro());
            atual.setPonteiro(novo);
        }
    }

    public void remover(int numero) {
        if (this.cabeca == null) {
            return;
        }
        if (this.cabeca.getNumero() == numero) {
            this.cabeca = this.cabeca.getPonteiro();
            return;
        }
        if (this.cabeca.getPonteiro() == null) {
            this.cabeca = null;
            return;
        }
        No atual = this.cabeca;
        while (atual.getPonteiro() != null) {
            if (atual.getPonteiro().getNumero() == numero) {
                atual.setPonteiro(atual.getPonteiro().getPonteiro());
                return;
            }
            atual = atual.getPonteiro();
        }
    }

    public void imprimir() {
        List<Integer> lista = new ArrayList<>();
        No atual = this.cabeca;
        while (atual != null) {
            lista.add(atual.getNumero());
            atual = atual.getPonteiro();
        }
        System.out.println(lista);
    }
}