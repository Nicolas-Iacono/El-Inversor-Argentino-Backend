package com.ia.inv_arg.DTO.salida;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ia.inv_arg.entity.Article;
import com.ia.inv_arg.entity.Favourites;
import com.ia.inv_arg.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"username","firstname","lastname","email","roles","jwt","status"})
public class TokenSalidaDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Set<ArticleAuthorSalidaDto> articlesSalida;
    private List<Role> roles;
    String message;
    String jwt;
    boolean status;

    public TokenSalidaDto(Long id, String username, String firstname, String lastname, String email, Set<ArticleAuthorSalidaDto> articlesSalida, List<Role> roles, String message, String jwt, boolean status) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.articlesSalida = articlesSalida;
        this.roles = roles;
        this.message = message;
        this.jwt = jwt;
        this.status = status;
    }

    public <E> TokenSalidaDto(Long id, String username, String lastname, String email, String firstname, ArrayList<E> es) {
    }

    public TokenSalidaDto(Long id, String username, String lastname, String email, String firstname, Set<Favourites> favourites, ArrayList<Role> roles) {
    }

    public <E> TokenSalidaDto(Long id, String username, String lastname, String email, String firstname, List<Article> articles, Set<Favourites> favourites, ArrayList<E> es) {
    }
}
