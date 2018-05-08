package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {


    /**
     * Parse the JSON data using JSONObject and JSONArray
     */
    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwich = new JSONObject(json);
        JSONObject sandwichNames = sandwich.getJSONObject("name");
        String mainName = sandwichNames.getString("mainName");

        JSONArray akaList = sandwichNames.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < akaList.length(); i++) {
            alsoKnownAs.add(akaList.getString(i));
        }

        String placeOfOrigin = sandwich.getString("placeOfOrigin");
        String description = sandwich.getString("description");
        String image = sandwich.getString("image");

        JSONArray ingredientList = sandwich.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientList.length(); i++) {
            ingredients.add(ingredientList.getString(i));
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
