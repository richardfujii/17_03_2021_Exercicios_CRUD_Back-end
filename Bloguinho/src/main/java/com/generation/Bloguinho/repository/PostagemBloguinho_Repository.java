package com.generation.Bloguinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.Bloguinho.model.PostagemBloguinho;

@Repository
public interface PostagemBloguinho_Repository extends JpaRepository<PostagemBloguinho, Long>{
	public List<PostagemBloguinho> getAllByTitleContainingIgnoreCase (String title);
}
