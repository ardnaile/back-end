// importar o que é necessário**

@Service
public class OscarService {
    private List<Indicacao> indicados = new ArrayList<>(); // lista dos indicados

    public void adicionarIndicacao(Indicavel indicavel, String categoria) {
        if (indicavel.isElegivel()) { // se isElegivel é true
            indicavel.incrementarIndicacoes(); // incrementa o numero de indicação
            Indicacao novaIndicacao = new Indicacao(); // cria um objeto do tipo indicacao
            novaIndicacao.setIndicavel(indicavel);
            novaIndicacao.setCategoria(categoria);
            indicados.add(novaIndicacao); // adiciona o filme ou ator na lista
        } else {
            System.out.println("Este indicável não é elegível para indicação.");
        }
    }

    public List<Indicacao> listarIndicacoes() {
        return indicados;
    }
}
