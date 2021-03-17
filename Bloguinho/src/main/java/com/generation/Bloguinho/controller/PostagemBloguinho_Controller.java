package com.generation.Bloguinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Bloguinho.model.PostagemBloguinho;
import com.generation.Bloguinho.repository.PostagemBloguinho_Repository;

@RestController
@RequestMapping("/postBloguinho")
@CrossOrigin("*")
public class PostagemBloguinho_Controller {
	
	@Autowired
	private PostagemBloguinho_Repository repositoy;
	
	@GetMapping
	public ResponseEntity<List<PostagemBloguinho>> FindAllPostagemBloguinho(){
		return ResponseEntity.ok(repositoy.findAll());
	}
	
	@GetMapping("/{idd}")
	public ResponseEntity<PostagemBloguinho> findByIDPostagemBloguinho(@PathVariable long idd){
		return repositoy.findById(idd).map(answer -> ResponseEntity.ok(answer)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<PostagemBloguinho>> getByTitulo(@PathVariable String title){
		return ResponseEntity.ok(repositoy.getAllByTitleContainingIgnoreCase(title));
	}
	

}
