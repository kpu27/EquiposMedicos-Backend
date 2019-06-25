/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 20)
  private String username;

  @Column(length = 60)
  private String password;
  private Boolean enabled;
  private String nombre;
  private String apellido;
  @Column(unique = true)
  private String email;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "documento")
  private String documento;
   
  @JoinColumn(name = "fk_empresa", referencedColumnName = "id_Empresa")
  @ManyToOne(optional = false)
  private Empresa fkEmpresa;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Empresa getFkEmpresa() {
    return fkEmpresa;
  }

  public void setFkEmpresa(Empresa fkEmpresa) {
    this.fkEmpresa = fkEmpresa;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private static final long serialVersionUID = 1L;

}
