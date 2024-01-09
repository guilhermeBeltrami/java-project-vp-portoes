/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql.DTO;
import java.util.ArrayList;

public class PedidoDto {
    private String nome_cliente;
    private String nome_produto;
    private String email;
    private int quantidade;
    private double preco_unit;
    private double preco_total;
    
    public String getNomeCliente(){
        return this.nome_cliente;
    }
    
    public void setNomeCliente(String nome_cliente){
        this.nome_cliente = nome_cliente;
    }
    
    public String getNomeProduto(){
        return this.nome_produto;
    }
    
    public void setNomeProduto(String nome_produto){
        this.nome_produto = nome_produto;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(){
        this.email = email;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public double getPrecoUnit(){
        return this.preco_unit;
    }
    
    public void setPrecoUnit(double preco_unit){
        this.preco_unit = preco_unit;
    }
    
    public double getPrecoTotal(){
        return this.preco_total;
    }
    
    public void setPrecoTotal(double preco_total){
        this.preco_total = preco_total;
    }
    
    
    
    
}
