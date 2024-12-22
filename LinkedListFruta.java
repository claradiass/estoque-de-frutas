public class LinkedListFruta {
    private Produto head; // Referência ao primeiro elemento (nó) da lista
    private Produto tail; // Referência ao último elemento (nó) da lista
    private int count; // Contador de elementos na lista

    // Construtor para inicializar a lista vazia
    public LinkedListFruta() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Método para encontrar a posição de inserção de uma nova fruta na lista, ordenada por nome
    public Produto posicaoDaFruta(Produto dado){
        Produto auxProduto = head; // Começa do primeiro elemento
        Produto ultimoMenor = null; // Inicializa a referência ao último produto menor

        // Percorre a lista até encontrar um produto cujo nome é maior ou igual ao dado
        while(auxProduto != null &&  (auxProduto.getNome().trim().compareTo(dado.getNome().trim()) < 0)){
            ultimoMenor = auxProduto; // Atualiza o último produto menor
            auxProduto = auxProduto.getNext(); // Avança para o próximo produto
        }
        return ultimoMenor; // Retorna o último produto menor que o dado
    }

<<<<<<< HEAD
    // Método para obter o produto em um índice específico
=======
>>>>>>> b4cebeb96fabf8d7a0c2ea2a1b52839e94178a31
    public Produto getProduto(int index){
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice inválido"); // Verifica se o índice é válido
        }

        int aux = 0;
        Produto auxProduto = head; // Começa do primeiro produto
        while(aux != index){ // Percorre a lista até o índice desejado
            auxProduto = auxProduto.getNext(); // Avança para o próximo produto
            aux++;
        }
        return auxProduto; // Retorna o produto na posição especificada
    }

    // Método para obter o produto pelo nome
    public Produto getProdutoNome(String nome){
        Produto auxProduto = head; // Começa do primeiro produto

        // Percorre a lista procurando pelo produto com o nome especificado
        for(int i = 0; i < size(); i++){
            if(auxProduto.getNome().toUpperCase().trim().compareTo(nome.toUpperCase().trim()) == 0){
                return auxProduto; // Retorna o produto se encontrado
            }
            auxProduto = auxProduto.getNext(); // Avança para o próximo produto
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // Método para verificar se um produto com o nome especificado existe na lista
    public boolean checar(String nome){
        Produto auxProduto = head; // Começa do primeiro produto

        // Percorre a lista procurando pelo produto com o nome especificado
        for(int i = 0; i < size(); i++){
            if(auxProduto.getNome().toUpperCase().trim().compareTo(nome.toUpperCase().trim()) == 0){
                System.out.println("Existe");
                return true; // Retorna true se o produto for encontrado
            }
<<<<<<< HEAD
            auxProduto = auxProduto.getNext(); // Avança para o próximo produto
        }
        System.out.println("Não existe");
        return false; // Retorna false se o produto não for encontrado
=======
            auxProduto = auxProduto.getNext();
        }
        System.out.println("Não existe");
        return false;
>>>>>>> b4cebeb96fabf8d7a0c2ea2a1b52839e94178a31
    }

    // Método para adicionar um novo produto na lista
    public void add(String nome, int quantidade){
        Produto newFruta = new Produto(nome.toUpperCase().trim(), quantidade); // Cria um novo produto com o nome e quantidade especificados

        // Se a lista está vazia, o novo produto se torna o primeiro e o último produto
        if(head == null && tail == null){
            head = newFruta;
            tail = newFruta;
            count++;

        // Se o produto já existe na lista, incrementa a quantidade
        } else if(checar(nome.trim())) {
            Produto frutaExistente = getProdutoNome(nome.trim());
            int novaQuantidade = frutaExistente.getQuantidade() + quantidade;
            frutaExistente.setQuantidade(novaQuantidade);

        // Caso contrário, insere o novo produto na posição correta
        } else {
            Produto anterior = posicaoDaFruta(newFruta); // Encontra a posição de inserção
            if (anterior == null) { // Se o novo produto deve ser inserido no início
                newFruta.setNext(head); // O novo produto aponta para o antigo primeiro produto
                head = newFruta; // O novo produto se torna o primeiro produto
            } else {
                Produto posterior = anterior.getNext(); // O próximo produto após a posição de inserção
                newFruta.setNext(posterior); // O novo produto aponta para o próximo produto
                anterior.setNext(newFruta); // O produto anterior aponta para o novo produto
                if (posterior == null) { // Se o novo produto foi inserido no final
                    tail = newFruta; // O novo produto se torna o último produto
                }
            }
            count++;
        }
    }

    // Método para remover uma quantidade específica de um produto na posição especificada
    // public void removeIndex(int index, int quantidade){
    //     if (index < 0 || index > count) {
    //         System.out.println("Índice inválido");
    //         return;
    //     }

    //     // Se o índice é 0, remove a quantidade do primeiro produto
    //     if(index == 0){
    //         Produto produtoRemove = getProduto(index);
    //         int quantidadeRetirada = produtoRemove.getQuantidade() - quantidade;
    //         produtoRemove.setQuantidade(quantidadeRetirada);
    //         return;
    //     }

    //     // Se o índice é o último, remove a quantidade do último produto
    //     if (index == count - 1){
    //         Produto produtoAnterior = getProduto(count - 1);
    //         int quantidadeRetirada = produtoAnterior.getQuantidade() - quantidade;
    //         produtoAnterior.setQuantidade(quantidadeRetirada);
    //         tail = produtoAnterior;
    //         tail.setNext(null);
    //         return;
    //     }

    //     // Remove a quantidade do produto na posição especificada
    //     Produto produtoRemove = getProduto(index);
    //     int quantidadeRetirada = produtoRemove.getQuantidade() - quantidade;
    //     produtoRemove.setQuantidade(quantidadeRetirada);

    //     // Se a quantidade do produto se torna menor ou igual a zero, remove o produto da lista
    //     if(produtoRemove.getQuantidade() <= 0){
    //         Produto produtoAnterior = getProduto(index-1);
    //         Produto produtoPosterior = getProduto(index+1);
    //         produtoAnterior.setNext(produtoPosterior);
    //         count--;
    //     }
    // }

    public void removeIndex(int index, int quantidade) {
        if (index < 0 || index >= count) {
            System.out.println("Índice inválido");
            return;
        }
    
        Produto produtoRemove = getProduto(index);
        int quantidadeRestante = produtoRemove.getQuantidade() - quantidade;
        produtoRemove.setQuantidade(quantidadeRestante);
    
        if (quantidadeRestante > 0) {
            return;
        }
    
        if (index == 0) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Produto produtoAnterior = getProduto(index - 1);
            produtoAnterior.setNext(produtoRemove.getNext());
            if (index == count - 1) {
                tail = produtoAnterior;
            }
        }
    
        count--;
    }

    // Método para obter o número de produtos na lista
    public int size(){
        return count;
    }

    // Método para listar todos os produtos na lista
    public void listar(){
        if(size() == 0){
            System.out.println("Lista vazia");
            return;
        }

        Produto auxProduto = head; // Começa do primeiro produto
        while(auxProduto != null){
            for(int i = 0; i < size(); i++){
                System.out.println(i + " - " + auxProduto.getNome().trim() + ":" + auxProduto.getQuantidade());
                auxProduto = auxProduto.getNext(); // Avança para o próximo produto
            }
        }
    }
}
