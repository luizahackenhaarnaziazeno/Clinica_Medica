//classe Gato basica
// Fundamentos 2023 
public class Gato
{
    private String nome;
    private int idade;
    private String cor;
    
    public Gato(String nome, int idade, String cor){
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }
    
    public String getNome(){ return nome;}
    public int getIdade(){ return idade; }
    public String getCor(){ return cor; }
    
    public void setNome(){ String nome;}
    public void setIdade(){ int idade; }
    public void setCor(){ String cor; }
        
    public String toString(){
        return " Nome: " + nome + "\n Idade: " + idade + "\n Cor: " + cor;
    }
    
    
}
