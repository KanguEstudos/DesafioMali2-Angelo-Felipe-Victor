package br.com.kangu.mshippingsimulator.controllers;

import br.com.kangu.mshippingsimulator.entities.Simulation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParse {

    private String jsonString;

    public JsonParse(String json) {
        System.out.println(json);
        this.jsonString = json;
    }

    public ArrayList<Simulation> gatData() throws Exception {

        if(!this.isValid(this.jsonString)) {
            throw new Exception();
        }

        JSONArray courses = new JSONArray(this.jsonString);
        ArrayList<Simulation> arrayData = new ArrayList<Simulation>();

        for (int i = 0; i < courses.length(); i++) {

            JSONObject obRead = new JSONObject(courses.get(i).toString());

            Double vlrFrete    = obRead.getDouble("vlrFrete");
            Integer prazoEnt   = obRead.getInt("prazoEnt");
            String dtPrevEnt   = obRead.getString("dtPrevEnt");
            String transp_nome = obRead.getString("transp_nome");
            String descricao   = obRead.getString("descricao");
            Long idSimulacao   = obRead.getLong("idSimulacao");

            Simulation simulation = new Simulation(vlrFrete, prazoEnt, dtPrevEnt, transp_nome, descricao, idSimulacao);
            arrayData.add(simulation);
        }

        return arrayData;

    }

    public boolean isValid(String json) {

        try {
            new JSONArray(json);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

}
