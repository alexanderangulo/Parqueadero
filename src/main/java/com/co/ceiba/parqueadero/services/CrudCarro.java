package com.co.ceiba.parqueadero.services;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.entity.Carro;
import com.co.ceiba.parqueadero.repository.ICarroRepository;

@RestController
@RequestMapping("/carro")
public class CrudCarro {

	@Autowired
	public ICarroRepository crepository;
	
	@RequestMapping(value="/addIngreso", consumes="application/json", method=RequestMethod.POST)
	public List<Carro> save(@RequestBody String carro) {
		Carro car = new Carro();
		try {
			JSONObject objCar = new JSONObject(carro);
			car.setPlaca(objCar.getString("placa"));
			crepository.save(car);
			return (List<Carro>) crepository.findAll();
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
