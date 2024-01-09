package mysql.DTO;

public class CCliente {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String cep;
    private String endereco;
   
    /*public CCliente(String nnome, String cpf, String email, String cep, String endereco){
            this.nome = nnome;
            this.cpf = ccpf;
            this.email = eemail;
            this.cep = cep;
            this.telefone = telefone;
    }*/
    
    public String getCep(){
        return this.cep;
    }
    
    public void setCep(String cep){
        this.cep = cep;
    }
    
    public String getEndereco(){
        return this.endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
