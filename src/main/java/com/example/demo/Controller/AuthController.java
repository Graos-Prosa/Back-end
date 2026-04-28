package com.example.demo.Controller;


import com.example.demo.DTO.Auth.LoginGoogleDTO;
import com.example.demo.DTO.Auth.LoginRequestDTO;
import com.example.demo.DTO.Auth.LoginRespostaDTO;
import com.example.demo.DTO.Auth.RegistroRequestDTO;
import com.example.demo.Exception.ApiError;
import com.example.demo.Model.Credencial;
import com.example.demo.DTO.Auth.GoogleUserData;
import com.example.demo.Repository.CredencialRepository;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.GoogleService;
import com.example.demo.Service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacao")
@Tag(name = "Authenticacao", description = "API para gerenciamento de autenticações")
public class AuthController {

    private final AuthService authService;
    private final CredencialRepository credencialRepository;
    private final GoogleService googleService;
    private final TokenService tokenService;

    public AuthController(AuthService authService, CredencialRepository credencialRepository, GoogleService googleService, TokenService tokenService) {
        this.authService = authService;
        this.credencialRepository = credencialRepository;
        this.googleService = googleService;
        this.tokenService = tokenService;
    }

    //@Valid funciona para o controller validar as anotações colocadas nos DTOs
    @PostMapping("/registro")
    @Operation(summary = "Realizar cadastro", description = "Realiza um novo cadastro de usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginRespostaDTO registro(@RequestBody @Valid RegistroRequestDTO registroRequestDTO) {
        return authService.registrar(registroRequestDTO);
    }

    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Realiza um acesso de login de usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginRespostaDTO login(@RequestBody @Valid LoginRequestDTO dto) {
        return authService.verificarAutenticidade(dto);
    }

    @PostMapping("/google")
    @Operation(summary = "Realizar cadastro com API do Google", description = "Realiza um novo cadastro de usuário no sistema utilizando API do Google")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro com Google realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public LoginRespostaDTO loginGoogle(@RequestBody LoginGoogleDTO dto) {
        return googleService.logarComGoogle(dto);
    }

    /* decidir se isso vai ficar assim
    @GetMapping("/eu")
    public UsuarioDTO eu(Authentication authentication) {
        Credencial credencial = (Credencial) authentication.getPrincipal();
        return new UsuarioDTO(credencial.getUsuario());
    }*/
}
