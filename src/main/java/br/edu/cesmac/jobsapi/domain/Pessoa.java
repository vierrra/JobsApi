package br.edu.cesmac.jobsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    @NotEmpty(message = "Obrigatório informar nome completo!")
    @Size(max = 150)
    private String nome;
    @NotEmpty(message = "Obrigatório informar email!")
    @Size(max = 150)
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @NotEmpty(message = "Obrigatório informar sexo!")
    @Size(max = 1)
    private String sexo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pessoas")
    @JoinTable(name               = "pessoa_habilidade",
               joinColumns        = @JoinColumn(name = "idPessoa"),
               inverseJoinColumns = @JoinColumn(name = "idHabilidade"))
    private List<Habilidade> habilidades;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
