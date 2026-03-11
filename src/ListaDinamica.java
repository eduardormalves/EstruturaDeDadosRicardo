public class ListaDinamica implements ListaOperacoes {

    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinamica criada");
    }

    public void adicionarElemento(String elemento) {

        if (inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novoNo);
        }
    }

    public void exibir() {

        if (inicioEstaVazio()) {
            System.out.println("Não tem elementos na lista dinamica");
            return;
        }

        No aux = this.inicio;

        while (aux != null) {
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
        }
    }

    private boolean inicioEstaVazio() {
        return this.inicio.getConteudo() == null;
    }

    public void removerElemento(String elemento) {

        if (inicioEstaVazio()) {
            System.out.println("Não existem elementos para serem removidos");
            return;
        }

        if (this.inicio.getConteudo().equals(elemento)) {
            this.inicio = this.inicio.getProx();
            System.out.println("Elemento " + elemento + " removido");
            return;
        }

        No aux = this.inicio;

        while (aux.getProx() != null) {

            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                System.out.println("Elemento " + elemento + " removido");
                return;
            }

            aux = aux.getProx();
        }

        System.out.println("Elemento não encontrado");
    }

    public boolean procurarElemento(String elemento) {

        if (inicioEstaVazio()) {
            System.out.println("Não tem elementos para serem procurados");
            return false;
        }

        No aux = this.inicio;

        while (aux != null) {

            if (aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado");
                return true;
            }

            aux = aux.getProx();
        }

        System.out.println("Elemento " + elemento + " não existe na lista");
        return false;
    }

    @Override
    public int contar() {
        if (inicioEstaVazio()) {
            return 0;
        }

        int contador = 0;
        No aux = this.inicio;
        while (aux != null) {
            contador++;
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;

        while (inicio != null && inicio.getConteudo().equals(elemento)) {
            inicio = inicio.getProx();
            removidos++;
        }

        No aux = inicio;
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                removidos++;
            } else {
                aux = aux.getProx();
            }
        }

        return removidos;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;

        for (int i = 0; i < elementos.length; i++) {
            adicionarElemento(elementos[i]);
            adicionados++;
        }

        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0) {
            return null;
        }

        int contador = 0;
        No aux = this.inicio;

        while (aux != null) {
            if (contador == indice) {
                return aux.getConteudo();
            }
            contador++;
            aux = aux.getProx();
        }

        return null;
    }
    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) {
            return false;
        }

        No novo = new No(elemento);
        if (indice == 0) {
            novo.setProx(inicio);
            inicio = novo;
            return true;
        }

        No aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador + 1 == indice) {
                novo.setProx(aux.getProx());
                aux.setProx(novo);
                return true;
            }
            contador++;
            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || inicioEstaVazio()) {
            return null;
        }

        if (indice == 0) {
            String removido = inicio.getConteudo();
            inicio = inicio.getProx();
            return removido;
        }

        No aux = inicio;
        int contador = 0;
        while (aux.getProx() != null) {
            if (contador + 1 == indice) {
                String removido = aux.getProx().getConteudo();
                aux.setProx(aux.getProx().getProx());
                return removido;
            }
            contador++;
            aux = aux.getProx();
        }
        return null;
    }

    @Override
    public void limpar() {
        this.inicio = new No(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = 0;
        int ultimo = -1;
        No aux = this.inicio;

        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                ultimo = indice;
            }
            indice++;
            aux = aux.getProx();
        }

        return ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;

        if (inicioEstaVazio()) {
            return 0;
        }

        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                contador++;
            }
            aux = aux.getProx();
        }

        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        No aux = this.inicio;

        while (aux != null) {
            if (aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                substituidos++;
            }
            aux = aux.getProx();
        }

        return substituidos;
    }
}
