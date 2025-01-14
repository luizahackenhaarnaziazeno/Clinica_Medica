import java.util.Arrays;
//classe cadastro paciente
public class CadastroPacientes {
    //declaro da onde ele vai buscar as informações para essa classe
    private Paciente[] vetor;
    //crio uma nova variavel que determina proxima posicao livre no vetor(com ela tambem sabemos ate aonde o vetor esta ocupado)
    private int index;

    public CadastroPacientes() {
        vetor = new Paciente[10];//declaração da quantidade de paciente(espaço que o vetor alcança)
        index = 0;
    }

    //adiciona um paciente no cadastro
    public void adicionarPaciente(Paciente paciente) {
        if (index<=10) {
            vetor[index] = paciente;
            index++;
            System.out.println("Paciente adicionado ao cadastro.");
        } else {
            System.out.println("Não é possível adicionar mais pacientes.");
        }
    }

    //remove um paciente do cadastro (com o índice)
    public void removerPaciente(int indice) {
        if (indice>=0 && indice<index) {
            for (int i=indice; i<index-1; i++) {
                vetor[i] = vetor[i+1];
            }

            vetor[index-1] = null;
            index--;
            System.out.println("Paciente removido.");
        }
    }

    //escreve o cadastro de todos os pacientes
    public void escreverCadastro() {
        if (index == 0) {
            System.out.println("O cadastro está vazio.");
        } else {
            for (int i=0; i<index; i++) {
                System.out.println(vetor[i]);
                System.out.println();
            }
        }
    }

    //escreve o nome dos pacientes por ordem alfabética
    public void escreverNomesEmOrdemAlfabetica() {
        String[] nomes = new String[index];
        for (int i=0; i<index; i++) {
            nomes[i] = vetor[i].toString();
        }

        Arrays.sort(nomes);
        System.out.println("Nomes dos pacientes em ordem alfabética:");
        for (String nome:nomes) {
            System.out.println(nome);
            System.out.println();
        }
    }

    //calcula a média das consultas de todos os pacientes
    public double mediaConsultas() {
        if (index==0) {
            return 0;
        }

        int totalConsultas = 0;
        for (int i=0; i<index; i++) {
            totalConsultas+=vetor[i].getNumConsultasMes();
        }

        return (double) totalConsultas/index;
    }

    //calcula a porcentagem de cada diagnóstico
    public void porcentagemDiagnostico() {
        if (index==0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        int[] contagemDiagnosticos = new int[5];
        for (int i=0; i<index; i++) {
            int diagnostico = vetor[i].getDiagnostico();
            contagemDiagnosticos[diagnostico-1]++;
        }

        System.out.println("Porcentagem de pacientes com cada diagnóstico:");
        for (int i=0; i<5; i++) {
            double porcentagem=(double) contagemDiagnosticos[i] / index*100;
            System.out.println(getDiagnosticoTipo(i+1) + ": " + porcentagem + "%");
        }
    }

    //tipos de diagnósticos
    private String getDiagnosticoTipo(int diagnostico) {
        switch (diagnostico) {
            case 1:
                return "Covid";
            case 2:
                return "Dengue";
            case 3:
                return "Influenza";
            case 4:
                return "Meningite";
            default:
                return "Outro";
        }
    }
}