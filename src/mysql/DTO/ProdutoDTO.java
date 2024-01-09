package mysql.DTO;

public class ProdutoDTO {
    private String nome;
    private Double valor_unit;
    private String produto_cod; 
   
    /*public ProdutoDAO(String nnome, Double valor_unit, String produto_cod){
            this.nome = nnome;
            this.valor_unit = valor_unit;
            this.produto_cod = produto_cod;
    }*/
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Double getValor_unit(){
        return this.valor_unit;
    }
    
    public void setValor_unit(Double valor_unit){
        this.valor_unit = valor_unit;
    }
    
    public String getProduto_cod(){
        return this.produto_cod;
    }
    
    public void setProduto_cod(String produto_cod){
        this.produto_cod = produto_cod;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
