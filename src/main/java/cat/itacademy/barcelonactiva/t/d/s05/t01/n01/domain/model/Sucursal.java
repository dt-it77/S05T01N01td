package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)    
    int pk_SucursalID;
    @Column(name = "nomSucursal")
    String nomSucursal;
    @Column(name = "paisSucursal")
    String paisSucursal;

    public Sucursal() {
	}
	public Sucursal(int pk_SucursalID, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
	public int getId() {
		return pk_SucursalID;
	}
	public String getNom() {
		return nomSucursal;
	}
	public void setNom(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPais() {
		return paisSucursal;
	}
	public void setPais(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	@Override
	public String toString() {
		return "Sucursal [id=" + pk_SucursalID + ", nom=" + nomSucursal + ", paisSucursal=" + paisSucursal +"]";
	}
}
