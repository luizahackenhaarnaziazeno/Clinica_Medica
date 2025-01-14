//classe paciente
public class Paciente { 
    //informações necessárias para os dados da classe Paciente
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio;
    private int diagnostico;
    private int numConsultasMes;
    
    public Paciente(String nome, String cpf, String telefone, String convenio, int diagnostico, int numConsultasMes) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.numConsultasMes = numConsultasMes;
    }
    //Métodos para enviar as informações do paciente
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public void setConvenio(String convenio) {this.convenio = convenio; }

    public void setDiagnostico(int diagnostico) { this.diagnostico = diagnostico; }

    public int getDiagnostico() { return diagnostico;}

    public void setNumConsultasMes(int numConsultasMes) { this.numConsultasMes = numConsultasMes; }

    public int getNumConsultasMes() { return numConsultasMes;}
    //Método que calcula o valor total de consultas desse paciente
    public int calcularValorTotalConsulta(int valorConsulta) { return numConsultasMes * valorConsulta; }
    //Método que printa todos os métodos dessa classe na tela
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nConvênio: " + convenio + "\nDiagnóstico: " + getDiagnosticoTipos() + "\nNúmero de consultas do mês: " + numConsultasMes;
    }
    //declaração do método para pegar informações do diagnostico do paciente
    private String getDiagnosticoTipos() { 
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
