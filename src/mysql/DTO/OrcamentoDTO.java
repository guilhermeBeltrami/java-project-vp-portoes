/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.DTO;

/**
 *
 * @author 202202208353
 */
public class OrcamentoDTO {
 
    
    private String material;
    private double preco;
    
    public OrcamentoDTO(String material, double preco){
        this.material = material;
        this.preco = preco;
    }
    
    public String getMaterial(){
        return this.material;
    }
    
    public void setMaterial(String material){
        this.material = material;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
}
