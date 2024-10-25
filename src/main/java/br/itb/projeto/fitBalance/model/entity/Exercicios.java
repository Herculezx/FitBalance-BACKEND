package br.itb.projeto.fitBalance.model.entity;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exercicios")
public class Exercicios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nivel;
	private long serie;
	private long repeticoes;
	@Lob
	private String instrucoes;

	@Column(name = "imagem_id", insertable = false, updatable = false, nullable = true)
	private Long imagemId;

	@Lob
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	@JsonBackReference("Imagem")
	private Arquivo imagem;

	@Column(name = "video_id", insertable = false, updatable = false, nullable = true)
	private Long videoId;

	@Lob
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn
	@JsonBackReference
	private Arquivo video;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exercicios")
	@JsonManagedReference
	private List<ExerciciosFeito> feitos; 
	
	

	public List<ExerciciosFeito> getFeitos() {
		return feitos;
	}

	public void setFeitos(List<ExerciciosFeito> feitos) {
		this.feitos = feitos;
	}

	public Long getImagemId() {
		return imagemId;
	}

	public void setImagemId(Long imagemId) {
		this.imagemId = imagemId;
	}

	public Arquivo getImagem() {
		return imagem;
	}

	public void setImagem(Arquivo imagem) {
		this.imagem = imagem;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public Arquivo getVideo() {
		return video;
	}

	public void setVideo(Arquivo video) {
		this.video = video;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Exercicios() {
		super();
	}

	public Exercicios(String nome, String nivel, long serie, long repeticoes, String instrucoes, String imagem,
			String video) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.serie = serie;
		this.repeticoes = repeticoes;
		this.instrucoes = instrucoes;
		
		try {
			String[] partesImagem = imagem.split(";base64,");
			String extensao = partesImagem[0].replaceAll("data:", "");
			
			byte[] bytes = Base64.getDecoder().decode(partesImagem[1].getBytes());

			this.imagem = new Arquivo(bytes, extensao);
			
			String[] partesVideo = video.split(";base64,");
			
			if (!video.equals("")) {
				String extensaoVideo = partesVideo[0].replaceAll("data:", "");


				byte[] bytesVideo = Base64.getDecoder().decode(partesVideo[1].getBytes());

				this.video = new Arquivo(bytesVideo, extensaoVideo);
			}
			
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

//		this.imagem = imagem;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public long getSerie() {
		return serie;
	}

	public void setSerie(long serie) {
		this.serie = serie;
	}

	public long getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(long repeticoes) {
		this.repeticoes = repeticoes;
	}

	public String getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}

}
