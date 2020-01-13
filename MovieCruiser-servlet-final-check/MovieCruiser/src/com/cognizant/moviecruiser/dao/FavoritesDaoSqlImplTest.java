package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoritesMovie() throws FavoritesEmptyException {
		long userId = 1l;
		new FavoritesDaoSqlImpl().addFavoritesMovie(userId, 5);
		testGetAllFavoritesMovie();
	}

	public static void testGetAllFavoritesMovie() throws FavoritesEmptyException {
		List<Movies> list = new ArrayList<>();
		long userId = 1l;
		FavoritesDaoSqlImpl moviesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = moviesDaoSqlImpl.getAllFavoritesMovies(userId);
		list = favorites.getMoviesList();
		System.out.format("%-10s%-20s%-15s%-15s", "ID", "TITLE", "GROSS", "GENRE");
		for (Movies menuItem : list) {
			System.out.format("\n%-10s%-20s%-15s%-15s", menuItem.getId(), menuItem.getTitle(), menuItem.getGross(),
					menuItem.getGenre());
		}
		System.out.println("\nNo. Of Favorites :" + favorites.getTotal());
	}

	public static void testRemoveFavoritesMovie() throws FavoritesEmptyException {
		long userId = 1l;
		new FavoritesDaoSqlImpl().removeFavoritesMovie(userId, 5);
		testGetAllFavoritesMovie();
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovie();
		testGetAllFavoritesMovie();
		testRemoveFavoritesMovie();
	}
}
