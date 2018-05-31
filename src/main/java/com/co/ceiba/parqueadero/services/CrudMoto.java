package com.co.ceiba.parqueadero.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.ceiba.parqueadero.entity.Moto;
import com.co.ceiba.parqueadero.repository.IMotoRepository;
@RestController
@RequestMapping("/moto")
public class CrudMoto {
	@Autowired
	public IMotoRepository mrepository;
	
	@RequestMapping(value="/addIngreso", consumes="application/json", method=RequestMethod.POST)
	public void save(@RequestBody String moto) {
		Moto mot = new Moto();
		try {
			JSONObject objMot = new JSONObject(moto);
			mot.setPlaca(objMot.getString("placa"));
			mrepository.save(mot);
			
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
