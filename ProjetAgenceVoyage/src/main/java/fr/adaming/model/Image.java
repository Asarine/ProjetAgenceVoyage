package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="images")
public class Image implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_im;
	@Lob
	private byte[] contents;
	
	//constructeurs :
	public Image() {
		super();
	}



	public Image(byte[] contents) {
		super();
		this.contents = contents;
	}



	public Image(long id_im, byte[] contents) {
		super();
		this.id_im = id_im;
		this.contents = contents;
	}



	//getters et setters :
	
	
	
	public long getId_im() {
		return id_im;
	}




	public void setId_im(long id_im) {
		this.id_im = id_im;
	}



	public byte[] getContents() {
		return contents;
	}



	public void setContents(byte[] contents) {
		this.contents = contents;
	}



	//to string sans les attributs de  l'assos :

	@Override
	public String toString() {
		return "Image [id_im=" + id_im + ", contents=" + Arrays.toString(contents) + "]";
	}
	
	
	
	
	
	
	
	
	

}
