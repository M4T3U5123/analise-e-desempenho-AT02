public class No {
    private int numero;
    public int getNumero() {
        return numero;
    }

    private No ponteiro;

    public No getPonteiro() {
        return ponteiro;
    }

    public void setPonteiro(No ponteiro) {
        this.ponteiro = ponteiro;
    }

    public No(int numero) {
        this.numero = numero;
        this.ponteiro = null;
    }
}