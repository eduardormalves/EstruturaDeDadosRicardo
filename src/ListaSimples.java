public class ListaSimples implements ListaOperacoes {
    String [] lista;
    int tamanho;
    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        this.tamanho = 0;
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void adicionarElemento(String elemento) {
        if (tamanho < lista.length) {
            lista[tamanho] = elemento;
            tamanho++;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        } else {
            System.out.println("Não há espaço disponível na lista.");
        }
    }

    public boolean estaCheia() {
        return tamanho == lista.length;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if(this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if(this.lista[i] == null) {
                break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if(removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if(!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if(encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                removerPorIndice(i);
                removidos++;
                i--;
            }
        }
        return removidos;
    }

    @Override
    public int contar() {
        return tamanho;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (!estaCheia()) {
                adicionarElemento(elementos[i]);
                adicionados++;
            } else {
                break;
            }
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        }
        return lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice > tamanho || estaCheia()) {
            return false;
        }
        for (int i = tamanho; i > indice; i--) {
            lista[i] = lista[i - 1];
        }
        lista[indice] = elemento;
        tamanho++;
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        }
        String removido = lista[indice];
        for (int i = indice; i < tamanho - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[tamanho - 1] = null;
        tamanho--;
        return removido;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = null;
        }
        tamanho = 0;
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] != null && lista[i].equals(antigo)) {
                lista[i] = novo;
                substituidos++;
            }
        }
        return substituidos;
    }
}
