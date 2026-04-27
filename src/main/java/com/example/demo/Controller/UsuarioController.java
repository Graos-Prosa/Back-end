package com.example.demo.Controller;

import com.example.demo.DTO.Endereco.EnderecoDTO;
import com.example.demo.DTO.Pedido.PedidoDTO;
import com.example.demo.DTO.Usuario.UsuarioDTO;
import com.example.demo.DTO.Usuario.UsuarioUpdateDTO;
import com.example.demo.Service.EnderecoService;
import com.example.demo.Service.PedidoService;
import com.example.demo.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuarios", description = "API para gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;
    private final PedidoService pedidoService;

    public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService, PedidoService pedidoService) {
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar um usuário", description = "Retorna usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso",content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public UsuarioDTO findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Listar usuários", description = "Retorna todos os usuários cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public UsuarioDTO update(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDTO dto) {
        return usuarioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário", description = "Remove um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @GetMapping("/{id}/enderecos")
    @Operation(summary = "Listar endereços de usuário", description = "Retorna todos os endereços cadastrados do usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public List<EnderecoDTO> findAllEndereco(@PathVariable Long id) {
        return enderecoService.buscarPorUsuario(id);
    }

    @GetMapping("/{id}/pedidos")
    @Operation(summary = "Listar pedidos de usuário", description = "Retorna todos os pedidos efetuados do usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public List<PedidoDTO> findAllPedido(@PathVariable Long id) {
        return pedidoService.buscarPorUsuario(id);
    }
}