package br.com.iftm.layout.model;



public class Task {

  public Task(Long id, String name, Long cpf, String email) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

 
 

  public Task() {
  }

  private Long id;
  private String name;
  private String email;

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }

  private Long cpf;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  

}
