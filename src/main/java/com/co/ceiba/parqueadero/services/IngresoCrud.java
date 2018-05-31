package com.co.ceiba.parqueadero.services;
import java.util.Calendar;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.business.IngresoBusiness;
import com.co.ceiba.parqueadero.business.ParqueaderoBusiness;
import com.co.ceiba.parqueadero.entity.Carro;
import com.co.ceiba.parqueadero.entity.Ingreso;
import com.co.ceiba.parqueadero.entity.Moto;
import com.co.ceiba.parqueadero.entity.Parqueadero;
import com.co.ceiba.parqueadero.repository.ICarroRepository;
import com.co.ceiba.parqueadero.repository.IIngresoRepository;
import com.co.ceiba.parqueadero.repository.IMotoRepository;
import com.co.ceiba.parqueadero.repository.IParqueaderoRepository;

@RestController
@RequestMapping("/Registro")
public class IngresoCrud {
	
	public ParqueaderoBusiness npaqueadero ;
	public IngresoBusiness ningreso;
	
	public static final int CARRO=1;
	public static final int MOTO=2;
	
	@Autowired
	public IIngresoRepository ingresorepository;
	
	@Autowired
	public ICarroRepository carrorepository;
	
	@Autowired
	public IMotoRepository motorepository;
	
	@Autowired
	public IParqueaderoRepository parqueaderorepository;
	
	@RequestMapping(value="/addIngreso", consumes="application/json", method=RequestMethod.POST)
	public void save(@RequestBody String ingreso) {
		Ingreso ingre =new Ingreso();
		Moto moto =new Moto();
		Carro carro=new Carro();
		Parqueadero parqueadero =new Parqueadero();
		try {
			JSONObject objIngre = new JSONObject(ingreso);
			
			ingre.setTipoVehiculo(objIngre.getInt("tipoVehiculo"));
			ingre.setPlaca(objIngre.getString("placa"));
			ingre.setFechaIngreso(Calendar.getInstance());
			int tipo;
			
			IngresoBusiness ningreso =new IngresoBusiness(); 
			boolean vingreso= ningreso.validarDiaIngreso(ingre.getFechaIngreso(), ingre.getPlaca());
			
			if(vingreso==false) {
				
			ParqueaderoBusiness nparqueadero =new ParqueaderoBusiness(); 
			
			
				
			if(( tipo =ingre.getTipoVehiculo())==2) {
			ingre.setCilindraje(objIngre.getInt("cilindraje"));
			moto.setCilindraje(objIngre.getInt("cilindraje"));
			moto.setPlaca(objIngre.getString("placa"));
			motorepository.save(moto);
			
			
			}else {
			carro.setPlaca(objIngre.getString("placa"));
			carrorepository.save(carro);
			
			ingre.setCilindraje(-1);
			}
			
			ingresorepository.save(ingre);}
		}catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	}
}


