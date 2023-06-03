package br.com.tarefas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tarefas")
@NamedQuery(name = "Tarefa.tarefasPorCategoria", query = "select t from Tarefa t inner join t.categoria c where c.nome = ?1")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "{tarefa.descricao.not-blank")
	@Size(min = 5, max = 150, message = "{tarefa.descricao.size}")
	@Column(name = "ds_tarefa", nullable = false, length = 150)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TarefaStatus status = TarefaStatus.ABERTO;
	
	@FutureOrPresent(message = "{tarefa.descricao.future-or-present}")
	private LocalDate dataEntrega;
	
	private boolean visivel;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TarefaCategoria categoria;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public TarefaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TarefaCategoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
