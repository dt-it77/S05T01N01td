package cat.itacademy.barcelonactiva.t.d.s05.t01.n01.domain.dto;

import java.util.Arrays;
import java.util.List;


public class SucursalDTO {

    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

	private List<String> countriesUE = Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia", "Dinamarca", "Eslovàquia",
			"Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Alemanya", "Grècia", "Hongria",
			"la República d'Irlanda", "Itàlia", "Letònia", "Lituània", "Luxemburg", "Malta", "els Països Baixos",
			"Polònia", "Portugal", "Romania", "Suècia", "República Txeca", "Xipre");
	public SucursalDTO(){
		
	}
	public SucursalDTO(int pk_SucursalID, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = setIsCountryUE(paisSucursal);
	}
	public int getPk_SucursalID() {
		return pk_SucursalID;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public String getPaisSucursal() {
		return paisSucursal;
	}
	public String getTipusSucursal() {
		return tipusSucursal;
	}
	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String setIsCountryUE(String tipusSucursal) {
		for (String country : countriesUE) {
			if(country.equalsIgnoreCase(tipusSucursal)){
				return "UE";
			}
		}
		return "Fora UE";
	}
	@Override
	public String toString() {
		return "Sucursal [id=" + pk_SucursalID + ", nom=" + nomSucursal + ", paisSucursal=" + paisSucursal +", tipusSurcursal="+ tipusSucursal +"]";
	}
}
