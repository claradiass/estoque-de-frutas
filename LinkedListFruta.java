public class LinkedListFruta {
    private Produto head;
    private Produto tail;
    private int count;

    public LinkedListFruta() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public Produto posicaoDaFruta(Produto dado){
        Produto auxProduto = head;
        Produto ultimoMenor = null;
        
        while(auxProduto != null &&  (auxProduto.getNome().trim().compareTo(dado.getNome().trim()) < 0)){
            ultimoMenor = auxProduto;
            auxProduto = auxProduto.getNext();
        }
        return ultimoMenor;
    }

    public Produto getProduto(int index){
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        int aux = 0;
        Produto auxProduto = head;
        while(aux != index){
            auxProduto = auxProduto.getNext();
            aux++;
        }
        return auxProduto;
    }

    public Produto getProdutoNome(String nome){
        Produto auxProduto = head;

        for(int i = 0; i < size(); i++){

            if(auxProduto.getNome().toUpperCase().trim().compareTo(nome.toUpperCase().trim()) == 0){
                return auxProduto;
            }
            auxProduto = auxProduto.getNext(); 
        }
        return null;
    }

    public boolean checar(String nome){
        Produto auxProduto = head;

        for(int i = 0; i < size(); i++){

            if(auxProduto.getNome().toUpperCase().trim().compareTo(nome.toUpperCase().trim()) == 0){
                System.out.println("Existe");
                return true;
            }
            auxProduto = auxProduto.getNext();
        }
        System.out.println("Não existe");
        return false;
    }

    public void add(String nome, int quantidade){

        Produto newFruta = new Produto(nome.toUpperCase().trim(), quantidade);

        if(head == null && tail == null){
            head = newFruta;
            tail = newFruta;
            count ++;

        } else if(checar(nome.trim())) {
            Produto frutaExistente = getProdutoNome(nome.trim());
            int novaQuantidade = frutaExistente.getQuantidade() + quantidade;
            frutaExistente.setQuantidade(novaQuantidade);

        } else {
            Produto anterior = posicaoDaFruta(newFruta);
            if (anterior == null) { 
                newFruta.setNext(head);
                head = newFruta;
            } else {
                Produto posterior = anterior.getNext();
                newFruta.setNext(posterior);
                anterior.setNext(newFruta);
            }
            count ++;
        }
    }

    public void removeIndex(int index, int quantidade){
        if (index < 0 || index >= count) {
            System.out.println("Índice inválido");
            return;
        }

        if(index == 0){
            Produto produtoRemove = getProduto(index);
            int quantidadeRetirada = produtoRemove.getQuantidade() - quantidade;
            produtoRemove.setQuantidade(quantidadeRetirada);
            return;
        }

        if (index == count - 1){
            Produto ProdutoAnterior = getProduto(count - 1);
            int quantidadeRetirada = ProdutoAnterior.getQuantidade() - quantidade;
            ProdutoAnterior.setQuantidade(quantidadeRetirada);
            tail = ProdutoAnterior;
            tail.setNext(null);
            
            return;
        }

        Produto produtoRemove = getProduto(index);
        int quantidadeRetirada = produtoRemove.getQuantidade() - quantidade;
        produtoRemove.setQuantidade(quantidadeRetirada);
        

        if(produtoRemove.getQuantidade() <= 0){
            Produto ProdutoAnterior = getProduto(index-1);
            Produto ProdutoPosterior = getProduto(index+1);
            ProdutoAnterior.setNext(ProdutoPosterior);
            count --;
        }
    }

    public int size(){
        return count ;
    }

    public void listar(){
        if(size() == 0){
            System.out.println("Lista vazia");
        }

        Produto auxProduto = head;
        while(auxProduto != null){
            for(int i = 0; i < size(); i++){
                System.out.println(i + " - " + auxProduto.getNome().trim() + ":" + auxProduto.getQuantidade());
                auxProduto = auxProduto.getNext();
            }
        }
    }
}