package com.revature.dao;

import java.util.List;

import com.revature.model.BoringPokemon;

public interface BoringPokemonDao {

	List<BoringPokemon> getAllPokemon();
	BoringPokemon getBoringPokemon(String name);
}
