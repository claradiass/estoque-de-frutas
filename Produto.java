public class Produto {
    private String nome;
    private int quantidade;
    private Produto next;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getNext() {
        return next;
    }

    public void setNext(Produto next) {
        this.next = next;
    }
    
}
